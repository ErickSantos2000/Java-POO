CREATE table pessoa(
	id SERIAL PRIMARY KEY,
	nome VARCHAR(50),
	idade INTEGER,
	cpf VARCHAR(14)
);

CREATE table medico(
	id INT PRIMARY KEY,
	especialidade VARCHAR(50)
)INHERITS (pessoa);

CREATE table paciente(
	id INT PRIMARY KEY,
	sintomas VARCHAR(100)
)INHERITS (pessoa);

DROP TABLE pessoa;
DROP TABLE medico;
DROP TABLE paciente;

SELECT * FROM pessoa;
SELECT * FROM medico;
SELECT * FROM paciente;
