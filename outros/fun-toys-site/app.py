import sqlite3, db
from flask import Flask, render_template, session, request, redirect
from flask_session import Session
from helpers import apology, login_required, brl
from werkzeug.security import check_password_hash, generate_password_hash

app = Flask(__name__)
app.jinja_env.filters["brl"] = brl

# Configure session to use filesystem (instead of signed cookies)
app.config["SESSION_PERMANENT"] = False
app.config["SESSION_TYPE"] = "filesystem"
Session(app)

# Setup database
db.init_db()

@app.after_request
def after_request(response):
    # Ensure responses aren't cached
    response.headers["Cache-Control"] = "no-cache, no-store, must-revalidate"
    response.headers["Expires"] = 0
    response.headers["Pragma"] = "no-cache"
    return response

@app.route("/")
@login_required
def index():
    conn = sqlite3.connect("banco.db", check_same_thread=True)
    conn.row_factory = sqlite3.Row
    cur = conn.cursor()
    
    cur.execute("SELECT nome, fabricante, valor, estoque FROM brinquedo ORDER BY nome DESC;")
    toys_data = cur.fetchall()
    cur.close()
    conn.close()

    return render_template("index.html", toys_data = toys_data)

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
        # Check if there is ANY user in the database, if not, do the "first user setup"
        conn = sqlite3.connect("banco.db", check_same_thread=True)
        cur = conn.cursor()
        cur.execute("SELECT EXISTS(SELECT 1 FROM funcionario LIMIT 1);")
        exists = (cur.fetchone()[0] == True)
        cur.close()
        conn.close()
        if (not exists):
            return render_template("firstusersetup.html")

        return render_template("login.html")
    
@app.route("/firstusersetup", methods=["POST"])
def firstusersetup():
    password = request.form.get("password") # chat is this safe?
    if not password:
        return apology("O campo de senha é necessário")
    conn = sqlite3.connect("banco.db", check_same_thread=True)
    cur = conn.cursor()

    cur.execute("INSERT INTO pessoa(nome) VALUES('ADMINISTRADOR');")
    hash = generate_password_hash(password)
    new_id = cur.lastrowid
    cur.execute("INSERT INTO funcionario(cargo, id_pessoa, hash_senha, salario) VALUES('ADMIN', ?, ?, 0);", (new_id, hash))

    conn.commit()
    cur.close()
    conn.close()

    return redirect("/")


@app.route("/logout")
def logout():
    session.clear()
    return redirect("/")

@app.route("/registertoy", methods=["GET", "POST"])
@login_required
def registertoy():
    if request.method == "POST":
        toyname = request.form.get("toyname")
        manufacturer = request.form.get("manufacturer")
        value = request.form.get("value")
        quantity = request.form.get("quantity")

        if (not toyname or not manufacturer or not value or not quantity):
            return apology("Todos os campos são necessários")
        
        conn = sqlite3.connect("banco.db", check_same_thread=True)
        cur = conn.cursor()
        cur.execute("INSERT INTO brinquedo(nome, fabricante, valor, estoque) VALUES(?, ?, ?, ?);", (toyname, manufacturer, value, quantity))
        conn.commit()
        cur.close()
        conn.close() # kinda crazy all these lines for one thingy

        return redirect("/")

    else:
        return render_template("registertoy.html")
