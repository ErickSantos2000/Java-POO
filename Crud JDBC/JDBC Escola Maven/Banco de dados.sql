
CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50),
    email_academico VARCHAR(50),
    senha VARCHAR(50)
);

CREATE TABLE materia (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE professor (
    id_usuario INTEGER PRIMARY KEY REFERENCES usuario(id) ON DELETE CASCADE,
    matricula VARCHAR(30),
    id_materia INTEGER REFERENCES materia(id)
);

CREATE TABLE aluno (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100),
    idade INTEGER,
    email_academico VARCHAR(50),
    matricula VARCHAR(20),
    id_materia INTEGER REFERENCES materia(id)
);

CREATE TABLE nota (
    id SERIAL PRIMARY KEY,
    aluno_id INTEGER REFERENCES aluno(id),
    valor NUMERIC(5,2)
);

INSERT INTO usuario (nome, email_academico, senha)
VALUES ('Professor NINJA', 'NINJA@academico.com', '123');

INSERT INTO materia (nome) 
VALUES ('Programação Orientada a Objetos');

INSERT INTO professor (id_usuario, matricula, id_materia)
VALUES (
    (SELECT id FROM usuario WHERE email_academico = 'NINJA@academico.com'),
    'MAT2025',
    (SELECT id FROM materia WHERE nome = 'Programação Orientada a Objetos')
);

INSERT INTO aluno (nome, idade, email_academico, matricula, id_materia)
VALUES 
('Aluno Teste 1', 20, 'aluno1@academico.com', 'ALU123', 1),
('Aluno Teste 2', 21, 'aluno2@academico.com', 'ALU456', 1),
('Aluno Teste 3', 22, 'aluno3@academico.com', 'ALU789', 1);


DROP TABLE IF EXISTS nota;
DROP TABLE IF EXISTS aluno;
DROP TABLE IF EXISTS professor;
DROP TABLE IF EXISTS materia;
DROP TABLE IF EXISTS usuario;
