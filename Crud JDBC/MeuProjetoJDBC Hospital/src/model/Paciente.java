package src.model;
public class Paciente extends Pessoa {
    private String sintomas;

    public Paciente(int id, String nome, int idade, String cpf, String sintomas) {
        super(id, nome, idade, cpf);
        this.sintomas = sintomas;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Sintomas: " + sintomas);
    }
}
