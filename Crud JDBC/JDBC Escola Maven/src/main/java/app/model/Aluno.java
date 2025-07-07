package app.model;

public class Aluno {
    private int id;
    private String nome;
    private int idade;
    private String email_academico;
    private String matricula;

    public Aluno(String nome, int idade, String email_academico) {
        this.nome = nome;
        this.idade = idade;
        this.email_academico = email_academico;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getEmail_academico() {
        return email_academico;
    }

    public String getMatricula() {
        return matricula;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setEmail_academico(String email_academico) {
        this.email_academico = email_academico;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
