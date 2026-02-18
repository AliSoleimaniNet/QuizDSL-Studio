import jwt, os, json
from datetime import datetime, timedelta
from flask import Flask, render_template, request, redirect, url_for, session, flash, jsonify
from models import db, User, QuizResult, UserResponse
from functools import wraps

app = Flask(__name__)

# Persistent Secret Key Management
CONFIG_FILE = 'config.json'
if os.path.exists(CONFIG_FILE):
    with open(CONFIG_FILE, 'r') as f: app.config['SECRET_KEY'] = json.load(f).get('SECRET_KEY')
else:
    key = 'd1282858-6482-4f4c-b9d8-991d9a95b66e'
    app.config['SECRET_KEY'] = key
    with open(CONFIG_FILE, 'w') as f: json.dump({'SECRET_KEY': key}, f)

app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///quiz.db'
db.init_app(app)

def generate_jwt(user):
    payload = {
        'user_id': user.id,
        'username': user.username,
        'role': user.role,
        'exp': datetime.utcnow() + timedelta(hours=24)
    }
    return jwt.encode(payload, app.config['SECRET_KEY'], algorithm='HS256')

# Decorator for Login Required
def login_required(f):
    @wraps(f)
    def decorated_function(*args, **kwargs):
        if 'user_id' not in session:
            return redirect(url_for('login'))
        return f(*args, **kwargs)
    return decorated_function

# Decorator for Admin Access
def admin_required(f):
    @wraps(f)
    def decorated_function(*args, **kwargs):
        if 'user_id' not in session or session.get('role') != 'admin':
            flash('دسترسی غیرمجاز! فقط مدیران مجاز هستند.')
            return redirect(url_for('index'))
        return f(*args, **kwargs)
    return decorated_function

@app.route('/login', methods=['GET', 'POST'])
def login():
    if request.method == 'POST':
        username = request.form.get('username')
        password = request.form.get('password')
        user = User.query.filter_by(username=username, password=password).first()
        if user:
            session['user_id'] = user.id
            session['username'] = user.username
            session['role'] = user.role
            session['token'] = generate_jwt(user)
            return redirect(url_for('index'))
        flash('نام کاربری یا رمز عبور اشتباه است')
    return render_template('login.html')

@app.route('/api/auth-status')
def auth_status():
    if 'user_id' in session:
        user = User.query.get(session['user_id'])
        return jsonify({
            'logged_in': True, 
            'username': user.username, 
            'full_name': user.full_name, 
            'role': user.role, 
            'token': session.get('token')
        })
    return jsonify({'logged_in': False})

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/logout')
def logout():
    session.clear()
    flash('با موفقیت خارج شدید')
    return redirect(url_for('index'))

@app.route('/quiz/JavaBasics', methods=['GET', 'POST'])
def quiz_JavaBasics():
    from datetime import datetime
    now = datetime.now()
    if request.method == 'POST':
        total_score = 0
        responses = []
        # بررسی سوال: JavaBasics_q1
        ans = request.form.get('JavaBasics_q1')
        is_correct = (ans == 'JavaBasics_q1_o1')
        q_score = 2 if is_correct else 0
        total_score += q_score
        responses.append(UserResponse(question_name='JavaBasics_q1', answer=ans, correct=is_correct, score_value=q_score))
        # بررسی سوال: JavaBasics_q2
        ans = request.form.get('JavaBasics_q2')
        is_correct = (ans == 'true')
        q_score = 2 if is_correct else 0
        total_score += q_score
        responses.append(UserResponse(question_name='JavaBasics_q2', answer=ans, correct=is_correct, score_value=q_score))
        # بررسی سوال: JavaBasics_q3
        ans = request.form.get('JavaBasics_q3')
        is_correct = (ans == 'JavaBasics_q3_o1')
        q_score = 2 if is_correct else 0
        total_score += q_score
        responses.append(UserResponse(question_name='JavaBasics_q3', answer=ans, correct=is_correct, score_value=q_score))
        res = QuizResult(name=f"RES_{session.get('user_id')}_{int(now.timestamp())}", 
                         user_id=session.get('user_id'), quiz_name='JavaBasics', 
                         finalScore=total_score, responses=responses)
        db.session.add(res)
        db.session.commit()
        # هدایت کاربر بر اساس وضعیت لاگین
        if session.get('user_id'):
            return redirect(url_for('my_results'))
        else:
            return "<script>alert('پاسخ شما با موفقیت ثبت شد. برای مشاهده سوابق باید عضو شوید.'); window.location='/';</script>"

    return render_template('quiz_JavaBasics.html')

@app.route('/my-results')
@login_required
def my_results():
    db_results = QuizResult.query.filter_by(user_id=session.get('user_id')).order_by(QuizResult.id.desc()).all()
    enhanced_results = []
    # پردازش نتایج مربوط به آزمون: JavaBasics
    for res in [r for r in db_results if r.quiz_name == 'JavaBasics']:
        enhanced_results.append({
            'id': res.id,
            'quiz_id': res.name,
            'quiz_name': 'Java Basics Quiz',
            'finalScore': res.finalScore,
            'maxScore': 10,
            'show_result': True
        })
    return render_template('my_results.html', results=enhanced_results)

@app.route('/api/result/<int:res_id>')
@login_required
def get_result_details(res_id):
    res = QuizResult.query.get_or_404(res_id)
    is_admin = session.get('role') == 'admin'
    if res.user_id != session.get('user_id') and not is_admin:
        return jsonify({'error': 'Unauthorized'}), 403
    
    responses_list = []
    if res.quiz_name == 'JavaBasics':
        user_resp = next((r for r in res.responses if r.question_name == 'JavaBasics_q1'), None)
        raw_ans = user_resp.answer if user_resp else None
        display_ans = 'بدون پاسخ'
        if raw_ans:
            mapping = {'JavaBasics_q1_o1': 'public static void main(String[] args)', 'JavaBasics_q1_o2': 'public static String main()', }
            display_ans = mapping.get(raw_ans, raw_ans)
        responses_list.append({
            'question_text': "What is the main method in Java?",
            'answer': display_ans,
            'correct': user_resp.correct if user_resp else None,
            'max_q_score': 2,
            'earned_q_score': user_resp.score_value if user_resp else 0
        })
        user_resp = next((r for r in res.responses if r.question_name == 'JavaBasics_q2'), None)
        raw_ans = user_resp.answer if user_resp else None
        display_ans = 'بدون پاسخ'
        if raw_ans:
            display_ans = 'صحیح' if raw_ans.lower() == 'true' else 'غلط'
        responses_list.append({
            'question_text': "Java is a compiled language.",
            'answer': display_ans,
            'correct': user_resp.correct if user_resp else None,
            'max_q_score': 2,
            'earned_q_score': user_resp.score_value if user_resp else 0
        })
        user_resp = next((r for r in res.responses if r.question_name == 'JavaBasics_q3'), None)
        raw_ans = user_resp.answer if user_resp else None
        display_ans = 'بدون پاسخ'
        if raw_ans:
            mapping = {'JavaBasics_q3_o1': 'new', 'JavaBasics_q3_o2': 'create', }
            display_ans = mapping.get(raw_ans, raw_ans)
        responses_list.append({
            'question_text': "Which keyword is used to create an object in Java?",
            'answer': display_ans,
            'correct': user_resp.correct if user_resp else None,
            'max_q_score': 2,
            'earned_q_score': user_resp.score_value if user_resp else 0
        })
    return jsonify({'responses': responses_list})

@app.route('/admin')
@admin_required
def admin_dashboard():
    quiz_labels = {
        'JavaBasics': 'Java Basics Quiz',
    }
    # استخراج آمار از دیتابیس
    total_users = User.query.count()
    total_results = QuizResult.query.count()
    admin_count = User.query.filter_by(role='admin').count()
    
    # محاسبه میانگین کل نمرات
    avg_score = db.session.query(db.func.avg(QuizResult.finalScore)).scalar() or 0
    
    # ۵ نتیجه آخر برای نمایش در داشبورد
    recent_results = QuizResult.query.order_by(QuizResult.id.desc()).limit(5).all()
    
    for res in recent_results:
        res.display_name = quiz_labels.get(res.quiz_name)
    stats = {
        'users': total_users,
        'results': total_results,
        'admins': admin_count,
        'avg': round(float(avg_score), 2)
    }
    return render_template('admin_dashboard.html', stats=stats, recent=recent_results)

@app.route('/admin/users')
@admin_required
def admin_users():
    users = User.query.all()
    return render_template('admin_users.html', users=users)

@app.route('/admin/user/add', methods=['POST'])
@admin_required
def add_user():
    u = User(
        username=request.form['username'],
        full_name=request.form['full_name'],
        password=request.form['password'],
        role=request.form['role']
    )
    db.session.add(u)
    db.session.commit()
    return redirect(url_for('admin_users'))

@app.route('/admin/user/edit/<int:id>', methods=['POST'])
@admin_required
def edit_user(id):
    u = User.query.get_or_404(id)
    current_user_id = session.get('user_id')
    if u.id == current_user_id and request.form['role'] != u.role:
        return 'خطا: شما نمی‌توانید نقش خود را تغییر دهید', 400
    if u.role == 'admin' and User.query.filter_by(role='admin').count() <= 1 and request.form['role'] != u.role:
        return 'خطا: آخرین مدیر را نمی‌توان تغییر نقش داد', 400
    u.username = request.form['username']
    u.full_name = request.form['full_name']
    u.role = request.form['role']
    if request.form['password']: u.password = request.form['password']
    db.session.commit()
    return redirect(url_for('admin_users'))

@app.route('/admin/user/delete/<int:id>', methods=['POST'])
@admin_required
def delete_user(id):
    u = User.query.get_or_404(id)
    current_user_id = session.get('user_id')
    if u.id == current_user_id:
        return 'خطا: شما نمی‌توانید خود را حذف کنید', 400
    if u.role == 'admin' and User.query.filter_by(role='admin').count() <= 1:
        return 'خطا: آخرین مدیر را نمی‌توان حذف کرد', 400
    db.session.delete(u)
    db.session.commit()
    return redirect(url_for('admin_users'))

# --- روت مشاهده کل نتایج برای ادمین ---
@app.route('/admin/results')
@admin_required
def admin_results():
    # واکشی تمام نتایج به همراه اطلاعات یوزر مرتبط
    db_results = QuizResult.query.order_by(QuizResult.id.desc()).all()
    all_results_dto = []
    
    # ساخت یک دیکشنری برای دسترسی سریع به برچسب کوییزها
    quiz_map = { 'JavaBasics': {'label': 'Java Basics Quiz', 'max': 10}, }

    for res in db_results:
        user = User.query.get(res.user_id)
        q_info = quiz_map.get(res.quiz_name, {'label': res.quiz_name, 'max': 100})
        all_results_dto.append({
            'id': res.id,
            'user_full_name': user.full_name if user else 'کاربر حذف شده',
            'user_id': res.user_id,
            'quiz_name': q_info['label'],
            'quiz_id': res.name,
            'finalScore': res.finalScore,
            'maxScore': q_info['max']
        })
    return render_template('admin_results.html', all_results=all_results_dto)

if __name__ == '__main__':
    with app.app_context():
        db.create_all()
        if not User.query.filter_by(username='ali_admin').first():
            db.session.add(User(username='ali_admin', password='PassWord', full_name='Ali Soleimani', role='admin'))
        db.session.commit()
    app.run(debug=True)