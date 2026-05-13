-- Listar todos os dados da vw_detalhes_pedidos
SELECT * FROM vw_detalhes_pedidos;

-- Mostrar pedidos com valor total maior que 100
SELECT * FROM vw_total_pedido WHERE total_pedido > 100;

-- Listar os pedidos ordenados do maior para o menor valor
SELECT * FROM vw_total_pedido ORDER BY total_pedido DESC;

