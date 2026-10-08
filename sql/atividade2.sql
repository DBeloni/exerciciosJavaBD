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

