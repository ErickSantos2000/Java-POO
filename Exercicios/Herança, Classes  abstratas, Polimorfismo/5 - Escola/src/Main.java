//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SistemaAcademico sistemaAcademico = new SistemaAcademico();
        sistemaAcademico.adicionarCurso(new Curso("Sistemas para Internet"));
        sistemaAcademico.adicionarCurso(new Curso("Gestão Comercial"));

        sistemaAcademico.adicionarAluno(new Aluno("Joãozinho", "123"), "sistemas para internet");
        sistemaAcademico.adicionarAluno(new Aluno("Matheus", "147"), "sistemas para internet");
        sistemaAcademico.adicionarAluno(new Aluno("Felipe", "456"), "gestão comercial");
        sistemaAcademico.adicionarAluno(new Aluno("Santos", "369"), "gestão comercial");

        sistemaAcademico.imprimir();
    }
}