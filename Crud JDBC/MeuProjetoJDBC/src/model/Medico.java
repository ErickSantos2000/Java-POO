package src.model;
public class Medico extends Pessoa {
    private String especialidade;

    public Medico(int id, String nome, int idade, String cpf, String especialidade) {
        super(id, nome, idade, cpf);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Especialidade: " + especialidade);
    }
}
