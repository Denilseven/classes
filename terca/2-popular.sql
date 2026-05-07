-- Livros

INSERT INTO livro(titulo, autor, ano_publicado) VALUES(
    'C++ Pointers and Dynamic Memory Management',
    'Michael C. Daconta',
    1995);
INSERT INTO livro(titulo, autor, ano_publicado) VALUES(
    'Coders at Work: Reflections on the Craft of Programming',
    'Peter Seibel',
    2009);
INSERT INTO livro(titulo, autor, ano_publicado) VALUES(
    '1984',
    'George Orwell',
    1949);
INSERT INTO livro(titulo, autor, ano_publicado) VALUES(
    '1984',
    'George Orwell',
    1949);
INSERT INTO livro(titulo, autor, ano_publicado) VALUES(
    'The Hobbit',
    'J. R. R. Tolkien',
    1937);
INSERT INTO livro(titulo, autor, ano_publicado) VALUES(
    'I, Robot',
    'Isaac Asimov',
    1950);

-- Alunos

INSERT INTO aluno(nome, curso) VALUES(
    'Zequinha',
    'Cloud'
);
INSERT INTO aluno(nome, curso) VALUES(
    'Roberta',
    'Cloud'
);
INSERT INTO aluno(nome, curso) VALUES(
    'Carlitos',
    'Automação'
);
INSERT INTO aluno(nome, curso) VALUES(
    'Fabiane',
    'Redes'
);
INSERT INTO aluno(nome, curso) VALUES(
    'Laura',
    'Cloud'
);

-- Empréstimos

INSERT INTO emprestimo(data_emprestimo, data_devolucao, id_aluno, id_livro) VALUES(
    '2026-05-05',
    '2026-06-05',
    1,
    5
);
INSERT INTO emprestimo(data_emprestimo, data_devolucao, id_aluno, id_livro) VALUES(
    '2026-04-23',
    '2026-05-23',
    2,
    2
);
INSERT INTO emprestimo(data_emprestimo, data_devolucao, id_aluno, id_livro) VALUES(
    '2026-03-16',
    '2026-04-16',
    3,
    1
);
INSERT INTO emprestimo(data_emprestimo, data_devolucao, id_aluno, id_livro) VALUES(
    '2026-01-29',
    '2026-02-29',
    4,
    2
);
INSERT INTO emprestimo(data_emprestimo, data_devolucao, id_aluno, id_livro) VALUES(
    '2026-07-14',
    '2026-10-14',
    5,
    5
);
INSERT INTO emprestimo(data_emprestimo, data_devolucao, id_aluno, id_livro) VALUES(
    '2026-05-05',
    '2026-06-05',
    1,
    6
);
INSERT INTO emprestimo(data_emprestimo, data_devolucao, id_aluno, id_livro) VALUES(
    '2026-10-23',
    '2026-11-23',
    3,
    5
);
INSERT INTO emprestimo(data_emprestimo, data_devolucao, id_aluno, id_livro) VALUES(
    '2026-04-16',
    '2026-05-16',
    4,
    1
);
INSERT INTO emprestimo(data_emprestimo, data_devolucao, id_aluno, id_livro) VALUES(
    '2026-04-27',
    '2026-05-27',
    4,
    2
);
INSERT INTO emprestimo(data_emprestimo, data_devolucao, id_aluno, id_livro) VALUES(
    '2026-07-10',
    '2026-10-10',
    3,
    2
);

