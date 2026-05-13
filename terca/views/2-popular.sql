INSERT INTO cliente(nome) VALUES
('Claudinho'),
('Débora'),
('Edward the Great');

INSERT INTO produto(nome, preco) VALUES
('Hollow Knight: Silksong', 20),
('Dark Souls III', 30),
('Shadow of the Colossus', 40);

INSERT INTO pedido(data_pedido, id_cliente) VALUES
('2026-05-11', 1),
('2026-05-12', 2),
('2026-05-11', 3);

INSERT INTO item_pedido(quantidade, id_pedido, id_produto) VALUES
(2, 1, 1),
(1, 2, 2),
(2, 2, 3),
(1, 3, 1),
(2, 3, 2),
(1, 3, 3);

