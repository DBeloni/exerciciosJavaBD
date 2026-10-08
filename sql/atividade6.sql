-- Consulta 1
SELECT codigo, titulo, tipo, disponivel AS disponibilidade
FROM item;

-- Consulta 2
SELECT u.nome, i.titulo
FROM emprestimo e
JOIN usuario u ON u.id = e.id_usuario
JOIN item i ON e.id_item = i.id
WHERE e.data_devolucao IS NULL;

-- Consulta 3
SELECT u.nome, SUM(e.valor_multa) AS total_multa
FROM emprestimo e
JOIN usuario u ON u.id = e.id_usuario
GROUP BY u.id, u.nome
ORDER BY total_multa DESC;

