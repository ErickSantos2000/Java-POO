package app.model;
public class Usuario {
    private int id; // <-- adicione isso
    private String nome;
    private String email_academico;
    private String senha;

    public Usuario(String nome, String email_academico, String senha) {
        this.nome = nome;
        this.email_academico = email_academico;
        this.senha = senha;
    }

    // GETTER e SETTER para o id
    public int getId() {
        return id;
    }


    public String getEmail_academico() {
        return email_academico;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setId(int id) {
        this.id = id;
    }

    // ... outros getters e setters
}
