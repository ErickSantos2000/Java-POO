import java.util.HashSet;

public class Curso {
    private String nome;
    private HashSet<Aluno> alunos;

    public Curso(String nome){
        this.nome = nome;
        alunos = new HashSet<>();
    }

    public String getNome() {
        return nome;
    }

    public HashSet<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(HashSet<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public String toString() {
        return "Nome: " + nome;
    }
}
