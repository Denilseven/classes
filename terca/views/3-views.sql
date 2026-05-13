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

-- nome do cliente
-- id do pedido
-- nome do produto
-- quantidade
-- preço

-- Usar JOIN entre as tabelas

