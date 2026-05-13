-- nome do cliente
-- id do pedido
-- nome do produto
-- quantidade
-- preço
CREATE VIEW vw_detalhes_pedidos AS
SELECT
	_cliente.nome AS cliente,
	_item.id_pedido AS pedido_id,
	_produto.nome AS produto,
	_item.quantidade,
	_produto.preco
FROM item_pedido _item
JOIN pedido _pedido ON _item.id_pedido = _pedido.id
JOIN produto _produto ON _item.id_produto = _produto.id
JOIN cliente _cliente ON _pedido.id_cliente = _cliente.id;

-- id do pedido
-- nome do cliente
-- valor total do pedido
CREATE VIEW vw_total_pedido AS
SELECT
	_pedido.id AS pedido_id,
	_cliente.nome AS cliente,
	SUM(_item.quantidade * _produto.preco) AS total_pedido
FROM item_pedido _item
JOIN pedido _pedido ON _item.id_pedido = _pedido.id
JOIN produto _produto ON _item.id_produto = _produto.id
JOIN cliente _cliente ON _pedido.id_cliente = _cliente.id
GROUP BY _pedido.id, _cliente.nome;

-- *Tenho que ver como esse GROUP BY funciona especificamente,
-- mas sem ele, o resultado dessa query fica com apenas uma linha.
-- Isso tem alguma coisa a ver com o SUM. Aparentemente, o SUM
-- soma o resultado de todas as linhas, deve ser isso mesmo.

-- Pelo menos com essa atividade eu consegui entender melhor
-- como usar o JOIN!

