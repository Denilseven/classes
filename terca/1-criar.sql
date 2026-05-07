CREATE TABLE IF NOT EXISTS aluno(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL,
    curso TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS livro(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    titulo TEXT NOT NULL,
    autor TEXT,
    ano_publicado INTEGER
);

CREATE TABLE IF NOT EXISTS emprestimo(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    data_emprestimo TEXT NOT NULL,
    data_devolucao TEXT NOT NULL,
    id_aluno INTEGER NOT NULL,
    id_livro INTEGER NOT NULL,
    FOREIGN KEY(id_aluno) REFERENCES aluno(id),
    FOREIGN KEY(id_livro) REFERENCES livro(id)
);

