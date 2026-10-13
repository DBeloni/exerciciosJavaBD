CREATE TABLE item (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    codigo VARCHAR(8) NOT NULL UNIQUE,
    titulo VARCHAR(100) NOT NULL,
    tipo VARCHAR(10) NOT NULL CHECK (tipo IN ('LIVRO', 'REVISTA')),
    autor VARCHAR(100) NOT NULL,
    edicao VARCHAR(100) NOT NULL,
    disponivel BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE usuario (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    tipo VARCHAR(20) NOT NULL CHECK (tipo IN ('ALUNO', 'PROFESSOR')),
    limite_itens INT NOT NULL CHECK (limite_itens > 0)
);

CREATE TABLE emprestimo (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    item_id BIGINT NOT NULL REFERENCES item(id),
    usuario_id BIGINT NOT NULL REFERENCES usuario(id),
    data_retirada DATE NOT NULL,
    data_devolucao_prevista DATE NOT NULL,
    data_devolucao DATE,
    valor_multa NUMERIC(10, 2) NOT NULL DEFAULT 0.00 CHECK (valor_multa >= 0),
    CHECK (data_devolucao_prevista >= data_retirada),
    CHECK (data_devolucao IS NULL OR data_devolucao >= data_retirada)
);

INSERT INTO item (codigo, titulo, tipo, autor, edicao) VALUES
    ('LIV001', 'O Senhor dos Anéis', 'LIVRO', 'J.R.R. Tolkien', '1ª Edição'),
    ('LIV002', '1984', 'LIVRO', 'George Orwell', '1ª Edição'),
    ('REV001', 'Revista Ciência Hoje', 'REVISTA', 'Vários Autores', 'Edição 100'),
    ('REV002', 'Revista Super Interessante', 'REVISTA', 'Vários Autores', 'Edição 200');

INSERT INTO usuario (nome, tipo, limite_itens) VALUES
    ('Davi Beloni', 'ALUNO', 3),
    ('Jaques Antunes', 'PROFESSOR', 5);

INSERT INTO emprestimo
    (item_id, usuario_id, data_retirada, data_devolucao_prevista, data_devolucao, valor_multa)
SELECT i.id, u.id, CURRENT_DATE - 17, CURRENT_DATE - 3, CURRENT_DATE, 1.50
FROM item i
JOIN usuario u ON u.nome = 'Davi Beloni'
WHERE i.codigo = 'LIV001'
UNION ALL
SELECT i.id, u.id, CURRENT_DATE - 2, CURRENT_DATE + 5, NULL::DATE, 0.00
FROM item i
JOIN usuario u ON u.nome = 'Jaques Antunes'
WHERE i.codigo = 'REV001';

UPDATE item i
SET disponivel = NOT EXISTS (
    SELECT 1
    FROM emprestimo e
    WHERE e.item_id = i.id
      AND e.data_devolucao IS NULL
);

CREATE UNIQUE INDEX uq_emprestimo_item_em_aberto
    ON emprestimo (item_id)
    WHERE data_devolucao IS NULL;
