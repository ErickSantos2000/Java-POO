package app.model;

public class Professor extends Usuario {
    private String matricula;
    private Materia materia;

    public Professor(String nome, String email_academico, String senha, String matricula, Materia materia) {
        super(nome, email_academico, senha);
        this.matricula = matricula;
        this.materia = materia;
    }

    @Override
    public String getSenha() {
        return super.getSenha();
    }

    @Override
    public String getEmail_academico() {
        return super.getEmail_academico();
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    public String getMatricula() { return matricula; }
    public Materia getMateria() { return materia; }

    public void setMatricula(String matricula) { this.matricula = matricula; }
    public void setMateria(Materia materia) { this.materia = materia; }

}
