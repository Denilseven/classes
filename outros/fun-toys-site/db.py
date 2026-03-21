import sqlite3

conn = sqlite3.connect('banco.db')
cur = conn.cursor()

def init_db():
    cur.execute(
        """
        CREATE TABLE IF NOT EXISTS pessoa(
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            nome TEXT NOT NULL,
            cpf INTEGER,
            email TEXT UNIQUE,
            tel INTEGER,
            endereco TEXT
        );
        """
    )

    cur.execute(
        """
        CREATE TABLE IF NOT EXISTS funcionario(
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            salario REAL NOT NULL,
            cargo TEXT NOT NULL,
            id_pessoa INTEGER NOT NULL,
            FOREIGN KEY(id_pessoa) REFERENCES pessoa(id)
        );
        """
    )

    cur.execute(
        """
        CREATE TABLE IF NOT EXISTS brinquedo(
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            nome TEXT NOT NULL,
            valor REAL NOT NULL,
            fabricante TEXT,
            estoque INTEGER NOT NULL DEFAULT 1
        );
        """
    )

    cur.execute(
        """
        CREATE TABLE IF NOT EXISTS compra(
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            data DATETIME NOT NULL,
            metodo_pgto TEXT NOT NULL,
            nota_fiscal TEXT NOT NULL,
            id_pessoa INTEGER NOT NULL,
            id_funcionario INTEGER NOT NULL,
            FOREIGN KEY(id_pessoa) REFERENCES pessoa(id),
            FOREIGN KEY(id_funcionario) REFERENCES funcionario(id)
        );
        """
    )

    cur.execute(
        """
        CREATE TABLE IF NOT EXISTS brinquedo_join_compra(
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            quantidade INTEGER NOT NULL DEFAULT 1,
            valor_unitario REAL NOT NULL,
            id_compra INTEGER,
            id_brinquedo INTEGER,
            FOREIGN KEY(id_compra) REFERENCES compra(id),
            FOREIGN KEY(id_brinquedo) REFERENCES brinquedo(id)
        );
        """
    )
