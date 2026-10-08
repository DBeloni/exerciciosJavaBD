CREATE TABLE item (
	id BIGINT PRIMARY KEY,
	codigo VARCHAR(8) NOT NULL,
	titulo VARCHAR(100) NOT NULL,
	tipo VARCHAR(10) NOT NULL CHECK (tipo IN ('LIVRO', 'REVISTA')),
	autor VARCHAR(100) NOT NULL,
	edicao VARCHAR(100) NOT NULL,
	disponivel BOOLEAN NOT NULL DEFAULT true
);

CREATE TABLE usuario (
	id BIGINT PRIMARY KEY,
	nome VARCHAR(100) NOT NULL,
	tipo VARCHAR(20) NOT NULL CHECK (tipo IN ('ALUNO', 'PROFESSOR')),
	limite_itens INT NOT NULL
);

CREATE TABLE emprestimo (
	id BIGINT PRIMARY KEY,
	id_usuario BIGINT NOT NULL,
	id_item BIGINT NOT NULL,
	data_retirada DATE NOT NULL,
	data_devolucao_prevista DATE NOT NULL,
	data_devolucao DATE,
	valor_multa DECIMAL(10, 2) NOT NULL DEFAULT 0.00,
	FOREIGN KEY (id_usuario) REFERENCES usuario(id),
	FOREIGN KEY (id_item) REFERENCES item(id)
);

INSERT INTO item (id, codigo, titulo, tipo, autor, edicao) VALUES
(1, 'LIV001', 'O Senhor dos Anéis', 'LIVRO', 'J.R.R. Tolkien', '1ª Edição'),
(2, 'LIV002', '1984', 'LIVRO', 'George Orwell', '1ª Edição'),
(3, 'REV001', 'Revista Ciência Hoje', 'REVISTA', 'Vários Autores', 'Edição 100'),
(4, 'REV002', 'Revista Super Interessante', 'REVISTA', 'Vários Autores', 'Edição 200');

INSERT INTO usuario (id, nome, tipo, limite_itens) VALUES
(1, 'Alice Silva', 'ALUNO', 3),
(2, 'Bob Santos', 'PROFESSOR', 5);

INSERT INTO emprestimo (id, id_usuario, id_item, data_retirada, data_devolucao_prevista) VALUES
(1, 1, 1, '2024-06-01', '2024-06-15'),
(2, 2, 3, '2024-06-05', '2024-06-19');

UPDATE item
SET disponivel = false
WHERE id IN (
	SELECT id_item
	FROM emprestimo
	WHERE data_devolucao IS NULL
);