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
    key = 'fc4ec27f-0b0a-4869-b2d4-835fa0b2e0bc'
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

@app.route('/quiz/JuniorDotNet', methods=['GET', 'POST'])
def quiz_JuniorDotNet():
    from datetime import datetime
    now = datetime.now()
    if request.method == 'POST':
        total_score = 0
        responses = []
        # بررسی سوال: JuniorDotNet_q1
        ans = request.form.get('JuniorDotNet_q1')
        is_correct = (ans == 'JuniorDotNet_q1_o1')
        q_score = 4 if is_correct else 0
        total_score += q_score
        responses.append(UserResponse(question_name='JuniorDotNet_q1', answer=ans, correct=is_correct, score_value=q_score))
        # بررسی سوال: JuniorDotNet_q2
        ans = request.form.get('JuniorDotNet_q2')
        is_correct = (ans == 'JuniorDotNet_q2_o2')
        q_score = 4 if is_correct else 0
        total_score += q_score
        responses.append(UserResponse(question_name='JuniorDotNet_q2', answer=ans, correct=is_correct, score_value=q_score))
        # بررسی سوال: JuniorDotNet_q3
        ans = request.form.get('JuniorDotNet_q3')
        is_correct = (ans == 'JuniorDotNet_q3_o1')
        q_score = 4 if is_correct else 0
        total_score += q_score
        responses.append(UserResponse(question_name='JuniorDotNet_q3', answer=ans, correct=is_correct, score_value=q_score))
        # بررسی سوال: JuniorDotNet_q4
        ans = request.form.get('JuniorDotNet_q4')
        is_correct = (ans == 'JuniorDotNet_q4_o1')
        q_score = 4 if is_correct else 0
        total_score += q_score
        responses.append(UserResponse(question_name='JuniorDotNet_q4', answer=ans, correct=is_correct, score_value=q_score))
        # بررسی سوال: JuniorDotNet_q5
        ans = request.form.get('JuniorDotNet_q5')
        is_correct = (ans == 'JuniorDotNet_q5_o1')
        q_score = 4 if is_correct else 0
        total_score += q_score
        responses.append(UserResponse(question_name='JuniorDotNet_q5', answer=ans, correct=is_correct, score_value=q_score))
        res = QuizResult(name=f"RES_{session.get('user_id')}_{int(now.timestamp())}", 
                         user_id=session.get('user_id'), quiz_name='JuniorDotNet', 
                         finalScore=total_score, responses=responses)
        db.session.add(res)
        db.session.commit()
        # هدایت کاربر بر اساس وضعیت لاگین
        if session.get('user_id'):
            return redirect(url_for('my_results'))
        else:
            return "<script>alert('پاسخ شما با موفقیت ثبت شد. برای مشاهده سوابق باید عضو شوید.'); window.location='/';</script>"

    return render_template('quiz_JuniorDotNet.html')

@app.route('/quiz/MidDotNet', methods=['GET', 'POST'])
def quiz_MidDotNet():
    from datetime import datetime
    now = datetime.now()
    if request.method == 'POST':
        total_score = 0
        responses = []
        # بررسی سوال: MidDotNet_q1
        ans = request.form.get('MidDotNet_q1')
        is_correct = (ans == 'MidDotNet_q1_o1')
        q_score = 4 if is_correct else 0
        total_score += q_score
        responses.append(UserResponse(question_name='MidDotNet_q1', answer=ans, correct=is_correct, score_value=q_score))
        # بررسی سوال: MidDotNet_q2
        ans = request.form.get('MidDotNet_q2')
        is_correct = (ans == 'MidDotNet_q2_o1')
        q_score = 4 if is_correct else 0
        total_score += q_score
        responses.append(UserResponse(question_name='MidDotNet_q2', answer=ans, correct=is_correct, score_value=q_score))
        # بررسی سوال: MidDotNet_q3
        ans = request.form.get('MidDotNet_q3')
        is_correct = (ans == 'MidDotNet_q3_o1')
        q_score = 4 if is_correct else 0
        total_score += q_score
        responses.append(UserResponse(question_name='MidDotNet_q3', answer=ans, correct=is_correct, score_value=q_score))
        # بررسی سوال: MidDotNet_q4
        ans = request.form.get('MidDotNet_q4')
        is_correct = (ans == 'MidDotNet_q4_o1')
        q_score = 4 if is_correct else 0
        total_score += q_score
        responses.append(UserResponse(question_name='MidDotNet_q4', answer=ans, correct=is_correct, score_value=q_score))
        # بررسی سوال: MidDotNet_q5
        ans = request.form.get('MidDotNet_q5')
        is_correct = (ans == 'MidDotNet_q5_o1')
        q_score = 4 if is_correct else 0
        total_score += q_score
        responses.append(UserResponse(question_name='MidDotNet_q5', answer=ans, correct=is_correct, score_value=q_score))
        res = QuizResult(name=f"RES_{session.get('user_id')}_{int(now.timestamp())}", 
                         user_id=session.get('user_id'), quiz_name='MidDotNet', 
                         finalScore=total_score, responses=responses)
        db.session.add(res)
        db.session.commit()
        # هدایت کاربر بر اساس وضعیت لاگین
        if session.get('user_id'):
            return redirect(url_for('my_results'))
        else:
            return "<script>alert('پاسخ شما با موفقیت ثبت شد. برای مشاهده سوابق باید عضو شوید.'); window.location='/';</script>"

    return render_template('quiz_MidDotNet.html')

@app.route('/quiz/SeniorDotNet', methods=['GET', 'POST'])
def quiz_SeniorDotNet():
    from datetime import datetime
    now = datetime.now()
    if request.method == 'POST':
        total_score = 0
        responses = []
        # بررسی سوال: SeniorDotNet_q1
        ans = request.form.get('SeniorDotNet_q1')
        is_correct = (ans == 'SeniorDotNet_q1_o1')
        q_score = 4 if is_correct else 0
        total_score += q_score
        responses.append(UserResponse(question_name='SeniorDotNet_q1', answer=ans, correct=is_correct, score_value=q_score))
        # بررسی سوال: SeniorDotNet_q2
        ans = request.form.get('SeniorDotNet_q2')
        is_correct = (ans == 'SeniorDotNet_q2_o1')
        q_score = 4 if is_correct else 0
        total_score += q_score
        responses.append(UserResponse(question_name='SeniorDotNet_q2', answer=ans, correct=is_correct, score_value=q_score))
        # بررسی سوال: SeniorDotNet_q3
        ans = request.form.get('SeniorDotNet_q3')
        is_correct = (ans == 'SeniorDotNet_q3_o1')
        q_score = 4 if is_correct else 0
        total_score += q_score
        responses.append(UserResponse(question_name='SeniorDotNet_q3', answer=ans, correct=is_correct, score_value=q_score))
        # بررسی سوال: SeniorDotNet_q4
        ans = request.form.get('SeniorDotNet_q4')
        is_correct = (ans == 'SeniorDotNet_q4_o1')
        q_score = 4 if is_correct else 0
        total_score += q_score
        responses.append(UserResponse(question_name='SeniorDotNet_q4', answer=ans, correct=is_correct, score_value=q_score))
        # بررسی سوال: SeniorDotNet_q5
        ans = request.form.get('SeniorDotNet_q5')
        is_correct = (ans == 'SeniorDotNet_q5_o1')
        q_score = 4 if is_correct else 0
        total_score += q_score
        responses.append(UserResponse(question_name='SeniorDotNet_q5', answer=ans, correct=is_correct, score_value=q_score))
        res = QuizResult(name=f"RES_{session.get('user_id')}_{int(now.timestamp())}", 
                         user_id=session.get('user_id'), quiz_name='SeniorDotNet', 
                         finalScore=total_score, responses=responses)
        db.session.add(res)
        db.session.commit()
        # هدایت کاربر بر اساس وضعیت لاگین
        if session.get('user_id'):
            return redirect(url_for('my_results'))
        else:
            return "<script>alert('پاسخ شما با موفقیت ثبت شد. برای مشاهده سوابق باید عضو شوید.'); window.location='/';</script>"

    return render_template('quiz_SeniorDotNet.html')

@app.route('/my-results')
@login_required
def my_results():
    db_results = QuizResult.query.filter_by(user_id=session.get('user_id')).order_by(QuizResult.id.desc()).all()
    enhanced_results = []
    # پردازش نتایج مربوط به آزمون: JuniorDotNet
    for res in [r for r in db_results if r.quiz_name == 'JuniorDotNet']:
        enhanced_results.append({
            'id': res.id,
            'quiz_id': res.name,
            'quiz_name': 'مقدماتی',
            'finalScore': res.finalScore,
            'maxScore': 20,
            'show_result': True
        })
    # پردازش نتایج مربوط به آزمون: MidDotNet
    for res in [r for r in db_results if r.quiz_name == 'MidDotNet']:
        enhanced_results.append({
            'id': res.id,
            'quiz_id': res.name,
            'quiz_name': 'متوسطه',
            'finalScore': res.finalScore,
            'maxScore': 20,
            'show_result': True
        })
    # پردازش نتایج مربوط به آزمون: SeniorDotNet
    for res in [r for r in db_results if r.quiz_name == 'SeniorDotNet']:
        enhanced_results.append({
            'id': res.id,
            'quiz_id': res.name,
            'quiz_name': 'پیشرفته',
            'finalScore': res.finalScore,
            'maxScore': 20,
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
    if res.quiz_name == 'JuniorDotNet':
        user_resp = next((r for r in res.responses if r.question_name == 'JuniorDotNet_q1'), None)
        raw_ans = user_resp.answer if user_resp else None
        display_ans = 'بدون پاسخ'
        if raw_ans:
            mapping = {'JuniorDotNet_q1_o1': 'Runtime Environment', 'JuniorDotNet_q1_o2': 'Compiler', 'JuniorDotNet_q1_o3': 'IDE', 'JuniorDotNet_q1_o4': 'Framework', }
            display_ans = mapping.get(raw_ans, raw_ans)
        responses_list.append({
            'question_text': "CLR چیست؟",
            'answer': display_ans,
            'correct': user_resp.correct if user_resp else None,
            'max_q_score': 4,
            'earned_q_score': user_resp.score_value if user_resp else 0
        })
        user_resp = next((r for r in res.responses if r.question_name == 'JuniorDotNet_q2'), None)
        raw_ans = user_resp.answer if user_resp else None
        display_ans = 'بدون پاسخ'
        if raw_ans:
            mapping = {'JuniorDotNet_q2_o1': '2 Byte', 'JuniorDotNet_q2_o2': '4 Byte', 'JuniorDotNet_q2_o3': '8 Byte', 'JuniorDotNet_q2_o4': '1 Byte', }
            display_ans = mapping.get(raw_ans, raw_ans)
        responses_list.append({
            'question_text': "سایز int؟",
            'answer': display_ans,
            'correct': user_resp.correct if user_resp else None,
            'max_q_score': 4,
            'earned_q_score': user_resp.score_value if user_resp else 0
        })
        user_resp = next((r for r in res.responses if r.question_name == 'JuniorDotNet_q3'), None)
        raw_ans = user_resp.answer if user_resp else None
        display_ans = 'بدون پاسخ'
        if raw_ans:
            mapping = {'JuniorDotNet_q3_o1': 'Value vs Reference Type', 'JuniorDotNet_q3_o2': 'Struct is abstract', 'JuniorDotNet_q3_o3': 'Class is immutable', 'JuniorDotNet_q3_o4': 'They are identical', }
            display_ans = mapping.get(raw_ans, raw_ans)
        responses_list.append({
            'question_text': "تفاوت Struct و Class؟",
            'answer': display_ans,
            'correct': user_resp.correct if user_resp else None,
            'max_q_score': 4,
            'earned_q_score': user_resp.score_value if user_resp else 0
        })
        user_resp = next((r for r in res.responses if r.question_name == 'JuniorDotNet_q4'), None)
        raw_ans = user_resp.answer if user_resp else None
        display_ans = 'بدون پاسخ'
        if raw_ans:
            mapping = {'JuniorDotNet_q4_o1': 'Func<T, TResult>', 'JuniorDotNet_q4_o2': 'Class', 'JuniorDotNet_q4_o3': 'Struct', 'JuniorDotNet_q4_o4': 'Enum', }
            display_ans = mapping.get(raw_ans, raw_ans)
        responses_list.append({
            'question_text': "کدام یک از موارد زیر یک delegate است؟",
            'answer': display_ans,
            'correct': user_resp.correct if user_resp else None,
            'max_q_score': 4,
            'earned_q_score': user_resp.score_value if user_resp else 0
        })
        user_resp = next((r for r in res.responses if r.question_name == 'JuniorDotNet_q5'), None)
        raw_ans = user_resp.answer if user_resp else None
        display_ans = 'بدون پاسخ'
        if raw_ans:
            mapping = {'JuniorDotNet_q5_o1': 'Dependency Injection', 'JuniorDotNet_q5_o2': 'Garbage Collection', 'JuniorDotNet_q5_o3': 'JIT Compilation', 'JuniorDotNet_q5_o4': 'Reflection', }
            display_ans = mapping.get(raw_ans, raw_ans)
        responses_list.append({
            'question_text': "کدام یک از موارد زیر برای مدیریت وابستگی‌ها استفاده می‌شود؟",
            'answer': display_ans,
            'correct': user_resp.correct if user_resp else None,
            'max_q_score': 4,
            'earned_q_score': user_resp.score_value if user_resp else 0
        })
    if res.quiz_name == 'MidDotNet':
        user_resp = next((r for r in res.responses if r.question_name == 'MidDotNet_q1'), None)
        raw_ans = user_resp.answer if user_resp else None
        display_ans = 'بدون پاسخ'
        if raw_ans:
            mapping = {'MidDotNet_q1_o1': 'Language Integrated Query', 'MidDotNet_q1_o2': 'Library Integrated Query', 'MidDotNet_q1_o3': 'Logical Integrated Query', 'MidDotNet_q1_o4': 'Linked Integrated Query', }
            display_ans = mapping.get(raw_ans, raw_ans)
        responses_list.append({
            'question_text': "LINQ مخفف چیست؟",
            'answer': display_ans,
            'correct': user_resp.correct if user_resp else None,
            'max_q_score': 4,
            'earned_q_score': user_resp.score_value if user_resp else 0
        })
        user_resp = next((r for r in res.responses if r.question_name == 'MidDotNet_q2'), None)
        raw_ans = user_resp.answer if user_resp else None
        display_ans = 'بدون پاسخ'
        if raw_ans:
            mapping = {'MidDotNet_q2_o1': 'Task-based asynchronous programming', 'MidDotNet_q2_o2': 'UI Design', 'MidDotNet_q2_o3': 'Database Connection', 'MidDotNet_q2_o4': 'File Management', }
            display_ans = mapping.get(raw_ans, raw_ans)
        responses_list.append({
            'question_text': "Async/Await برای چه منظوری استفاده می‌شود؟",
            'answer': display_ans,
            'correct': user_resp.correct if user_resp else None,
            'max_q_score': 4,
            'earned_q_score': user_resp.score_value if user_resp else 0
        })
        user_resp = next((r for r in res.responses if r.question_name == 'MidDotNet_q3'), None)
        raw_ans = user_resp.answer if user_resp else None
        display_ans = 'بدون پاسخ'
        if raw_ans:
            mapping = {'MidDotNet_q3_o1': 'List is dynamic, Array is fixed size', 'MidDotNet_q3_o2': 'Array is dynamic, List is fixed size', 'MidDotNet_q3_o3': 'They are identical', 'MidDotNet_q3_o4': 'List is only for integers', }
            display_ans = mapping.get(raw_ans, raw_ans)
        responses_list.append({
            'question_text': "تفاوت بین List و Array چیست؟",
            'answer': display_ans,
            'correct': user_resp.correct if user_resp else None,
            'max_q_score': 4,
            'earned_q_score': user_resp.score_value if user_resp else 0
        })
        user_resp = next((r for r in res.responses if r.question_name == 'MidDotNet_q4'), None)
        raw_ans = user_resp.answer if user_resp else None
        display_ans = 'بدون پاسخ'
        if raw_ans:
            mapping = {'MidDotNet_q4_o1': 'IEnumerable<T>', 'MidDotNet_q4_o2': 'IComparable', 'MidDotNet_q4_o3': 'ICloneable', 'MidDotNet_q4_o4': 'IDisposable', }
            display_ans = mapping.get(raw_ans, raw_ans)
        responses_list.append({
            'question_text': "کدام یک از موارد زیر یک Generic Interface است؟",
            'answer': display_ans,
            'correct': user_resp.correct if user_resp else None,
            'max_q_score': 4,
            'earned_q_score': user_resp.score_value if user_resp else 0
        })
        user_resp = next((r for r in res.responses if r.question_name == 'MidDotNet_q5'), None)
        raw_ans = user_resp.answer if user_resp else None
        display_ans = 'بدون پاسخ'
        if raw_ans:
            mapping = {'MidDotNet_q5_o1': 'Metadata', 'MidDotNet_q5_o2': 'Error Handling', 'MidDotNet_q5_o3': 'Performance Optimization', 'MidDotNet_q5_o4': 'Security', }
            display_ans = mapping.get(raw_ans, raw_ans)
        responses_list.append({
            'question_text': "هدف از استفاده از Attributeها چیست؟",
            'answer': display_ans,
            'correct': user_resp.correct if user_resp else None,
            'max_q_score': 4,
            'earned_q_score': user_resp.score_value if user_resp else 0
        })
    if res.quiz_name == 'SeniorDotNet':
        user_resp = next((r for r in res.responses if r.question_name == 'SeniorDotNet_q1'), None)
        raw_ans = user_resp.answer if user_resp else None
        display_ans = 'بدون پاسخ'
        if raw_ans:
            mapping = {'SeniorDotNet_q1_o1': 'Zero-copy memory access', 'SeniorDotNet_q1_o2': 'Automatic garbage collection', 'SeniorDotNet_q1_o3': 'Faster compilation', 'SeniorDotNet_q1_o4': 'Smaller memory footprint', }
            display_ans = mapping.get(raw_ans, raw_ans)
        responses_list.append({
            'question_text': "Span<T> چه مزایایی نسبت به Array دارد؟",
            'answer': display_ans,
            'correct': user_resp.correct if user_resp else None,
            'max_q_score': 4,
            'earned_q_score': user_resp.score_value if user_resp else 0
        })
        user_resp = next((r for r in res.responses if r.question_name == 'SeniorDotNet_q2'), None)
        raw_ans = user_resp.answer if user_resp else None
        display_ans = 'بدون پاسخ'
        if raw_ans:
            mapping = {'SeniorDotNet_q2_o1': 'Streaming data asynchronously', 'SeniorDotNet_q2_o2': 'Blocking calls', 'SeniorDotNet_q2_o3': 'Parallel processing', 'SeniorDotNet_q2_o4': 'Data validation', }
            display_ans = mapping.get(raw_ans, raw_ans)
        responses_list.append({
            'question_text': "IAsyncEnumerable<T> برای چه منظوری استفاده می‌شود؟",
            'answer': display_ans,
            'correct': user_resp.correct if user_resp else None,
            'max_q_score': 4,
            'earned_q_score': user_resp.score_value if user_resp else 0
        })
        user_resp = next((r for r in res.responses if r.question_name == 'SeniorDotNet_q3'), None)
        raw_ans = user_resp.answer if user_resp else None
        display_ans = 'بدون پاسخ'
        if raw_ans:
            mapping = {'SeniorDotNet_q3_o1': 'Just-In-Time Compilation', 'SeniorDotNet_q3_o2': 'Java Integrated Tool', 'SeniorDotNet_q3_o3': 'JavaScript Implementation Technique', 'SeniorDotNet_q3_o4': 'Joint Interface Technology', }
            display_ans = mapping.get(raw_ans, raw_ans)
        responses_list.append({
            'question_text': "JIT Compilation چیست؟",
            'answer': display_ans,
            'correct': user_resp.correct if user_resp else None,
            'max_q_score': 4,
            'earned_q_score': user_resp.score_value if user_resp else 0
        })
        user_resp = next((r for r in res.responses if r.question_name == 'SeniorDotNet_q4'), None)
        raw_ans = user_resp.answer if user_resp else None
        display_ans = 'بدون پاسخ'
        if raw_ans:
            mapping = {'SeniorDotNet_q4_o1': 'ValueTask avoids heap allocation', 'SeniorDotNet_q4_o2': 'Task is always asynchronous', 'SeniorDotNet_q4_o3': 'ValueTask is synchronous', 'SeniorDotNet_q4_o4': 'They are identical', }
            display_ans = mapping.get(raw_ans, raw_ans)
        responses_list.append({
            'question_text': "چه تفاوتی بین ValueTask و Task وجود دارد؟",
            'answer': display_ans,
            'correct': user_resp.correct if user_resp else None,
            'max_q_score': 4,
            'earned_q_score': user_resp.score_value if user_resp else 0
        })
        user_resp = next((r for r in res.responses if r.question_name == 'SeniorDotNet_q5'), None)
        raw_ans = user_resp.answer if user_resp else None
        display_ans = 'بدون پاسخ'
        if raw_ans:
            mapping = {'SeniorDotNet_q5_o1': 'Compile-time code generation', 'SeniorDotNet_q5_o2': 'Runtime code optimization', 'SeniorDotNet_q5_o3': 'Debugging assistance', 'SeniorDotNet_q5_o4': 'Memory management', }
            display_ans = mapping.get(raw_ans, raw_ans)
        responses_list.append({
            'question_text': "هدف از استفاده از Source Generators چیست؟",
            'answer': display_ans,
            'correct': user_resp.correct if user_resp else None,
            'max_q_score': 4,
            'earned_q_score': user_resp.score_value if user_resp else 0
        })
    return jsonify({'responses': responses_list})

@app.route('/admin')
@admin_required
def admin_dashboard():
    quiz_labels = {
        'JuniorDotNet': 'مقدماتی',
        'MidDotNet': 'متوسطه',
        'SeniorDotNet': 'پیشرفته',
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
    quiz_map = { 'JuniorDotNet': {'label': 'مقدماتی', 'max': 20}, 'MidDotNet': {'label': 'متوسطه', 'max': 20}, 'SeniorDotNet': {'label': 'پیشرفته', 'max': 20}, }

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
        if not User.query.filter_by(username='dotnet_admin').first():
            db.session.add(User(username='dotnet_admin', password='dotnet2024', full_name='مدیر دات نت', role='admin'))
        db.session.commit()
    app.run(debug=True)