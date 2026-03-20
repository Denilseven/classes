from flask import Flask, render_template, session, request, redirect
from flask_session import Session
from helpers import apology, login_required

app = Flask(__name__)

# Configure session to use filesystem (instead of signed cookies)
app.config["SESSION_PERMANENT"] = False
app.config["SESSION_TYPE"] = "filesystem"
Session(app)

@app.after_request
def after_request(response):
    # Ensure responses aren't cached
    response.headers["Cache-Control"] = "no-cache, no-store, must-revalidate"
    response.headers["Expires"] = 0
    response.headers["Pragma"] = "no-cache"
    return response

@app.route("/")
def index():
    return render_template("index.html")

@app.route("/login", methods=["GET", "POST"])
def login():
    session.clear()

    # User reached route via POST (as by submitting a form via POST)
    if request.method == "POST":
        if not request.form.get("username"):
            return apology("O campo de usuário é necessário")
        if not request.form.get("password"):
            return apology("O campo de senha é necessário")
        # TODO: Username and password validation.
        session["user_id"] = "123"
        return redirect("/")
        
    # User reached route via GET (as by clicking a link or via redirect)
    else:
        return render_template("login.html")

@app.route("/logout")
def logout():
    session.clear()
    return redirect("/")
