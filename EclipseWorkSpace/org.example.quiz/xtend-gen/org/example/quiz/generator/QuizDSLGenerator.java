package org.example.quiz.generator;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.example.quiz.quizDSL.*;
import java.util.Iterator;
import java.util.UUID;

import com.google.common.collect.Iterators;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import java.io.InputStream;

public class QuizDSLGenerator extends AbstractGenerator {

	@Override
	public void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		Iterator<QuizGameSystem> it = Iterators.filter(resource.getAllContents(), QuizGameSystem.class);
		if (it.hasNext()) {
			QuizGameSystem system = it.next();
			QuizPlatform platform = system.getPlatform();

			copyImageToStatic(platform.getLogo(), resource, fsa);

			// Backend & DB
			fsa.generateFile("models.py", generateModels());
			fsa.generateFile("app.py", generateApp(system));

			// Frontend Assets
			if (platform.getTheme() != null) {
				fsa.generateFile("static/css/style.css", generateCss(platform.getTheme()));
			}
			// >>> برای مدیریت لاگین <<<
			fsa.generateFile("static/js/auth.js", generateAuthJs());

			// HTML Templates
			fsa.generateFile("templates/base.html", generateBaseHtml(platform));
			fsa.generateFile("templates/admin_base.html", generateAdminBaseHtml());

			fsa.generateFile("templates/index.html", generateIndexHtml(platform));

			fsa.generateFile("templates/my_results.html", generateMyResultsHtml());

			fsa.generateFile("templates/admin_dashboard.html", generateAdminDashboardHtml());
			fsa.generateFile("templates/admin_users.html", generateAdminUsersHtml());
			fsa.generateFile("templates/admin_results.html", generateAdminResultsHtml());

			// Login Page
			fsa.generateFile("templates/login.html", generateLoginHtml(platform));

			for (Quiz quiz : platform.getQuizzes()) {
				copyImageToStatic(quiz.getIcon(), resource, fsa);
				fsa.generateFile("templates/quiz_" + quiz.getName() + ".html", generateQuizPage(quiz));
			}
		}
	}

	private void copyImageToStatic(String imageName, Resource resource, IFileSystemAccess2 fsa) {
		if (imageName == null || imageName.isEmpty())
			return;

		try {
			java.io.InputStream inputStream = null;

			// ۱. تلاش برای خواندن در محیط Eclipse (Platform URI)
			org.eclipse.emf.common.util.URI uri = resource.getURI();

			if (uri.isPlatformResource()) {
				// اگر در محیط اکلیپس هستیم
				org.eclipse.core.resources.IWorkspaceRoot root = org.eclipse.core.resources.ResourcesPlugin
						.getWorkspace().getRoot();
				org.eclipse.core.resources.IFile file = root
						.getFile(new org.eclipse.core.runtime.Path(uri.toPlatformString(true)));
				org.eclipse.core.resources.IContainer parent = file.getParent();
				org.eclipse.core.resources.IFile imageIFile = parent
						.getFile(new org.eclipse.core.runtime.Path(imageName));

				if (imageIFile.exists()) {
					inputStream = imageIFile.getContents();
				}
			} else {
				// ۲. اگر به صورت فایل معمولی در سیستم عامل است (Stand-alone)
				String modelPath = uri.toFileString();
				if (modelPath != null) {
					java.io.File modelFile = new java.io.File(modelPath);
					java.io.File imageFile = new java.io.File(modelFile.getParent(), imageName);
					if (imageFile.exists()) {
						inputStream = new java.io.FileInputStream(imageFile);
					}
				}
			}

			// اگر فایل پیدا شد، آن را کپی کن
			if (inputStream != null) {
				fsa.generateFile("static/images/" + imageName, inputStream);
				inputStream.close();
			} else {
				System.err.println("Image not found: " + imageName);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Could not copy image: " + imageName);
		}
	}

	private String generateModels() {
		return "from flask_sqlalchemy import SQLAlchemy\n" + "from flask_login import UserMixin\n\n"
				+ "db = SQLAlchemy()\n\n" + "class User(db.Model, UserMixin):\n"
				+ "    id = db.Column(db.Integer, primary_key=True)\n"
				+ "    username = db.Column(db.String(80), unique=True)\n"
				+ "    password = db.Column(db.String(120))\n" + "    full_name = db.Column(db.String(100))\n"
				+ "    role = db.Column(db.String(20))\n\n" + "    def to_dict(self):\n" + "        return {\n"
				+ "            'id': self.id,\n" + "            'username': self.username,\n"
				+ "            'full_name': self.full_name,\n" + "            'role': self.role\n" + "        }\n"
				+ "class QuizResult(db.Model):\n" + "    id = db.Column(db.Integer, primary_key=True)\n"
				+ "    name = db.Column(db.String(50)) # ID در DSL\n"
				+ "    user_id = db.Column(db.Integer, db.ForeignKey('user.id'))\n"
				+ "    quiz_name = db.Column(db.String(100)) # ارجاع به Quiz\n"
				+ "    finalScore = db.Column(db.Integer)\n" + "    # رابطه با پاسخ‌ها طبق responses+=UserResponse+\n"
				+ "    responses = db.relationship('UserResponse', backref='result', lazy=True, cascade='all, delete-orphan')\n"
				+ "    user = db.relationship('User', backref='results')\n\n" +

				"class UserResponse(db.Model):\n" + "    id = db.Column(db.Integer, primary_key=True)\n"
				+ "    result_id = db.Column(db.Integer, db.ForeignKey('quiz_result.id'))\n"
				+ "    question_name = db.Column(db.Text) # نام  سوال\n"
				+ "    answer = db.Column(db.String(500)) # provided_answer\n"
				+ "    correct = db.Column(db.Boolean) # is_correct\n"
				+ "    score_value = db.Column(db.Integer, nullable=True) # برای نمایش نمره هر سوال\n";
	}

	private String generateApp(QuizGameSystem system) {
		QuizPlatform p = system.getPlatform();
		StringBuilder sb = new StringBuilder();
		// ایمپورت‌های مورد نیاز برای JWT و فایل سیستم
		sb.append("import jwt, os, json\n");
		sb.append("from datetime import datetime, timedelta\n");
		sb.append("from flask import Flask, render_template, request, redirect, url_for, session, flash, jsonify\n");
		sb.append("from models import db, User, QuizResult, UserResponse\n");
		sb.append("from functools import wraps\n\n");

		sb.append("app = Flask(__name__)\n\n");

		// --- منطق مدیریت SECRET_KEY ثابت در فایل ---
		sb.append("# Persistent Secret Key Management\n");
		sb.append("CONFIG_FILE = 'config.json'\n");
		sb.append("if os.path.exists(CONFIG_FILE):\n");
		sb.append("    with open(CONFIG_FILE, 'r') as f: app.config['SECRET_KEY'] = json.load(f).get('SECRET_KEY')\n");
		sb.append("else:\n");
		sb.append("    key = '").append(UUID.randomUUID().toString()).append("'\n");
		sb.append("    app.config['SECRET_KEY'] = key\n");
		sb.append("    with open(CONFIG_FILE, 'w') as f: json.dump({'SECRET_KEY': key}, f)\n\n");

		sb.append("app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///quiz.db'\n");
		sb.append("db.init_app(app)\n\n");

		// --- تابع کمکی تولید JWT ---
		sb.append("def generate_jwt(user):\n");
		sb.append("    payload = {\n");
		sb.append("        'user_id': user.id,\n");
		sb.append("        'username': user.username,\n");
		sb.append("        'role': user.role,\n");
		sb.append("        'exp': datetime.utcnow() + timedelta(hours=24)\n");
		sb.append("    }\n");
		sb.append("    return jwt.encode(payload, app.config['SECRET_KEY'], algorithm='HS256')\n\n");
		// تعریف Decorator برای چک کردن لاگین معمولی
		sb.append("# Decorator for Login Required\n");
		sb.append("def login_required(f):\n");
		sb.append("    @wraps(f)\n");
		sb.append("    def decorated_function(*args, **kwargs):\n");
		sb.append("        if 'user_id' not in session:\n");
		sb.append("            return redirect(url_for('login'))\n");
		sb.append("        return f(*args, **kwargs)\n");
		sb.append("    return decorated_function\n\n");

		// تعریف Decorator برای چک کردن دسترسی ادمین
		sb.append("# Decorator for Admin Access\n");
		sb.append("def admin_required(f):\n");
		sb.append("    @wraps(f)\n");
		sb.append("    def decorated_function(*args, **kwargs):\n");
		sb.append("        if 'user_id' not in session or session.get('role') != 'admin':\n");
		sb.append("            flash('دسترسی غیرمجاز! فقط مدیران مجاز هستند.')\n");
		sb.append("            return redirect(url_for('index'))\n");
		sb.append("        return f(*args, **kwargs)\n");
		sb.append("    return decorated_function\n\n");
		// اصلاح روت Login برای برگرداندن توکن واقعی
		sb.append("@app.route('/login', methods=['GET', 'POST'])\n");
		sb.append("def login():\n");
		sb.append("    if request.method == 'POST':\n");
		sb.append("        username = request.form.get('username')\n");
		sb.append("        password = request.form.get('password')\n");
		sb.append("        user = User.query.filter_by(username=username, password=password).first()\n");
		sb.append("        if user:\n");
		sb.append("            session['user_id'] = user.id\n");
		sb.append("            session['username'] = user.username\n");
		sb.append("            session['role'] = user.role\n");
		sb.append("            session['token'] = generate_jwt(user)\n"); // ذخیره توکن در سشن
		sb.append("            return redirect(url_for('index'))\n");
		sb.append("        flash('نام کاربری یا رمز عبور اشتباه است')\n");
		sb.append("    return render_template('login.html')\n\n");

		// اصلاح API وضعیت برای بازگرداندن نام کامل و توکن
		sb.append("@app.route('/api/auth-status')\ndef auth_status():\n");
		sb.append("    if 'user_id' in session:\n");
		sb.append("        user = User.query.get(session['user_id'])\n");
		sb.append("        return jsonify({\n");
		sb.append("            'logged_in': True, \n");
		sb.append("            'username': user.username, \n");
		sb.append("            'full_name': user.full_name, \n");
		sb.append("            'role': user.role, \n");
		sb.append("            'token': session.get('token')\n");
		sb.append("        })\n");
		sb.append("    return jsonify({'logged_in': False})\n\n");

		// Routes اصلی

		sb.append("@app.route('/')\ndef index():\n    return render_template('index.html')\n\n");

		// روت خروج از حساب کاربری
		sb.append("@app.route('/logout')\n");
		sb.append("def logout():\n");
		sb.append("    session.clear()\n");
		sb.append("    flash('با موفقیت خارج شدید')\n");
		sb.append("    return redirect(url_for('index'))\n\n");
		// Routes آزمون‌ها با محدودیت ورود
		for (Quiz q : p.getQuizzes()) {
			// در حلقه جنریتور برای هر کوییز
			sb.append("@app.route('/quiz/").append(q.getName()).append("', methods=['GET', 'POST'])\n");
			if (q.getConfig().getAccess() == AccessType.PRIVATE) {
				sb.append("@login_required\n");
			}
			sb.append("def quiz_").append(q.getName()).append("():\n");
			sb.append("    from datetime import datetime\n");
			sb.append("    now = datetime.now()\n");

			// بررسی بازه زمانی آزمون
			if (q.getConfig().getStartTime() != null) {
				sb.append("    start_time = datetime.fromisoformat('").append(q.getConfig().getStartTime())
						.append("')\n");
				sb.append("    if now < start_time:\n");
				sb.append(
						"        return \"<script>alert('آزمون هنوز شروع نشده است'); window.location='/';</script>\", 403\n");
			}
			if (q.getConfig().getEndTime() != null) {
				sb.append("    end_time = datetime.fromisoformat('").append(q.getConfig().getEndTime()).append("')\n");
				sb.append("    if now > end_time:\n");
				sb.append(
						"        return \"<script>alert('مهلت آزمون تمام شده است'); window.location='/';</script>\", 403\n");
			}

			sb.append("    if request.method == 'POST':\n");
			sb.append("        total_score = 0\n");
			sb.append("        responses = []\n");

			for (Question question : q.getQuestions()) {
				sb.append("        # بررسی سوال: ").append(question.getName()).append("\n");
				if (question instanceof SingleChoiceQuestion) {
					SingleChoiceQuestion sc = (SingleChoiceQuestion) question;
					sb.append("        ans = request.form.get('").append(sc.getName()).append("')\n");
					sb.append("        is_correct = (ans == '").append(sc.getCorrectOption().getName()).append("')\n");
					sb.append("        q_score = ").append(sc.getScore() > 0 ? sc.getScore() : 1)
							.append(" if is_correct else 0\n");
					sb.append("        total_score += q_score\n");
					sb.append("        responses.append(UserResponse(question_name='").append(sc.getName())
							.append("', answer=ans, correct=is_correct, score_value=q_score))\n");
				} else if (question instanceof MultipleChoiceQuestion) {
					// در چند انتخابی، لیست گزینه‌ها را می‌گیریم
					sb.append("        ans_list = request.form.getlist('").append(question.getName()).append("[]')\n");
					sb.append("        ans_str = ', '.join(ans_list)\n");
					sb.append(
							"        # برای سادگی فعلا تصحیح خودکار چندانتخابی را ایگنور میکنیم یا بر اساس DSL پیاده میکنیم\n");
					sb.append("        responses.append(UserResponse(question_name='").append(question.getName())
							.append("', answer=ans_str, correct=None, score_value=0))\n");
				} else if (question instanceof TrueFalseQuestion) {
					TrueFalseQuestion tf = (TrueFalseQuestion) question;
					String correctVal = tf.isIsTrue() ? "true" : "false";
					sb.append("        ans = request.form.get('").append(tf.getName()).append("')\n");
					sb.append("        is_correct = (ans == '").append(correctVal).append("')\n");
					sb.append("        q_score = ").append(tf.getScore() > 0 ? tf.getScore() : 1)
							.append(" if is_correct else 0\n");
					sb.append("        total_score += q_score\n");
					sb.append("        responses.append(UserResponse(question_name='").append(tf.getName())
							.append("', answer=ans, correct=is_correct, score_value=q_score))\n");
				} else if (question instanceof DescriptiveQuestion) {
					sb.append("        ans = request.form.get('").append(question.getName()).append("')\n");
					sb.append("        responses.append(UserResponse(question_name='").append(question.getName())
							.append("', answer=ans, correct=None, score_value=None))\n");
				}
			}

			sb.append("        res = QuizResult(name=f\"RES_{session.get('user_id')}_{int(now.timestamp())}\", \n");
			sb.append("                         user_id=session.get('user_id'), quiz_name='").append(q.getName())
					.append("', \n");
			sb.append("                         finalScore=total_score, responses=responses)\n");
			sb.append("        db.session.add(res)\n");
			sb.append("        db.session.commit()\n");
			sb.append("        # هدایت کاربر بر اساس وضعیت لاگین\n");
			sb.append("        if session.get('user_id'):\n");
			sb.append("            return redirect(url_for('my_results'))\n");
			sb.append("        else:\n");
			sb.append(
					"            return \"<script>alert('پاسخ شما با موفقیت ثبت شد. برای مشاهده سوابق باید عضو شوید.'); window.location='/';</script>\"\n\n");

			sb.append("    return render_template('quiz_").append(q.getName()).append(".html')\n\n");
		}

		// results
		sb.append("@app.route('/my-results')\n");
		sb.append("@login_required\n");
		sb.append("def my_results():\n");
		sb.append(
				"    db_results = QuizResult.query.filter_by(user_id=session.get('user_id')).order_by(QuizResult.id.desc()).all()\n");
		sb.append("    enhanced_results = []\n");

		// پیمایش روی تمام کوییزهای موجود در پلتفرم فعلی با استفاده از جاوا
		for (Quiz q : p.getQuizzes()) {
			sb.append("    # پردازش نتایج مربوط به آزمون: ").append(q.getName()).append("\n");
			sb.append("    for res in [r for r in db_results if r.quiz_name == '").append(q.getName()).append("']:\n");
			sb.append("        enhanced_results.append({\n");
			sb.append("            'id': res.id,\n");
			sb.append("            'quiz_id': res.name,\n");
			sb.append("            'quiz_name': '").append(q.getLabel()).append("',\n");
			sb.append("            'finalScore': res.finalScore,\n");
			sb.append("            'maxScore': ")
					.append(q.getConfig().getTotalScore() > 0 ? q.getConfig().getTotalScore() : 100).append(",\n");
			sb.append("            'show_result': ").append(q.getConfig().isShowResult() ? "True" : "False")
					.append("\n");
			sb.append("        })\n");
		}

		sb.append("    return render_template('my_results.html', results=enhanced_results)\n\n");
		sb.append("@app.route('/api/result/<int:res_id>')\n");
		sb.append("@login_required\n");
		sb.append("def get_result_details(res_id):\n");
		sb.append("    res = QuizResult.query.get_or_404(res_id)\n");
		sb.append("    is_admin = session.get('role') == 'admin'\n");
		sb.append("    if res.user_id != session.get('user_id') and not is_admin:\n");
		sb.append("        return jsonify({'error': 'Unauthorized'}), 403\n");
		sb.append("    \n");
		sb.append("    responses_list = []\n");

		for (Quiz q : p.getQuizzes()) {
			sb.append("    if res.quiz_name == '").append(q.getName()).append("':\n");

			if (!q.getConfig().isShowResult()) {
				sb.append("        if not is_admin:\n");
				sb.append("            return jsonify({'error': 'نتایج غیرفعال است'}), 403\n");
			}

			for (Question ques : q.getQuestions()) {
				sb.append("        user_resp = next((r for r in res.responses if r.question_name == '")
						.append(ques.getName()).append("'), None)\n");

				sb.append("        raw_ans = user_resp.answer if user_resp else None\n");
				sb.append("        display_ans = 'بدون پاسخ'\n");
				sb.append("        if raw_ans:\n");

				// --- منطق تبدیل شناسه به متن (Mapping) ---
				if (ques instanceof SingleChoiceQuestion) {
					sb.append("            mapping = {");
					for (Option opt : ((SingleChoiceQuestion) ques).getOptions()) {
						sb.append("'").append(opt.getName()).append("': '").append(opt.getText()).append("', ");
					}
					sb.append("}\n");
					sb.append("            display_ans = mapping.get(raw_ans, raw_ans)\n");

				} else if (ques instanceof MultipleChoiceQuestion) {
					sb.append("            mapping = {");
					for (Option opt : ((MultipleChoiceQuestion) ques).getOptions()) {
						sb.append("'").append(opt.getName()).append("': '").append(opt.getText()).append("', ");
					}
					sb.append("}\n");
					sb.append("            # جدا کردن شناسه‌ها، تبدیل به متن و چسباندن مجدد با ویرگول\n");
					sb.append("            ans_keys = [k.strip() for k in raw_ans.split(',')]\n");
					sb.append("            display_ans = ', '.join([mapping.get(k, k) for k in ans_keys])\n");

				} else if (ques instanceof TrueFalseQuestion) {
					sb.append("            display_ans = 'صحیح' if raw_ans.lower() == 'true' else 'غلط'\n");

				} else {
					// برای سوالات تشریحی، همان متن مستقیم استفاده شود
					sb.append("            display_ans = raw_ans\n");
				}

				sb.append("        responses_list.append({\n");
				sb.append("            'question_text': \"").append(ques.getText().replace("\"", "\\\""))
						.append("\",\n");
				sb.append("            'answer': display_ans,\n"); // استفاده از متن فارسی شده
				sb.append("            'correct': user_resp.correct if user_resp else None,\n");

				int qScore = 0;
				if (ques instanceof SingleChoiceQuestion)
					qScore = ((SingleChoiceQuestion) ques).getScore();
				else if (ques instanceof MultipleChoiceQuestion)
					qScore = ((MultipleChoiceQuestion) ques).getScore();
				else if (ques instanceof TrueFalseQuestion)
					qScore = ((TrueFalseQuestion) ques).getScore();
				else if (ques instanceof DescriptiveQuestion)
					qScore = ((DescriptiveQuestion) ques).getScore();

				sb.append("            'max_q_score': ").append(qScore).append(",\n");
				sb.append("            'earned_q_score': user_resp.score_value if user_resp else 0\n");
				sb.append("        })\n");
			}
		}
		sb.append("    return jsonify({'responses': responses_list})\n\n");
		// داشبورد ادمین
		sb.append("@app.route('/admin')\n@admin_required\ndef admin_dashboard():\n");
		sb.append("    quiz_labels = {\n");
		for (Quiz q : p.getQuizzes()) {
			sb.append("        '").append(q.getName()).append("': '").append(q.getLabel()).append("',\n");
		}
		sb.append("    }\n");
		sb.append("    # استخراج آمار از دیتابیس\n");
		sb.append("    total_users = User.query.count()\n");
		sb.append("    total_results = QuizResult.query.count()\n");
		sb.append("    admin_count = User.query.filter_by(role='admin').count()\n");
		sb.append("    \n");
		sb.append("    # محاسبه میانگین کل نمرات\n");
		sb.append("    avg_score = db.session.query(db.func.avg(QuizResult.finalScore)).scalar() or 0\n");
		sb.append("    \n");
		sb.append("    # ۵ نتیجه آخر برای نمایش در داشبورد\n");
		sb.append("    recent_results = QuizResult.query.order_by(QuizResult.id.desc()).limit(5).all()\n");
		sb.append("    \n");
		sb.append("    for res in recent_results:\n");
		sb.append("        res.display_name = quiz_labels.get(res.quiz_name)\n");
		sb.append("    stats = {\n");
		sb.append("        'users': total_users,\n");
		sb.append("        'results': total_results,\n");
		sb.append("        'admins': admin_count,\n");
		sb.append("        'avg': round(float(avg_score), 2)\n");
		sb.append("    }\n");
		sb.append("    return render_template('admin_dashboard.html', stats=stats, recent=recent_results)\n\n");
		// مسیر مشاهده لیست کاربران
		sb.append("@app.route('/admin/users')\n");
		sb.append("@admin_required\n");
		sb.append("def admin_users():\n");
		sb.append("    users = User.query.all()\n");
		sb.append("    return render_template('admin_users.html', users=users)\n\n");

		// مسیر افزودن کاربر جدید
		sb.append("@app.route('/admin/user/add', methods=['POST'])\n");
		sb.append("@admin_required\n");
		sb.append("def add_user():\n");
		sb.append("    u = User(\n");
		sb.append("        username=request.form['username'],\n");
		sb.append("        full_name=request.form['full_name'],\n");
		sb.append("        password=request.form['password'],\n");
		sb.append("        role=request.form['role']\n");
		sb.append("    )\n");
		sb.append("    db.session.add(u)\n");
		sb.append("    db.session.commit()\n");
		sb.append("    return redirect(url_for('admin_users'))\n\n");

		// مسیر ویرایش کاربر
		sb.append("@app.route('/admin/user/edit/<int:id>', methods=['POST'])\n");
		sb.append("@admin_required\n");
		sb.append("def edit_user(id):\n");
		sb.append("    u = User.query.get_or_404(id)\n");
		sb.append("    current_user_id = session.get('user_id')\n");

		sb.append("    if u.id == current_user_id and request.form['role'] != u.role:\n");
		sb.append("        return 'خطا: شما نمی‌توانید نقش خود را تغییر دهید', 400\n");
		sb.append(
				"    if u.role == 'admin' and User.query.filter_by(role='admin').count() <= 1 and request.form['role'] != u.role:\n");
		sb.append("        return 'خطا: آخرین مدیر را نمی‌توان تغییر نقش داد', 400\n");
		sb.append("    u.username = request.form['username']\n");
		sb.append("    u.full_name = request.form['full_name']\n");
		sb.append("    u.role = request.form['role']\n");
		sb.append("    if request.form['password']: u.password = request.form['password']\n");
		sb.append("    db.session.commit()\n");
		sb.append("    return redirect(url_for('admin_users'))\n\n");

		// مسیر حذف کاربر
		sb.append("@app.route('/admin/user/delete/<int:id>', methods=['POST'])\n");
		sb.append("@admin_required\n");
		sb.append("def delete_user(id):\n");
		sb.append("    u = User.query.get_or_404(id)\n");
		sb.append("    current_user_id = session.get('user_id')\n");
		sb.append("    if u.id == current_user_id:\n");
		sb.append("        return 'خطا: شما نمی‌توانید خود را حذف کنید', 400\n");
		sb.append("    if u.role == 'admin' and User.query.filter_by(role='admin').count() <= 1:\n");
		sb.append("        return 'خطا: آخرین مدیر را نمی‌توان حذف کرد', 400\n");
		sb.append("    db.session.delete(u)\n");
		sb.append("    db.session.commit()\n");
		sb.append("    return redirect(url_for('admin_users'))\n\n");

		sb.append("# --- روت مشاهده کل نتایج برای ادمین ---\n");
		sb.append("@app.route('/admin/results')\n");
		sb.append("@admin_required\n");
		sb.append("def admin_results():\n");
		sb.append("    # واکشی تمام نتایج به همراه اطلاعات یوزر مرتبط\n");
		sb.append("    db_results = QuizResult.query.order_by(QuizResult.id.desc()).all()\n");
		sb.append("    all_results_dto = []\n");
		sb.append("    \n");
		sb.append("    # ساخت یک دیکشنری برای دسترسی سریع به برچسب کوییزها\n");
		sb.append("    quiz_map = { ");
		for (Quiz q : p.getQuizzes()) {
			sb.append("'").append(q.getName()).append("': {'label': '").append(q.getLabel()).append("', 'max': ")
					.append(q.getConfig().getTotalScore() > 0 ? q.getConfig().getTotalScore() : 100).append("}, ");
		}
		sb.append("}\n\n");

		sb.append("    for res in db_results:\n");
		sb.append("        user = User.query.get(res.user_id)\n");
		sb.append("        q_info = quiz_map.get(res.quiz_name, {'label': res.quiz_name, 'max': 100})\n");
		sb.append("        all_results_dto.append({\n");
		sb.append("            'id': res.id,\n");
		sb.append("            'user_full_name': user.full_name if user else 'کاربر حذف شده',\n");
		sb.append("            'user_id': res.user_id,\n");
		sb.append("            'quiz_name': q_info['label'],\n");
		sb.append("            'quiz_id': res.name,\n");
		sb.append("            'finalScore': res.finalScore,\n");
		sb.append("            'maxScore': q_info['max']\n");
		sb.append("        })\n");
		sb.append("    return render_template('admin_results.html', all_results=all_results_dto)\n\n");

		// --- ایجاد یوزرهای دیفالت در Main ---
		sb.append("if __name__ == '__main__':\n");
		sb.append("    with app.app_context():\n");
		sb.append("        db.create_all()\n");
		for (User u : system.getUsers()) {
			sb.append("        if not User.query.filter_by(username='").append(u.getUsername()).append("').first():\n");
			sb.append("            db.session.add(User(username='").append(u.getUsername()).append("', password='")
					.append(u.getPassword()).append("', full_name='").append(u.getFullName()).append("', role='")
					.append(u.getRole().toString().toLowerCase()).append("'))\n");
		}
		// نتایج اولیه (Quiz Results)
		for (QuizResult res : system.getResults()) {
			sb.append("        # Initial result for ").append(res.getName()).append("\n");
			sb.append("        target_user = User.query.filter_by(username='").append(res.getUser().getUsername())
					.append("').first()\n");
			sb.append("        if target_user and not QuizResult.query.filter_by(user_id=target_user.id, quiz_name='")
					.append(res.getQuiz().getLabel()).append("').first():\n");
			sb.append("            db.session.add(QuizResult(user_id=target_user.id, quiz_name='")
					.append(res.getQuiz().getLabel()).append("', score=").append(res.getFinalScore()).append("))\n");
		}
		sb.append("        db.session.commit()\n");
		sb.append("    app.run(debug=True)");

		return sb.toString();
	}

	private String generateBaseHtml(QuizPlatform p) {
		return "<!DOCTYPE html>\n<html dir='rtl' lang='fa'>\n<head>\n"
				+ "<meta charset='UTF-8'>\n<meta name='viewport' content='width=device-width, initial-scale=1.0'>\n"
				+ "<script src='https://cdn.tailwindcss.com'></script>\n"
				+ "<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css'>\n"
				+ "<link rel='icon' href='/static/images/" + p.getLogo() + "' type='image/vnd.microsoft.icon'>\n"
				+ "<link rel='stylesheet' href='/static/css/style.css'>\n"
				+ "<link href='https://cdn.jsdelivr.net/gh/rastikerdar/vazirmatn@v33.003/Vazirmatn-font-face.css' rel='stylesheet' type='text/css' />\n"
				+ "<title>" + p.getTitle() + "</title>\n" + "</head>\n"
				+ "<body class='min-h-screen flex flex-col animate-fade-in'>\n" +

				"  <nav id='main-nav' class='sticky top-0 z-50 glass'>\n"
				+ "    <div class='container mx-auto px-6 py-3 flex justify-between items-center'>\n"
				+ "      <a href='/' class='flex items-center gap-3'>\n" + "        <img src='/static/images/"
				+ p.getLogo() + "' class='h-8 w-auto'>\n"
				+ "        <span class='text-lg font-black' style='color: var(--primary)'>" + p.getTitle() + "</span>\n"
				+ "      </a>\n" + "      <div class='flex items-center gap-6 text-sm'>\n"
				+ "        <a href='/' style='color: var(--text)' class='opacity-80 hover:opacity-100 transition'>صفحه اصلی</a>\n"
				+ "        \n"
				+ "        <a href='/admin' id='nav-admin-link' class='hidden font-bold transition-all px-3 py-2 rounded-xl' \n"
				+ "           style='background: color-mix(in srgb, var(--primary), transparent 90%); \n"
				+ "                  color: var(--primary); \n"
				+ "                  border: 1px solid color-mix(in srgb, var(--primary), transparent 80%);'>\n"
				+ "           <i class='fa-solid fa-shield-halved ml-1'></i> پنل مدیریت\n" + "        </a>\n"
				+ "        <div id='auth-guest' class='flex'>\n"
				+ "          <a href='/login' class='px-5 py-2 rounded-full border border-[var(--primary)] text-[var(--primary)] hover:bg-[var(--primary)] hover:text-[var(--bg)] transition-all'>ورود</a>\n"
				+ "        </div>\n" + "        <div id='auth-user' class='hidden relative'>\n"
				+ "          <button id='user-menu-btn' class='w-10 h-10 rounded-full flex items-center justify-center text-white shadow-lg' style='background: var(--primary)'>\n"
				+ "            <i class='fa-solid fa-user'></i>\n" + "          </button>\n" +

				"          <div id='user-dropdown' class='hidden absolute left-0 top-14 w-56 rounded-2xl shadow-2xl overflow-hidden' \n"
				+ "               style='background-color: var(--nav-bg); border: 1px solid var(--card-border); backdrop-filter: blur(20px);'>\n"
				+

				"             <div class='p-4 border-b' style='border-color: var(--card-border)'>\n"
				+ "               <p class='text-[10px] opacity-70 mb-1' style='color: var(--text)'>حساب کاربری</p>\n"
				+ "               <p id='user-name-display' class='font-bold text-sm truncate' style='color: var(--text)'></p>\n"
				+ "             </div>\n" +

				"             <a href='/my-results' \n"
				+ "                class='block w-full text-right px-4 py-3 text-sm transition-all duration-200 flex items-center gap-2 hover:bg-[var(--primary)] hover:text-[var(--bg)]' \n"
				+ "                style='color: var(--text)'>\n"
				+ "               <i class='fa-solid fa-square-poll-vertical'></i> کارنامه من\n" + "             </a>\n"
				+

				"             <a href='/logout' id='logout-btn' class='block w-full text-right px-4 py-3 text-sm text-red-500 hover:bg-red-500 hover:text-white transition-colors flex items-center gap-2'>\n"
				+ "               <i class='fa-solid fa-arrow-right-from-bracket'></i> خروج\n" + "             </a>\n"
				+ "          </div>\n" +

				"        </div>\n" + "      </div>\n" + "    </div>\n" + "  </nav>\n" +

				"  <main class='flex-grow container mx-auto py-8 px-4'>{% block content %}{% endblock %}</main>\n" +

				"  <footer class='py-8 border-t text-center' style='border-color: var(--card-border); color: var(--text); opacity: 0.5;'>\n"
				+ "    <p class='text-xs'>© ۲۰۲۶ - طراحی شده با سیستم هوشمند " + p.getTitle() + "</p>\n"
				+ "  </footer>\n" + "  {% block modals %}{% endblock %}\n"
				+ "  <script src='/static/js/auth.js'></script>\n" + "  <script>\n"
				+ "    window.onscroll = function() {\n" + "      const nav = document.getElementById('main-nav');\n"
				+ "      if (window.scrollY > 20) {\n" + "        nav.classList.add('nav-scrolled');\n"
				+ "      } else {\n" + "        nav.classList.remove('nav-scrolled');\n" + "      }\n" + "    };\n"
				+ "  </script>\n" +

				"  {% block scripts %}{% endblock %}\n" + "</body>\n</html>";
	}

	private String generateAdminBaseHtml() {
		return "{% extends 'base.html' %}\n{% block content %}\n"
				+ "<div class='flex flex-col lg:flex-row gap-8 animate-fade-in' dir='rtl'>\n" + "  \n"
				+ "  <aside class='w-full lg:w-72 flex-shrink-0'>\n"
				+ "    <div class='glass rounded-[2.5rem] p-4 sticky top-24 border border-[var(--card-border)]'>\n"
				+ "      <div class='p-4 mb-4 border-b border-[var(--card-border)] text-center'>\n"
				+ "        <div class='w-16 h-16 bg-[var(--primary)] rounded-2xl mx-auto mb-3 flex items-center justify-center text-white shadow-lg'>\n"
				+ "          <i class='fa-solid fa-user-shield text-2xl'></i>\n" + "        </div>\n"
				+ "        <h2 class='font-black text-lg'>پنل مدیریت</h2>\n"
				+ "        <p class='text-[10px] opacity-50 uppercase tracking-widest'>Administrator Area</p>\n"
				+ "      </div>\n" + "      <nav class='space-y-2'>\n"
				+ "        <a href='/admin' class='flex items-center gap-4 p-4 rounded-2xl transition-all duration-300 {% if request.path == \"/admin\" %} bg-[var(--primary)] text-white shadow-xl {% else %} hover:bg-[var(--card-bg)] opacity-70 hover:opacity-100 {% endif %}'>\n"
				+ "          <i class='fa-solid fa-chart-line'></i> <span class='font-bold text-sm'>داشبورد و آمار</span>\n"
				+ "        </a>\n"
				+ "        <a href='/admin/users' class='flex items-center gap-4 p-4 rounded-2xl transition-all duration-300 {% if \"/admin/users\" in request.path %} bg-[var(--primary)] text-white shadow-xl {% else %} hover:bg-[var(--card-bg)] opacity-70 hover:opacity-100 {% endif %}'>\n"
				+ "          <i class='fa-solid fa-users-gear'></i> <span class='font-bold text-sm'>مدیریت کاربران</span>\n"
				+ "        </a>\n"
				+ "        <a href='/admin/results' class='flex items-center gap-4 p-4 rounded-2xl transition-all duration-300 {% if \"/admin/results\" in request.path %} bg-[var(--primary)] text-white shadow-xl {% else %} hover:bg-[var(--card-bg)] opacity-70 hover:opacity-100 {% endif %}'>\n"
				+ "          <i class='fa-solid fa-file-invoice text-lg'></i> <span class='font-bold text-sm'>پاسخنامه‌های دریافتی</span>\n"
				+ "        </a>\n" + "      </nav>\n" + "    </div>\n" + "  </aside>\n" + "\n" + "  \n"
				+ "  <main class='flex-grow'>\n" + "    {% block admin_content %}{% endblock %}\n" + "  </main>\n"
				+ "</div>\n" + "{% endblock %}" + "{% block modals %}\n" + "  {% block admin_modals %}{% endblock %}\n"
				+ // یک زیر-بلاک برای ادمین
				"{% endblock %}" + "{% block scripts %}\n" + "  {% block admin_scripts %}{% endblock %}\n" + // یک
																												// زیر-بلاک
																												// برای
																												// ادمین
				"{% endblock %}";
	}

	private String generateAuthJs() {
		return "document.addEventListener('DOMContentLoaded', async () => {\n"
				+ "  // انتخاب المان‌ها با یک ساختار تمیز\n" + "  const ui = {\n"
				+ "    guest: document.getElementById('auth-guest'),\n"
				+ "    user: document.getElementById('auth-user'),\n"
				+ "    admin: document.getElementById('nav-admin-link'),\n"
				+ "    name: document.getElementById('user-name-display'),\n"
				+ "    userBtn: document.getElementById('user-menu-btn'),\n"
				+ "    dropdown: document.getElementById('user-dropdown'),\n"
				+ "    logoutBtn: document.getElementById('logout-btn')\n" + "  };\n" + "\n"
				+ "  // 1. استعلام وضعیت واقعی از سرور\n" + "  try {\n"
				+ "    const response = await fetch('/api/auth-status');\n"
				+ "    const status = await response.json();\n" + "\n" + "    if (status.logged_in) {\n"
				+ "      // کاربر لاگین است\n" + "      ui.guest?.classList.add('hidden');\n"
				+ "      ui.user?.classList.remove('hidden');\n"
				+ "      if (ui.name) ui.name.textContent = status.full_name || status.username;\n" + "      \n"
				+ "      // نمایش لینک ادمین فقط برای نقش ادمین\n" + "      if (status.role === 'admin') {\n"
				+ "        ui.admin?.classList.remove('hidden');\n" + "      }\n" + "    } else {\n"
				+ "      // کاربر مهمان است\n" + "      ui.guest?.classList.remove('hidden');\n"
				+ "      ui.user?.classList.add('hidden');\n" + "      ui.admin?.classList.add('hidden');\n" + "    }\n"
				+ "  } catch (err) {\n" + "    console.error('Auth Check Failed:', err);\n" + "  }\n" + "\n"
				+ "  // 2. منطق باز و بسته شدن دراپ‌دان پروفایل\n" + "  if (ui.userBtn && ui.dropdown) {\n"
				+ "    ui.userBtn.addEventListener('click', (e) => {\n" + "      e.stopPropagation();\n"
				+ "      ui.dropdown.classList.toggle('hidden');\n"
				+ "      ui.dropdown.classList.add('animate-fade-in');\n" + "    });\n" + "\n"
				+ "    // بستن دراپ‌دان با کلیک روی هر جای صفحه\n" + "    document.addEventListener('click', (e) => {\n"
				+ "      if (!ui.userBtn.contains(e.target) && !ui.dropdown.contains(e.target)) {\n"
				+ "        ui.dropdown.classList.add('hidden');\n" + "      }\n" + "    });\n" + "  }\n" + "\n"
				+ "  // 3. خروج از سیستم\n" + "  if (ui.logoutBtn) {\n"
				+ "    ui.logoutBtn.addEventListener('click', () => {\n"
				+ "      // هدایت به مسیر خروج فلاسک برای پاک کردن Session\n"
				+ "      window.location.href = '/logout';\n" + "    });\n" + "  }\n" + "});";
	}

	private String generateLoginHtml(QuizPlatform p) {
		return "{% extends 'base.html' %}\n{% block content %}\n"
				+ "<div class='min-h-[70vh] flex items-center justify-center animate-fade-in'>\n"
				+ "  <div class='w-full max-w-md'>\n"
				+ "    <div class='glass p-10 rounded-[2.5rem] shadow-2xl transition-all' style='background: var(--card-bg); border: 1px solid var(--card-border);'>\n"
				+ "      <div class='text-center mb-10'>\n" +
				// --- ---
				"        <div class='w-24 h-24 rounded-full flex items-center justify-center mx-auto mb-6 shadow-lg' style='background: var(--primary);'>\n"
				+ "           <i class='fa-solid fa-lock text-4xl text-white'></i>\n" + "        </div>\n" +
				// ------------------------------------------
				"        <h2 class='text-3xl font-black mb-2' style='color: var(--text)'>ورود به حساب</h2>\n"
				+ "        <p style='color: var(--text); opacity: 0.6;' class='text-sm'>برای دسترسی به آزمون‌ها وارد شوید</p>\n"
				+ "      </div>\n" + "      \n" + "      {% with messages = get_flashed_messages() %}\n"
				+ "        {% if messages %}\n" + "          {% for message in messages %}\n"
				+ "            <div class='bg-red-500/10 text-red-500 text-sm p-4 rounded-xl mb-6 border border-red-500/20 text-center font-bold'>{{ message }}</div>\n"
				+ "          {% endfor %}\n" + "        {% endif %}\n" + "      {% endwith %}\n" + "\n"
				+ "      <form action='/login' method='POST' class='space-y-5'>\n" + "        <div>\n"
				+ "          <label class='block text-xs font-bold mb-2 mr-1 opacity-70'>نام کاربری</label>\n"
				+ "          <input type='text' name='username' required dir='ltr' \n"
				+ "             class='w-full px-6 py-4 rounded-2xl border-none outline-none transition-all text-left' \n"
				+ "             style='background: var(--bg); color: var(--text); box-shadow: inset 0 2px 4px rgba(0,0,0,0.05);'>\n"
				+ "        </div>\n" + "        <div>\n"
				+ "          <label class='block text-xs font-bold mb-2 mr-1 opacity-70'>رمز عبور</label>\n"
				+ "          <input type='password' name='password' required dir='ltr' \n"
				+ "             class='w-full px-6 py-4 rounded-2xl border-none outline-none transition-all text-left' \n"
				+ "             style='background: var(--bg); color: var(--text); box-shadow: inset 0 2px 4px rgba(0,0,0,0.05);'>\n"
				+ "        </div>\n"
				+ "        <button type='submit' class='w-full btn-primary py-4 rounded-2xl font-bold text-lg mt-6 shadow-xl shadow-[var(--primary)]/20 hover:shadow-[var(--primary)]/40'>\n"
				+ "          ورود\n" + "        </button>\n" + "      </form>\n" + "    </div>\n" + "  </div>\n"
				+ "</div>\n" + "{% endblock %}";
	}

	private String generateQuizPage(Quiz q) {
		StringBuilder sb = new StringBuilder();
		sb.append("{% extends 'base.html' %}\n{% block content %}\n");

		sb.append("<div class='max-w-4xl mx-auto'>\n");

		// هدر و نوار پیشرفت (مشابه قبل)
		sb.append("  <div class='flex justify-between items-end mb-8'>\n");
		sb.append(
				"    <div><h1 class='text-4xl font-black mb-2' style='color: var(--text)'>" + q.getLabel() + "</h1>\n");
		sb.append("    <p class='opacity-60'>" + q.getDescription() + "</p></div>\n");
		if (q.getConfig().getDuration() > 0) {
			sb.append(
					"    <div id='timer-box' class='glass p-4 rounded-3xl border border-[var(--card-border)] text-center min-w-[120px]'>\n");
			sb.append("      <p id='timer' class='text-2xl font-mono font-bold text-[var(--primary)]'>"
					+ q.getConfig().getDuration() + ":00</p></div>\n");
		}
		sb.append("  </div>\n");
		sb.append("  <div class='w-full h-2 bg-[var(--card-bg)] rounded-full mb-12 overflow-hidden'>\n");
		sb.append(
				"    <div id='progress-bar' class='h-full bg-[var(--primary)] transition-all duration-500 shadow-[0_0_15px_var(--primary)]' style='width: 0%'></div>\n");
		sb.append("  </div>\n");

		// فرم و کانتینر سوالات
		sb.append("  <form id='quiz-form' method='POST'>\n");
		sb.append("    <div id='questions-container'>\n"); // کانتینر برای شافل کردن

		int totalQuestions = q.getQuestions().size();
		for (int i = 0; i < totalQuestions; i++) {
			Question question = q.getQuestions().get(i);
			// نکته: همه سوالات ابتدا hidden هستند تا JS اول شافل کند و بعد اولین را نشان
			// دهد
			sb.append("      <div class='question-step hidden' data-logic-index='" + i + "'>\n");
			sb.append("        <div class='glass p-10 rounded-[3rem] border border-[var(--card-border)] mb-8'>\n");
			sb.append(
					"          <span class='text-[var(--primary)] font-bold mb-4 block step-counter'>سوال شماره ...</span>\n");
			sb.append("          <h2 class='text-2xl font-bold mb-8' style='color: var(--text)'>" + question.getText()
					+ "</h2>\n");

			// --- نمایش گزینه‌ها بر اساس نوع سوال ---
			if (question instanceof SingleChoiceQuestion) {
				for (Option opt : ((SingleChoiceQuestion) question).getOptions()) {
					sb.append(
							"          <label class='flex items-center gap-4 p-5 rounded-2xl border border-[var(--card-border)] mb-3 cursor-pointer hover:bg-[var(--primary)]/10 transition-all'>\n");
					sb.append("            <input type='radio' name='" + question.getName() + "' value='"
							+ opt.getName() + "' class='w-5 h-5 accent-[var(--primary)]'>\n");
					sb.append("            <span>" + opt.getText() + "</span></label>\n");
				}
			} else if (question instanceof MultipleChoiceQuestion) {
				for (Option opt : ((MultipleChoiceQuestion) question).getOptions()) {
					sb.append(
							"          <label class='flex items-center gap-4 p-5 rounded-2xl border border-[var(--card-border)] mb-3 cursor-pointer hover:bg-[var(--primary)]/10 transition-all'>\n");
					sb.append("            <input type='checkbox' name='" + question.getName() + "[]' value='"
							+ opt.getName() + "' class='w-5 h-5 rounded-md accent-[var(--primary)]'>\n");
					sb.append("            <span>" + opt.getText() + "</span></label>\n");
				}
			} else if (question instanceof TrueFalseQuestion) {
				sb.append(
						"          <div class='flex gap-4'><label class='flex-1 flex items-center justify-center gap-3 p-8 rounded-2xl border border-[var(--card-border)] cursor-pointer hover:bg-green-500/10 transition-all'>");
				sb.append("<input type='radio' name='" + question.getName() + "' value='true'> صحیح</label>");
				sb.append(
						"<label class='flex-1 flex items-center justify-center gap-3 p-8 rounded-2xl border border-[var(--card-border)] cursor-pointer hover:bg-red-500/10 transition-all'>");
				sb.append("<input type='radio' name='" + question.getName() + "' value='false'> غلط</label></div>\n");
			} else if (question instanceof DescriptiveQuestion) {
				sb.append("          <textarea name='" + question.getName()
						+ "' rows='5' class='w-full p-6 rounded-3xl border border-[var(--card-border)] bg-[var(--card-bg)] text-white outline-none focus:border-[var(--primary)]'></textarea>\n");
			}
			// ----------------------------------------

			sb.append("        </div>\n");

			// دکمه‌های ناوبری (کلاس‌های کنترلی اضافه شد)
			sb.append("        <div class='flex justify-between items-center px-4'>\n");
			sb.append(
					"          <button type='button' class='prev-btn px-8 py-3 rounded-xl glass border border-[var(--card-border)] opacity-0 pointer-events-none'>قبلی</button>\n");
			sb.append(
					"          <button type='button' class='next-btn px-10 py-4 rounded-2xl btn-primary'>بعدی</button>\n");
			sb.append(
					"          <button type='submit' class='submit-btn hidden px-10 py-4 rounded-2xl bg-green-500 text-white font-black'>ثبت نهایی</button>\n");
			sb.append("        </div>\n");
			sb.append("      </div>\n");
		}

		sb.append("    </div>\n");
		sb.append("  </form>\n");
		sb.append("</div>\n");

		// اسکریپت شافل و مدیریت آزمون
		sb.append("<script>\n");
		sb.append("  const container = document.getElementById('questions-container');\n");
		sb.append("  const steps = Array.from(container.getElementsByClassName('question-step'));\n");
		sb.append("  let currentStep = 0;\n");
		sb.append("  const totalSteps = steps.length;\n");

		// ۱. الگوریتم شافل Fisher-Yates (اگر در تنظیمات آزمون شافل فعال بود)
		if (q.getConfig().isShuffleQuestions()) {
			sb.append("  for (let i = totalSteps - 1; i > 0; i--) {\n");
			sb.append("    const j = Math.floor(Math.random() * (i + 1));\n");
			sb.append("    container.appendChild(steps[j]);\n"); // جابجایی در DOM
			sb.append("    steps.push(steps.splice(j, 1)[0]);\n");
			sb.append("  }\n");
		}

		// ۲. مدیریت نمایش و نویگیشن بعد از جابجایی
		sb.append("  function renderStep() {\n");
		sb.append("    steps.forEach((s, i) => {\n");
		sb.append("      s.classList.add('hidden');\n");
		sb.append("      if(i === currentStep) {\n");
		sb.append("        s.classList.remove('hidden');\n");
		sb.append("        s.querySelector('.step-counter').innerText = `سوال شماره ${i+1} از ${totalSteps}`;\n");
		sb.append("        const pBtn = s.querySelector('.prev-btn');\n");
		sb.append("        const nBtn = s.querySelector('.next-btn');\n");
		sb.append("        const sBtn = s.querySelector('.submit-btn');\n");
		// دکمه قبلی
		sb.append(
				"        if(i > 0) { pBtn.classList.replace('opacity-0', 'opacity-100'); pBtn.classList.remove('pointer-events-none'); pBtn.onclick = () => { currentStep--; renderStep(); }; }\n");
		// دکمه بعدی یا ثبت
		sb.append(
				"        if(i === totalSteps - 1) { nBtn.classList.add('hidden'); sBtn.classList.remove('hidden'); }\n");
		sb.append(
				"        else { nBtn.classList.remove('hidden'); sBtn.classList.add('hidden'); nBtn.onclick = () => { currentStep++; renderStep(); }; }\n");
		sb.append("      }\n");
		sb.append("    });\n");
		sb.append(
				"    document.getElementById('progress-bar').style.width = (currentStep / totalSteps * 100) + '%';\n");
		sb.append("  }\n");

		// اجرای اولیه
		sb.append("  renderStep();\n");

		// ۳. تایمر (مشابه قبل)
		if (q.getConfig().getDuration() > 0) {
			sb.append("  let timeLeft = " + (q.getConfig().getDuration() * 60) + ";\n");
			sb.append("  const timerInterval = setInterval(() => {\n");
			sb.append("    timeLeft--;\n");
			sb.append("    const mins = Math.floor(timeLeft / 60); const secs = timeLeft % 60;\n");
			sb.append("    document.getElementById('timer').innerText = `${mins}:${secs < 10 ? '0' : ''}${secs}`;\n");
			sb.append(
					"    if (timeLeft <= 10) { document.getElementById('timer-box').classList.add('animate-pulse', 'border-red-500'); }\n");
			sb.append(
					"    if (timeLeft <= 0) { clearInterval(timerInterval); document.getElementById('quiz-form').submit(); }\n");
			sb.append("  }, 1000);\n");
		}
		sb.append("</script>\n");

		sb.append("{% endblock %}");
		return sb.toString();
	}

	private String generateIndexHtml(QuizPlatform p) {
		StringBuilder sb = new StringBuilder();
		sb.append("{% extends 'base.html' %}\n{% block content %}\n");

		// Hero Section
		sb.append(
				"<section class='relative py-24 px-8 rounded-[3rem] mb-16 overflow-hidden shadow-2xl text-center'>\n");
		sb.append(
				"  <div class='absolute inset-0 z-0' style='background: linear-gradient(135deg, var(--primary) 0%, var(--secondary) 100%);'></div>\n");
		sb.append(
				"  <div class='absolute inset-0 opacity-10' style='background-image: url(\"https://www.transparenttextures.com/patterns/cubes.png\");'></div>\n");
		sb.append("  <div class='relative z-10 max-w-4xl mx-auto text-white'>\n");
		if (p.getLogo() != null) {
			sb.append("    <img src='/static/images/").append(p.getLogo())
					.append("' class='h-28 mx-auto mb-8 drop-shadow-2xl animate-fade-in'>\n");
		}
		sb.append("    <h1 class='text-5xl md:text-6xl font-black mb-6 tracking-tight'>" + p.getTitle() + "</h1>\n");
		sb.append("    <p class='text-xl md:text-2xl opacity-90 font-light leading-relaxed'>" + p.getSubtitle()
				+ "</p>\n");
		sb.append("  </div>\n");
		sb.append("</section>\n");

		// Grid System
		sb.append("<div class='grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8'>\n");

		for (Quiz q : p.getQuizzes()) {
			sb.append(
					"  <div class='group glass rounded-[2.5rem] p-8 transition-all duration-500 hover:-translate-y-2 flex flex-col h-full' style='background: var(--card-bg); border: 1px solid var(--card-border);'>\n");

			// Header: Icon + Badge
			sb.append("    <div class='flex justify-between items-start mb-6'>\n");
			if (q.getIcon() != null) {
				sb.append(
						"      <div class='w-16 h-16 rounded-2xl p-3 flex items-center justify-center shadow-sm' style='background: var(--bg)'>\n");
				sb.append("        <img src='/static/images/").append(q.getIcon()).append(
						"' class='w-full h-full object-contain group-hover:scale-110 transition-transform duration-300'>\n");
				sb.append("      </div>\n");
			}

			if (q.getConfig().getAccess() == AccessType.PUBLIC) {
				sb.append(
						"      <span class='text-[10px] font-bold px-3 py-1 rounded-full border' style='background: rgba(34, 197, 94, 0.1); color: #22c55e; border-color: rgba(34, 197, 94, 0.2);'><i class='fa-solid fa-earth-americas ml-1'></i> عمومی </span>\n");
			} else {
				sb.append(
						"      <span class='text-[10px] font-bold px-3 py-1 rounded-full border' style='background: rgba(245, 158, 11, 0.1); color: #f59e0b; border-color: rgba(245, 158, 11, 0.2);'><i class='fa-solid fa-lock ml-1'></i> نیازمند ورود </span>\n");
			}
			sb.append("    </div>\n");

			// Body
			sb.append("    <h2 class='text-2xl font-bold mb-3' style='color: var(--text)'>" + q.getLabel() + "</h2>\n");
			sb.append(
					"    <p class='text-sm mb-6 flex-grow leading-relaxed line-clamp-3' style='color: var(--text-muted)'>"
							+ (q.getDescription() != null ? q.getDescription()
									: "برای ارزیابی مهارت‌های خود در این چالش شرکت کنید.")
							+ "</p>\n");

			// Meta Info
			sb.append(
					"    <div class='flex flex-wrap gap-4 mb-8 pt-4 border-t' style='border-color: var(--card-border)'>\n");
			sb.append(
					"      <div class='flex items-center gap-2 text-xs font-medium' style='color: var(--text-muted)'>\n");
			sb.append("        <i class='fa-solid fa-layer-group' style='color: var(--primary)'></i>\n");
			sb.append("        <span>" + q.getQuestions().size() + " سوال</span>\n");
			sb.append("      </div>\n");

			String durationText;
			try {
				int duration = q.getConfig().getDuration();
				durationText = (duration > 0) ? duration + " دقیقه" : "زمان آزاد";
			} catch (Exception e) {
				durationText = "زمان آزاد";
			}

			sb.append(
					"      <div class='flex items-center gap-2 text-xs font-medium' style='color: var(--text-muted)'>\n");
			sb.append("        <i class='fa-solid fa-clock' style='color: var(--primary)'></i>\n");
			sb.append("        <span>").append(durationText).append("</span>\n");
			sb.append("      </div>\n");
			sb.append("    </div>\n");

			// Footer Button
			sb.append("    <a href='/quiz/" + q.getName()
					+ "' class='mt-auto w-full btn-primary px-6 py-4 rounded-xl text-center font-bold shadow-lg hover:shadow-[var(--primary)]/30 transition-all flex justify-between items-center group-hover:px-8'>\n");
			sb.append("      <span>شروع آزمون</span>\n");
			sb.append("      <i class='fa-solid fa-arrow-left transition-transform group-hover:-translate-x-1'></i>\n");
			sb.append("    </a>\n");

			sb.append("  </div>\n");
		}
		sb.append("</div>\n");

		sb.append("{% endblock %}");
		return sb.toString();
	}

	private String generateMyResultsHtml() {
		StringBuilder sb = new StringBuilder();
		sb.append("{% extends 'base.html' %}\n{% block content %}\n");

		sb.append("<div class='max-w-5xl mx-auto animate-fade-in'>\n");

		// هدر صفحه - استفاده از متغیر --text-muted و --text
		sb.append("    <div class='flex justify-between items-center mb-12'>\n");
		sb.append(
				"        <a href='/' class='text-sm opacity-60 hover:opacity-100 transition-all text-[var(--text)] hover:text-[var(--primary)]'><i class='fa-solid fa-arrow-right ml-2'></i> بازگشت به خانه</a>\n");
		sb.append("        <div class='text-right'>\n");
		sb.append("            <h1 class='text-4xl font-black mb-2 text-[var(--text)]'>کارنامه‌های من</h1>\n");
		sb.append("            <p class='text-[var(--text-muted)] text-sm'>تاریخچه و جزئیات عملکرد شما</p>\n");
		sb.append("        </div>\n");
		sb.append("    </div>\n");

		sb.append("    <div class='grid grid-cols-1 md:grid-cols-2 gap-6'>\n");
		sb.append("        {% for res in results %}\n");

		// کارت با استفاده از استایل glass و متغیرهای لایه مرزی تم
		sb.append(
				"        <div class='glass p-8 rounded-[2.5rem] border border-[var(--card-border)] bg-[var(--card-bg)] backdrop-blur-md transition-all duration-300 {% if res.show_result %} cursor-pointer hover:border-[var(--primary)] hover:translate-y-[-5px] group {% endif %}' ");
		sb.append("             {% if res.show_result %} onclick='openResultModal({{ res.id }})' {% endif %}>\n");

		sb.append("            <div class='flex justify-between items-start mb-6'>\n");
		sb.append(
				"                <div class='w-12 h-12 rounded-2xl bg-[var(--primary)]/10 flex items-center justify-center text-[var(--primary)] group-hover:scale-110 transition-transform'>\n");
		sb.append("                    <i class='fa-solid fa-award text-2xl'></i>\n");
		sb.append("                </div>\n");
		sb.append("                <div class='text-left'>\n");
		sb.append(
				"                    <span class='text-[10px] text-[var(--text-muted)] block uppercase tracking-tighter'>Ref ID</span>\n");
		sb.append(
				"                    <span class='font-mono text-xs text-[var(--text)] opacity-60'>{{ res.quiz_id }}</span>\n");
		sb.append("                </div>\n");
		sb.append("            </div>\n");

		sb.append(
				"            <h3 class='font-bold text-xl mb-6 text-[var(--text)] group-hover:text-[var(--primary)] transition-colors'>{{ res.quiz_name }}</h3>\n");

		// بخش نمره - استفاده از ترکیب رنگ متن و پس‌زمینه برای ایجاد کنتراست منطبق بر تم
		sb.append(
				"            <div class='flex items-center justify-between p-5 bg-[var(--bg)]/50 rounded-3xl border border-[var(--card-border)]'>\n");
		sb.append("                <span class='text-sm text-[var(--text-muted)]'>امتیاز کسب شده</span>\n");
		sb.append("                <div class='text-2xl font-black text-[var(--primary)]'>\n");
		sb.append(
				"                    {{ res.finalScore }} <span class='text-xs text-[var(--text-muted)] mx-1 font-normal'>از</span> {{ res.maxScore }}\n");
		sb.append("                </div>\n");
		sb.append("            </div>\n");

		sb.append("            {% if res.show_result %}\n");
		sb.append(
				"                <div class='mt-6 text-center text-[10px] uppercase tracking-widest text-[var(--primary)] opacity-60 group-hover:opacity-100 transition-all'>\n");
		sb.append("                    مشاهده جزئیات <i class='fa-solid fa-chevron-left mr-1'></i>\n");
		sb.append("                </div>\n");
		sb.append("            {% endif %}\n");

		sb.append("        </div>\n");
		sb.append("        {% endfor %}\n");
		sb.append("    </div>\n");
		sb.append("</div>\n");

		// --- مودال کاملاً هوشمند بر اساس رنگ پس‌زمینه و متن تم ---
		sb.append(
				"<div id='resultModal' class='fixed inset-0 z-50 hidden flex items-center justify-center p-4 bg-[var(--bg)]/95 backdrop-blur-md transition-opacity duration-300'>\n");

		// استفاده از --nav-bg برای پس‌زمینه مودال جهت هماهنگی با نوار ابزار اسکرول شده
		sb.append(
				"    <div class='bg-[var(--nav-bg)] w-full max-w-2xl max-h-[90vh] overflow-hidden rounded-[3rem] border border-[var(--card-border)] flex flex-col shadow-2xl'>\n");

		// هدر مودال
		sb.append(
				"        <div class='p-6 border-b border-[var(--card-border)] flex justify-between items-center bg-[var(--text)]/5'>\n");
		sb.append(
				"            <button onclick='closeModal()' class='w-10 h-10 rounded-xl hover:bg-red-500/20 hover:text-red-500 transition-all text-[var(--text-muted)] text-2xl'>&times;</button>\n");
		sb.append("            <h2 class='text-lg font-bold text-[var(--text)] tracking-tight'>جزئیات پاسخنامه</h2>\n");
		sb.append("        </div>\n");

		// محتوای مودال
		sb.append(
				"        <div id='modalContent' class='p-8 overflow-y-auto flex-1 text-right scrollbar-hide text-[var(--text)]'>\n");
		sb.append("            \n");
		sb.append("        </div>\n");

		// فوتر مودال
		sb.append(
				"        <div class='p-6 border-t border-[var(--card-border)] flex justify-between items-center bg-[var(--text)]/5'>\n");
		sb.append(
				"            <button id='nextRes' class='px-8 py-3 rounded-2xl btn-primary text-sm font-bold active:scale-95 transition-transform'>سوال بعدی</button>\n");
		sb.append(
				"            <div id='modalStepInfo' class='text-xs font-mono text-[var(--text-muted)] bg-[var(--bg)] px-4 py-2 rounded-full border border-[var(--card-border)]'></div>\n");
		sb.append(
				"            <button id='prevRes' class='px-8 py-3 rounded-2xl bg-[var(--card-bg)] border border-[var(--card-border)] text-[var(--text)] hover:bg-[var(--primary)]/10 text-sm font-bold transition-all'>قبلی</button>\n");
		sb.append("        </div>\n");
		sb.append("    </div>\n");
		sb.append("</div>\n");

		// --- اسکریپت‌ها با رنگ‌های داینامیک ---
		sb.append("<script>\n");
		sb.append("let currentResponses = []; let currentIndex = 0;\n");
		sb.append("const container = document.getElementById('modalContent');\n");

		sb.append("function openResultModal(resultId) {\n");
		sb.append("    fetch(`/api/result/${resultId}`).then(r => r.json()).then(data => {\n");
		sb.append("        currentResponses = data.responses;\n");
		sb.append("        currentIndex = 0;\n");
		sb.append("        document.getElementById('resultModal').classList.remove('hidden');\n");
		sb.append("        document.body.style.overflow = 'hidden';\n");
		sb.append("        renderResponse();\n");
		sb.append("    });\n");
		sb.append("}\n");

		sb.append("function renderResponse() {\n");
		sb.append("    const resp = currentResponses[currentIndex];\n");
		sb.append("    let scoreStatus = '';\n");
		// استفاده از رنگ‌های تایید شده در تم
		sb.append("    let indicatorClass = 'border-[var(--card-border)] bg-[var(--bg)]/50';\n");
		sb.append("    let icon = '<i class=\"fa-solid fa-circle-info opacity-50\"></i>';\n");

		sb.append("    if (resp.max_q_score > 0) {\n");
		sb.append("        if (resp.correct === true) {\n");
		sb.append("            scoreStatus = `پاسخ صحیح | نمره: ${resp.earned_q_score} از ${resp.max_q_score}`;\n");
		sb.append("            indicatorClass = 'border-green-500/40 bg-green-500/10 text-green-500';\n");
		sb.append("            icon = '<i class=\"fa-solid fa-circle-check\"></i>';\n");
		sb.append("        } else if (resp.correct === false) {\n");
		sb.append("            scoreStatus = `پاسخ غلط | نمره: 0 از ${resp.max_q_score}`;\n");
		sb.append("            indicatorClass = 'border-red-500/40 bg-red-500/10 text-red-500';\n");
		sb.append("            icon = '<i class=\"fa-solid fa-circle-xmark\"></i>';\n");
		sb.append("        } else {\n");
		sb.append("            scoreStatus = `در انتظار تصحیح | نمره: ؟ از ${resp.max_q_score}`;\n");
		sb.append("            indicatorClass = 'border-yellow-500/40 bg-yellow-500/10 text-yellow-500';\n");
		sb.append("            icon = '<i class=\"fa-solid fa-circle-question\"></i>';\n");
		sb.append("        }\n");
		sb.append("    } else {\n");
		sb.append(
				"        scoreStatus = resp.correct === true ? 'تایید شده' : (resp.correct === false ? 'رد شده' : 'ثبت شده');\n");
		sb.append("    }\n");

		sb.append("    container.innerHTML = `\n");
		sb.append("        <div class='animate-fade-in'>\n");
		sb.append("            <div class='mb-8'>\n");
		sb.append(
				"                <span class='text-[var(--primary)] text-[10px] font-black uppercase tracking-[0.2em] block mb-3 opacity-80'>Question ${currentIndex + 1}</span>\n");
		sb.append(
				"                <h3 class='text-xl font-bold leading-relaxed text-[var(--text)]'>${resp.question_text}</h3>\n");
		sb.append("            </div>\n");
		sb.append(
				"            <div class='p-6 rounded-[2rem] bg-[var(--bg)] border border-[var(--card-border)] mb-6'>\n");
		sb.append(
				"                <div class='text-[10px] text-[var(--text-muted)] mb-3 uppercase tracking-widest'>Your Answer</div>\n");
		sb.append(
				"                <div class='text-lg font-medium text-[var(--text)] opacity-90'>${resp.answer || '<span class=\"opacity-30 italic font-light\">پاسخی ثبت نشده است</span>'}</div>\n");
		sb.append("            </div>\n");
		sb.append(
				"            <div class='flex items-center gap-4 p-5 rounded-2xl border ${indicatorClass} font-bold text-sm transition-all'>\n");
		sb.append("                <span class='text-xl'>${icon}</span>\n");
		sb.append("                <span>${scoreStatus}</span>\n");
		sb.append("            </div>\n");
		sb.append("        </div>\n");
		sb.append("    `;\n");

		sb.append(
				"    document.getElementById('modalStepInfo').innerText = `${currentIndex + 1} / ${currentResponses.length}`;\n");
		sb.append("    document.getElementById('prevRes').classList.toggle('opacity-30', currentIndex === 0);\n");
		sb.append("    document.getElementById('prevRes').disabled = currentIndex === 0;\n");
		sb.append(
				"    document.getElementById('nextRes').innerText = currentIndex === currentResponses.length - 1 ? 'بستن مرور' : 'سوال بعدی';\n");

		sb.append(
				"    document.getElementById('prevRes').onclick = () => { if(currentIndex > 0) { currentIndex--; renderResponse(); } };\n");
		sb.append("    document.getElementById('nextRes').onclick = () => {\n");
		sb.append("        if(currentIndex < currentResponses.length - 1) { currentIndex++; renderResponse(); }\n");
		sb.append("        else { closeModal(); }\n");
		sb.append("    };\n");
		sb.append("}\n");

		sb.append("function closeModal() {\n");
		sb.append("    document.getElementById('resultModal').classList.add('hidden');\n");
		sb.append("    document.body.style.overflow = 'auto';\n");
		sb.append("}\n");
		sb.append("</script>\n");

		sb.append("{% endblock %}");
		return sb.toString();
	}

	private String generateAdminDashboardHtml() {
		return "{% extends 'admin_base.html' %}\n{% block admin_content %}\n" + "<div class='space-y-8'>\n"
				+ "  <header>\n"
				+ "    <h1 class='text-3xl font-black' style='color: var(--text)'>خلاصه وضعیت سامانه</h1>\n"
				+ "    <p class='opacity-50 text-sm mt-1'>گزارش عملکرد کلی پلتفرم آزمون</p>\n" + "  </header>\n" + "\n"
				+ "  \n" + "  <div class='grid grid-cols-1 md:grid-cols-2 xl:grid-cols-4 gap-6'>\n"
				+ "    <div class='glass p-6 rounded-[2rem] border-r-4 border-[var(--primary)]'>\n"
				+ "      <p class='text-xs opacity-50 mb-1'>کل کاربران</p>\n"
				+ "      <div class='flex items-end justify-between'>\n"
				+ "        <span class='text-3xl font-black'>{{ stats.users }}</span>\n"
				+ "        <i class='fa-solid fa-users text-2xl opacity-20'></i>\n" + "      </div>\n" + "    </div>\n"
				+ "    <div class='glass p-6 rounded-[2rem] border-r-4 border-blue-500'>\n"
				+ "      <p class='text-xs opacity-50 mb-1'>آزمون‌های ثبت شده</p>\n"
				+ "      <div class='flex items-end justify-between'>\n"
				+ "        <span class='text-3xl font-black'>{{ stats.results }}</span>\n"
				+ "        <i class='fa-solid fa-graduation-cap text-2xl opacity-20'></i>\n" + "      </div>\n"
				+ "    </div>\n" + "    <div class='glass p-6 rounded-[2rem] border-r-4 border-green-500'>\n"
				+ "      <p class='text-xs opacity-50 mb-1'>میانگین نمرات</p>\n"
				+ "      <div class='flex items-end justify-between'>\n"
				+ "        <span class='text-3xl font-black'>{{ stats.avg }}</span>\n"
				+ "        <i class='fa-solid fa-star text-2xl opacity-20'></i>\n" + "      </div>\n" + "    </div>\n"
				+ "    <div class='glass p-6 rounded-[2rem] border-r-4 border-purple-500'>\n"
				+ "      <p class='text-xs opacity-50 mb-1'>تعداد مدیران</p>\n"
				+ "      <div class='flex items-end justify-between'>\n"
				+ "        <span class='text-3xl font-black'>{{ stats.admins }}</span>\n"
				+ "        <i class='fa-solid fa-user-tie text-2xl opacity-20'></i>\n" + "      </div>\n"
				+ "    </div>\n" + "  </div>\n" + "\n" + "  \n"
				+ "  <div class='glass rounded-[2.5rem] overflow-hidden'>\n"
				+ "    <div class='p-6 border-b border-[var(--card-border)] bg-[var(--card-bg)]/30 flex justify-between items-center'>\n"
				+ "      <h3 class='font-bold'>آخرین پاسخنامه‌های دریافتی</h3>\n"
				+ "      <a href='/admin/results' class='text-xs text-[var(--primary)] hover:underline'>مشاهده همه</a>\n"
				+ "    </div>\n" + "    <div class='overflow-x-auto'>\n" + "      <table class='w-full text-right'>\n"
				+ "        <thead>\n" + "          <tr class='text-xs opacity-40'>\n"
				+ "            <th class='p-5 font-medium'>کاربر</th>\n"
				+ "            <th class='p-5 font-medium'>آزمون</th>\n"
				+ "            <th class='p-5 font-medium'>نمره</th>\n"
				+ "            <th class='p-5 font-medium'>وضعیت</th>\n" + "          </tr>\n" + "        </thead>\n"
				+ "        <tbody class='text-sm'>\n" + "          {% for r in recent %}\n"
				+ "          <tr class='border-t border-[var(--card-border)] hover:bg-[var(--card-bg)]/20 transition'>\n"
				+ "            <td class='p-5 font-bold'>{{ r.user.full_name if r.user else 'مهمان' }}</td>\n"
				+ "            <td class='p-5 opacity-70'>{{ r.display_name }}</td>\n"
				+ "            <td class='p-5 font-mono'>{{ r.finalScore }}</td>\n" + "            <td class='p-5'>\n"
				+ "               <span class='w-2 h-2 rounded-full bg-green-500 inline-block ml-2'></span>\n"
				+ "               <span class='text-[10px] opacity-50'>ثبت شده</span>\n" + "            </td>\n"
				+ "          </tr>\n" + "          {% endfor %}\n" + "        </tbody>\n" + "      </table>\n"
				+ "    </div>\n" + "  </div>\n" + "</div>\n" + "{% endblock %}";
	}

	private String generateAdminUsersHtml() {
		return "{% extends 'admin_base.html' %}\n" + "{% block admin_content %}\n" + "<div class='space-y-6'>\n"
				+ "  <div class='flex justify-between items-center'>\n"
				+ "    <h2 class='text-2xl font-black' style='color: var(--text)'>مدیریت کاربران</h2>\n"
				+ "    <button onclick='openUserModal()' class='btn-primary px-6 py-3 rounded-2xl flex items-center gap-2'>\n"
				+ "      <i class='fa-solid fa-user-plus'></i> افزودن کاربر جدید\n" + "    </button>\n" + "  </div>\n\n"
				+

				"  \n" + "  <div class='glass rounded-[2.5rem] overflow-hidden border border-[var(--card-border)]'>\n"
				+ "    <table class='w-full text-right'>\n"
				+ "      <thead style='background: var(--card-bg)' class='text-xs opacity-50 uppercase'>\n"
				+ "        <tr><th class='p-6'>نام کامل</th><th class='p-6'>نام کاربری</th><th class='p-6'>نقش</th><th class='p-6 text-center'>عملیات</th></tr>\n"
				+ "      </thead>\n"
				+ "      <tbody class='divide-y divide-[var(--card-border)]' style='color: var(--text)'>\n"
				+ "        {% for u in users %}\n" + "        <tr class='hover:bg-[var(--card-bg)] transition'>\n"
				+ "          <td class='p-6 font-bold'>{{ u.full_name }}</td>\n"
				+ "          <td class='p-6 font-mono text-sm opacity-60'>{{ u.username }}</td>\n"
				+ "          <td class='p-6'>\n" + "            {% if u.role == 'admin' %}\n"
				+ "              <span class='px-4 py-1.5 rounded-full text-[10px] font-bold bg-purple-500/20 text-purple-400 border border-purple-500/30'>مدیر سیستم</span>\n"
				+ "            {% else %}\n"
				+ "              <span class='px-4 py-1.5 rounded-full text-[10px] font-bold bg-blue-500/20 text-blue-400 border border-blue-500/30'>دانشجو</span>\n"
				+ "            {% endif %}\n" + "          </td>\n" + "          <td class='p-6'>\n"
				+ "            <div class='flex justify-center gap-2'>\n"
				+ "              <button onclick='openUserModal({{ u.to_dict()|tojson|forceescape }})' \n"
				+ "                      class='w-10 h-10 rounded-xl glass hover:bg-[var(--primary)] hover:text-white transition-all duration-300 flex items-center justify-center border border-[var(--card-border)]'>\n"
				+ "                <i class='fa-solid fa-pen-to-square'></i>\n" + "              </button>\n"
				+ "              <button onclick='openDeleteModal({{ u.id }}, \"{{ u.full_name }}\")' \n"
				+ "                      class='w-10 h-10 rounded-xl glass border border-[var(--card-border)] text-red-400 hover:bg-red-500 hover:text-white hover:shadow-[0_0_15px_rgba(239,68,68,0.4)] transition-all duration-300 flex items-center justify-center'>\n"
				+ "                <i class='fa-solid fa-trash-can text-xs'></i>\n" + "              </button>\n"
				+ "            </div>\n" + "          </td>\n" + "        </tr>\n" + "        {% endfor %}\n"
				+ "      </tbody>\n" + "    </table>\n" + "  </div>\n" + "</div>\n\n" + "{% endblock %}" + "\n"
				+ "{% block admin_modals %}\n"
				+ "<div id='modalLayer' class='fixed inset-0 z-[9999] hidden items-center justify-center p-4 bg-black/70 backdrop-blur-md animate-fade-in'>\n"
				+ "  <div id='userModal' class='glass w-full max-w-md rounded-[3rem] shadow-2xl overflow-hidden hidden relative' style='background: var(--bg); border: 1px solid var(--card-border)'>\n"
				+ "    <button onclick='closeUserModal()' class='absolute top-8 left-8 transition-all text-2xl hover:text-red-500' style='color: var(--text-muted)'>&times;</button>\n"
				+ "    <form id='userForm' action='' method='POST' class='p-10'>\n"
				+ "      <h3 id='modalTitle' class='text-2xl font-black mb-8' style='color: var(--text)'>مدیریت کاربر</h3>\n"
				+ "      <div class='space-y-5'>\n"
				+ "        <div><label class='text-[10px] opacity-40 uppercase mr-2 mb-1 block font-bold'>نام کامل</label><input type='text' name='full_name' id='m_full_name' required class='w-full p-4 rounded-2xl outline-none border border-[var(--card-border)] transition-all focus:border-[var(--primary)]' style='background: var(--card-bg); color: var(--text)'></div>\n"
				+ "        <div><label class='text-[10px] opacity-40 uppercase mr-2 mb-1 block font-bold'>نام کاربری</label><input type='text' name='username' id='m_username' required class='w-full p-4 rounded-2xl outline-none border border-[var(--card-border)] transition-all focus:border-[var(--primary)]' style='background: var(--card-bg); color: var(--text)'></div>\n"
				+ "        <div><label class='text-[10px] opacity-40 uppercase mr-2 mb-1 block font-bold'>رمز عبور</label><input type='password' name='password' id='m_password' class='w-full p-4 rounded-2xl outline-none border border-[var(--card-border)] transition-all focus:border-[var(--primary)]' style='background: var(--card-bg); color: var(--text)'></div>\n"
				+ "        \n" + "        \n" + "        <div>\n"
				+ "          <label class='text-[10px] opacity-40 uppercase mr-2 mb-1 block font-bold'>نقش کاربری</label>\n"
				+ "          <div class='relative'>\n"
				+ "            <select name='role' id='m_role' class='w-full p-4 rounded-2xl outline-none border border-[var(--card-border)] appearance-none cursor-pointer transition-all focus:border-[var(--primary)]' \n"
				+ "                    style='background: var(--card-bg); color: var(--text)'>\n"
				+ "              <option value='student' style='background: var(--bg); color: var(--text)'>دانشجو</option>\n"
				+ "              <option value='admin' style='background: var(--bg); color: var(--text)'>مدیر سیستم</option>\n"
				+ "            </select>\n"
				+ "            <div class='absolute left-4 top-1/2 -translate-y-1/2 pointer-events-none opacity-40'><i class='fa-solid fa-chevron-down text-xs'></i></div>\n"
				+ "          </div>\n" + "        </div>\n" + "      </div>\n"
				+ "      <button type='submit' class='w-full btn-primary py-4 rounded-2xl mt-8 font-black shadow-xl shadow-[var(--primary)]/20 hover:scale-[1.02] transition-transform'>ذخیره تغییرات</button>\n"
				+ "    </form>\n" + "  </div>\n"
				+ "  <div id='deleteModal' class='glass w-full max-w-xs rounded-[2.5rem] p-8 text-center hidden' style='background: var(--bg); border: 1px solid var(--card-border)'>\n"
				+ "    <div class='w-16 h-16 bg-red-500/20 text-red-500 rounded-2xl flex items-center justify-center mx-auto mb-4 text-2xl rotate-12'><i class='fa-solid fa-trash-alt'></i></div>\n"
				+ "    <h3 class='text-lg font-black mb-2' style='color: var(--text)'>حذف کاربر</h3>\n"
				+ "    <p class='text-sm opacity-50 mb-6'>آیا مطمئن هستید؟</p>\n" + "    <div class='flex gap-3'>\n"
				+ "      <form id='deleteForm' method='POST' class='flex-grow'><button type='submit' class='w-full py-3 rounded-xl bg-red-500 text-white font-bold hover:bg-red-600 transition'>حذف</button></form>\n"
				+ "      <button type='button' onclick='closeDeleteModal()' class='flex-grow py-3 rounded-xl glass font-bold' style='color: var(--text)'>لغو</button>\n"
				+ "    </div>\n" + "  </div>\n" + "</div>\n" + "{% endblock %}\n\n" +

				// بخش سوم: اسکریپت‌ها
				"{% block admin_scripts %}\n" + "<script>\n" + "  function openUserModal(user = null) {\n"
				+ "    const layer = document.getElementById('modalLayer');\n"
				+ "    layer.classList.replace('hidden', 'flex');\n"
				+ "    document.getElementById('userModal').classList.remove('hidden');\n" + "    if (user) {\n"
				+ "      document.getElementById('modalTitle').innerText = 'ویرایش پروفایل';\n"
				+ "      document.getElementById('userForm').action = '/admin/user/edit/' + user.id;\n"
				+ "      document.getElementById('m_full_name').value = user.full_name;\n"
				+ "      document.getElementById('m_username').value = user.username;\n"
				+ "      document.getElementById('m_role').value = user.role;\n" + "    } else {\n"
				+ "      document.getElementById('modalTitle').innerText = 'افزودن کاربر جدید';\n"
				+ "      document.getElementById('userForm').action = '/admin/user/add';\n"
				+ "      document.getElementById('userForm').reset();\n" + "    }\n" + "  }\n"
				+ "  function closeUserModal() {\n"
				+ "    document.getElementById('modalLayer').classList.replace('flex', 'hidden');\n"
				+ "    document.getElementById('userModal').classList.add('hidden');\n" + "  }\n"
				+ "  function openDeleteModal(id, name) {\n"
				+ "    document.getElementById('deleteForm').action = '/admin/user/delete/' + id;\n"
				+ "    document.getElementById('modalLayer').classList.replace('hidden', 'flex');\n"
				+ "    document.getElementById('deleteModal').classList.remove('hidden');\n" + "  }\n"
				+ "  function closeDeleteModal() {\n"
				+ "    document.getElementById('modalLayer').classList.replace('flex', 'hidden');\n"
				+ "    document.getElementById('deleteModal').classList.add('hidden');\n" + "  }\n" + "</script>\n"
				+ "{% endblock %}";
	}

	private String generateAdminResultsHtml() {
		StringBuilder sb = new StringBuilder();
		sb.append("{% extends 'admin_base.html' %}\n{% block admin_content %}\n");

		sb.append("<div class='space-y-6 animate-fade-in'>\n");

		// هدر صفحه
		sb.append("    <div class='flex justify-between items-center mb-8'>\n");
		sb.append("        <div class='text-right'>\n");
		sb.append("            <h2 class='text-2xl font-black' style='color: var(--text)'>نتایج و پاسخنامه‌ها</h2>\n");
		sb.append(
				"            <p class='text-sm opacity-50' style='color: var(--text)'>بررسی دقیق عملکرد و تصحیح پاسخنامه‌های شرکت‌کنندگان</p>\n");
		sb.append("        </div>\n");
		sb.append(
				"        <div class='w-12 h-12 rounded-2xl bg-[var(--primary)]/10 flex items-center justify-center text-[var(--primary)]'>\n");
		sb.append("            <i class='fa-solid fa-poll-h text-2xl'></i>\n");
		sb.append("        </div>\n");
		sb.append("    </div>\n");

		// جدول نتایج
		sb.append(
				"    <div class='glass rounded-[2.5rem] overflow-hidden border border-[var(--card-border)] bg-[var(--card-bg)]'>\n");
		sb.append("        <table class='w-full text-right border-collapse'>\n");
		sb.append(
				"            <thead class='text-xs uppercase tracking-wider' style='background: var(--nav-bg); color: var(--text-muted)'>\n");
		sb.append("                <tr>\n");
		sb.append("                    <th class='p-6'>شرکت‌کننده</th>\n");
		sb.append("                    <th class='p-6'>عنوان آزمون</th>\n");
		sb.append("                    <th class='p-6 text-center'>نمره نهایی</th>\n");
		sb.append("                    <th class='p-6 text-center'>وضعیت</th>\n");
		sb.append("                    <th class='p-6 text-center'>عملیات</th>\n");
		sb.append("                </tr>\n");
		sb.append("            </thead>\n");
		sb.append("            <tbody class='divide-y divide-[var(--card-border)]' style='color: var(--text)'>\n");
		sb.append("                {% for res in all_results %}\n");
		sb.append("                <tr class='hover:bg-[var(--primary)]/5 transition-colors group'>\n");
		sb.append("                    <td class='p-6'>\n");
		sb.append("                        <div class='font-bold'>{{ res.user_full_name }}</div>\n");
		sb.append(
				"                        <div class='text-[10px] opacity-40 font-mono text-[var(--text-muted)]'>ID: {{ res.user_id }}</div>\n");
		sb.append("                    </td>\n");
		sb.append("                    <td class='p-6'>\n");
		sb.append("                        <div class='font-medium'>{{ res.quiz_name }}</div>\n");
		sb.append("                        <div class='text-[10px] opacity-40 uppercase'>{{ res.quiz_id }}</div>\n");
		sb.append("                    </td>\n");
		sb.append("                    <td class='p-6 text-center'>\n");
		sb.append(
				"                        <span class='font-black text-[var(--primary)]'>{{ res.finalScore }}</span>\n");
		sb.append("                        <span class='text-xs opacity-30'> / {{ res.maxScore }}</span>\n");
		sb.append("                    </td>\n");
		sb.append("                    <td class='p-6 text-center'>\n");
		sb.append("                        <div class='text-[10px] px-3 py-1 rounded-full border inline-block' \n");
		sb.append("                             style='border-color: var(--card-border); background: var(--bg)'>\n");
		sb.append("                             {{ (res.finalScore / res.maxScore * 100)|round|int }}%\n");
		sb.append("                        </div>\n");
		sb.append("                    </td>\n");
		sb.append("                    <td class='p-6'>\n");
		sb.append("                        <button onclick='openAdminResultModal({{ res.id }})' \n");
		sb.append(
				"                                class='mx-auto w-10 h-10 rounded-xl glass border border-[var(--card-border)] flex items-center justify-center hover:bg-[var(--primary)] hover:text-white transition-all'>\n");
		sb.append("                            <i class='fa-solid fa-eye text-sm'></i>\n");
		sb.append("                        </button>\n");
		sb.append("                    </td>\n");
		sb.append("                </tr>\n");
		sb.append("                {% endfor %}\n");
		sb.append("            </tbody>\n");
		sb.append("        </table>\n");
		sb.append("    </div>\n");
		sb.append("</div>\n");

		// مودال ادمین
		sb.append(
				"<div id='adminResultModal' class='fixed inset-0 z-[9999] hidden flex items-center justify-center p-4 bg-[var(--bg)]/90 backdrop-blur-md animate-fade-in'>\n");
		sb.append(
				"    <div class='w-full max-w-2xl max-h-[85vh] overflow-hidden rounded-[3rem] border border-[var(--card-border)] flex flex-col shadow-2xl' style='background: var(--nav-bg)'>\n");

		sb.append(
				"        <div class='p-6 border-b border-[var(--card-border)] flex justify-between items-center bg-[var(--text)]/5'>\n");
		sb.append(
				"            <button onclick='closeAdminModal()' class='w-10 h-10 rounded-xl hover:bg-red-500/20 hover:text-red-500 transition-all text-2xl' style='color: var(--text-muted)'>&times;</button>\n");
		sb.append("            <h3 class='text-lg font-black' style='color: var(--text)'>بررسی پاسخنامه کاربر</h3>\n");
		sb.append("        </div>\n");

		sb.append(
				"        <div id='adminModalContent' class='p-8 overflow-y-auto flex-1 text-right scrollbar-hide'>\n");
		sb.append("        </div>\n");

		sb.append(
				"        <div class='p-6 border-t border-[var(--card-border)] flex justify-between items-center bg-[var(--text)]/5'>\n");
		sb.append(
				"            <button id='admNext' class='px-8 py-3 rounded-2xl btn-primary text-sm font-bold active:scale-95 transition-transform'>سوال بعدی</button>\n");
		sb.append(
				"            <div id='admStep' class='text-xs font-mono px-4 py-2 rounded-full border border-[var(--card-border)]' style='color: var(--text-muted); background: var(--bg)'></div>\n");
		sb.append(
				"            <button id='admPrev' class='px-8 py-3 rounded-2xl glass border border-[var(--card-border)] text-[var(--text)] text-sm font-bold transition-all'>قبلی</button>\n");
		sb.append("        </div>\n");
		sb.append("    </div>\n");
		sb.append("</div>\n");

		sb.append("<script>\n");
		sb.append("let admResponses = []; let admIndex = 0;\n");

		sb.append("function openAdminResultModal(resultId) {\n");
		sb.append("    fetch(`/api/result/${resultId}`).then(r => r.json()).then(data => {\n");
		sb.append("        admResponses = data.responses;\n");
		sb.append("        admIndex = 0;\n");
		sb.append("        document.getElementById('adminResultModal').classList.replace('hidden', 'flex');\n");
		sb.append("        document.body.style.overflow = 'hidden';\n");
		sb.append("        renderAdminResponse();\n");
		sb.append("    });\n");
		sb.append("}\n");

		// تابع رندر اصلاح شده با منطق مشابه پنل کاربر
		sb.append("function renderAdminResponse() {\n");
		sb.append("    const resp = admResponses[admIndex];\n");
		sb.append("    let scoreStatus = '';\n");
		sb.append("    let indicatorClass = 'border-[var(--card-border)] bg-[var(--bg)]/50';\n");
		sb.append("    let icon = '<i class=\"fa-solid fa-circle-info\"></i>';\n");

		// پیاده‌سازی منطق هوشمند نمره‌دهی و رنگ‌بندی
		sb.append("    if (resp.max_q_score > 0) {\n");
		sb.append("        if (resp.correct === true) {\n");
		sb.append("            scoreStatus = `صحیح | نمره: ${resp.earned_q_score} از ${resp.max_q_score}`;\n");
		sb.append("            indicatorClass = 'border-green-500/40 bg-green-500/10 text-green-500';\n");
		sb.append("            icon = '<i class=\"fa-solid fa-circle-check\"></i>';\n");
		sb.append("        } else if (resp.correct === false) {\n");
		sb.append("            scoreStatus = `غلط | نمره: 0 از ${resp.max_q_score}`;\n");
		sb.append("            indicatorClass = 'border-red-500/40 bg-red-500/10 text-red-500';\n");
		sb.append("            icon = '<i class=\"fa-solid fa-circle-xmark\"></i>';\n");
		sb.append("        } else {\n");
		sb.append("            scoreStatus = `نیاز به تصحیح دستی | بارم: ${resp.max_q_score}`;\n");
		sb.append("            indicatorClass = 'border-yellow-500/40 bg-yellow-500/10 text-yellow-500';\n");
		sb.append("            icon = '<i class=\"fa-solid fa-circle-question\"></i>';\n");
		sb.append("        }\n");
		sb.append("    } else {\n");
		sb.append("        scoreStatus = 'سوال بدون نمره (نظرسنجی/توضیحی)';\n");
		sb.append("    }\n");

		sb.append("    const container = document.getElementById('adminModalContent');\n");
		sb.append("    container.innerHTML = `\n");
		sb.append("        <div class='animate-fade-in'>\n");
		sb.append("            <div class='mb-6'>\n");
		sb.append(
				"                <span class='text-[var(--primary)] text-[10px] font-black uppercase tracking-widest block mb-2 opacity-70'>پرسش ${admIndex + 1}</span>\n");
		sb.append(
				"                <h3 class='text-xl font-bold leading-relaxed' style='color: var(--text)'>${resp.question_text}</h3>\n");
		sb.append("            </div>\n");
		sb.append(
				"            <div class='p-6 rounded-[2rem] border border-[var(--card-border)] mb-6' style='background: var(--bg)'>\n");
		sb.append(
				"                <div class='text-[10px] opacity-40 mb-2 uppercase' style='color: var(--text)'>پاسخ ثبت شده کاربر:</div>\n");
		sb.append(
				"                <div class='text-lg font-medium' style='color: var(--text)'>${resp.answer || '<span class=\"opacity-20 italic\">بدون پاسخ</span>'}</div>\n");
		sb.append("            </div>\n");
		sb.append(
				"            <div class='p-4 rounded-2xl border ${indicatorClass} flex items-center gap-3 transition-all duration-300'>\n");
		sb.append("                <span class='text-xl'>${icon}</span>\n");
		sb.append("                <span class='text-sm font-bold'>${scoreStatus}</span>\n");
		sb.append("            </div>\n");
		sb.append("        </div>\n");
		sb.append("    `;\n");

		sb.append("    document.getElementById('admStep').innerText = `${admIndex + 1} / ${admResponses.length}`;\n");
		sb.append("    const prevBtn = document.getElementById('admPrev');\n");
		sb.append("    prevBtn.disabled = admIndex === 0;\n");
		sb.append("    prevBtn.style.opacity = admIndex === 0 ? '0.3' : '1';\n");
		sb.append(
				"    document.getElementById('admNext').innerText = admIndex === admResponses.length - 1 ? 'بستن' : 'سوال بعدی';\n");

		sb.append(
				"    document.getElementById('admPrev').onclick = () => { if(admIndex > 0) { admIndex--; renderAdminResponse(); } };\n");
		sb.append("    document.getElementById('admNext').onclick = () => {\n");
		sb.append("        if(admIndex < admResponses.length - 1) { admIndex++; renderAdminResponse(); }\n");
		sb.append("        else { closeAdminModal(); }\n");
		sb.append("    };\n");
		sb.append("}\n");

		sb.append("function closeAdminModal() {\n");
		sb.append("    document.getElementById('adminResultModal').classList.replace('flex', 'hidden');\n");
		sb.append("    document.body.style.overflow = 'auto';\n");
		sb.append("}\n");
		sb.append("</script>\n");

		sb.append("{% endblock %}");
		return sb.toString();
	}

	private String generateCss(Theme t) {
		return ":root {\n" + "  --primary: " + t.getPrimaryColor() + ";\n" + "  --secondary: " + t.getSecondaryColor()
				+ ";\n" + "  --bg: " + t.getBackgroundColor() + ";\n" + "  --text: " + t.getTextColor() + ";\n"
				+ "  /* رنگ‌های محاسباتی */\n" + "  --card-bg: color-mix(in srgb, var(--text), transparent 96%);\n"
				+ "  --card-border: color-mix(in srgb, var(--text), transparent 90%);\n"
				+ "  --text-muted: color-mix(in srgb, var(--text), transparent 40%);\n"
				+ "  /* رنگ نوبار در حالت اسکرول: ترکیب رنگ پس‌زمینه با کمی متن برای ایجاد کنتراست */\n"
				+ "  --nav-bg: color-mix(in srgb, var(--bg), var(--text) 5%);\n" + "}\n\n" + "body {\n"
				+ "  background-color: var(--bg);\n" + "  color: var(--text);\n" + "  font-family: '" + t.getFontName()
				+ "', sans-serif;\n" + "  scroll-behavior: smooth;\n" + "  margin: 0;\n" + "}\n\n"
				+ "/* کلاس شیشه‌ای برای حالت عادی (بالای صفحه) */\n" + ".glass {\n" + "  background: transparent;\n"
				+ "  border-bottom: 1px solid transparent;\n" + "  transition: all 0.4s cubic-bezier(0.4, 0, 0.2, 1);\n"
				+ "}\n\n" + "/* کلاس فعال شده هنگام اسکرول */\n" + ".nav-scrolled {\n"
				+ "  background: var(--nav-bg) !important;\n" + "  backdrop-filter: blur(20px);\n"
				+ "  -webkit-backdrop-filter: blur(20px);\n" + "  border-bottom: 1px solid var(--card-border);\n"
				+ "  padding-top: 0.5rem !important;\n" + "  padding-bottom: 0.5rem !important;\n"
				+ "  box-shadow: 0 10px 30px -10px rgba(0,0,0,0.1);\n" + "}\n\n" + ".btn-primary {\n"
				+ "  background: linear-gradient(135deg, var(--primary), var(--secondary));\n"
				+ "  color: white !important;\n" + /* همیشه سفید برای خوانایی */
				"  border: none;\n" + "  transition: all 0.3s ease;\n" + "  cursor: pointer;\n" + "}\n"
				+ ".btn-primary:hover {\n" + "  opacity: 0.9;\n" + "  transform: translateY(-2px);\n"
				+ "  box-shadow: 0 10px 20px -5px var(--primary);\n" + "}\n" + "input:focus {\n"
				+ "  box-shadow: 0 0 0 2px var(--primary);\n" + "  background: var(--bg) !important;\n" + "}\n"
				+ ".animate-fade-in {\n" + "  animation: fadeIn 0.6s ease-out forwards;\n" + "}\n"
				+ "@keyframes fadeIn {\n" + "  from { opacity: 0; transform: translateY(10px); }\n"
				+ "  to { opacity: 1; transform: translateY(0); }\n" + "}\n";
	}
}