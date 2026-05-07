SELECT nome FROM aluno;

SELECT a.nome, l.titulo, e.data_emprestimo
FROM emprestimo e
JOIN aluno a ON e.id_aluno = a.id
JOIN livro l ON e.id_livro = l.id;

SELECT a.nome, COUNT(e.id)
FROM emprestimo e
JOIN aluno a ON e.id_aluno = a.id
GROUP BY a.id, a.nome
ORDER BY COUNT(e.id) DESC;

