import java.util.ArrayList;

public class SistemaAcademico {
    private ArrayList<Curso> cursos;

    public SistemaAcademico(){
        cursos = new ArrayList<>();
    }

    void adicionarCurso(Curso c){
        this.cursos.add(c);
    }

    void adicionarAluno(Aluno a, String cursoProcurado){
        Curso cursoEncontrado = null;

        for(Curso curso : cursos){
            if(curso.getNome().equalsIgnoreCase(cursoProcurado)){
                cursoEncontrado = curso;
                break;
            }
        }

        if(cursoEncontrado == null){
            System.out.println(cursoProcurado + " não foi encontrado!");
            return;
        }
        cursoEncontrado.getAlunos().add(a);
    }

    void imprimir(){
        for(Curso curso : cursos){
            System.out.println("Curso: " + curso.getNome());
            for (Aluno aluno : curso.getAlunos()){
                System.out.println(" - " + aluno.getNome() + "(" + aluno.getMatricula() + ")");
            }
        }
    }
}
