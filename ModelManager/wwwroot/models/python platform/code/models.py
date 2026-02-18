from flask_sqlalchemy import SQLAlchemy
from flask_login import UserMixin

db = SQLAlchemy()

class User(db.Model, UserMixin):
    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(80), unique=True)
    password = db.Column(db.String(120))
    full_name = db.Column(db.String(100))
    role = db.Column(db.String(20))

    def to_dict(self):
        return {
            'id': self.id,
            'username': self.username,
            'full_name': self.full_name,
            'role': self.role
        }
class QuizResult(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(50)) # ID در DSL
    user_id = db.Column(db.Integer, db.ForeignKey('user.id'))
    quiz_name = db.Column(db.String(100)) # ارجاع به Quiz
    finalScore = db.Column(db.Integer)
    # رابطه با پاسخ‌ها طبق responses+=UserResponse+
    responses = db.relationship('UserResponse', backref='result', lazy=True, cascade='all, delete-orphan')
    user = db.relationship('User', backref='results')

class UserResponse(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    result_id = db.Column(db.Integer, db.ForeignKey('quiz_result.id'))
    question_name = db.Column(db.Text) # نام  سوال
    answer = db.Column(db.String(500)) # provided_answer
    correct = db.Column(db.Boolean) # is_correct
    score_value = db.Column(db.Integer, nullable=True) # برای نمایش نمره هر سوال
