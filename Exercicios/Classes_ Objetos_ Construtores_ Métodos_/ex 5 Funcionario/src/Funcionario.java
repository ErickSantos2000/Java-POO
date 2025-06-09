import com.sun.nio.sctp.SctpSocketOption;

public class Funcionario{
    private int codigo;
    private String nome;
    private String CPF;
    private String endereco;
    private String telefone;
    private int idade;
    private float salario;

    public Funcionario(int codigo, String nome, String CPF, String endereco, String telefone, int idade, float salario) {
        this.codigo = codigo;
        this.nome = nome;
        this.CPF = CPF;
        this.endereco = endereco;
        this.telefone = telefone;
        this.idade = idade;
        this.salario = salario;
    }

    public int getCodigo(){
        return codigo;
    }
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCPF(){
        return CPF;
    }
    public void setCPF(String CPF){
        this.CPF = CPF;
    }

    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public String getTelefone(){
        return telefone;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public int getIdade(){
        return idade;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }

    public float getSalario(){
        return salario;
    }
    public void setSalario(float salario){
        this.salario = salario;
    }

    public String estadoObj(){
        return String.format("Codigo: %d\nNome: %s\nCPF: %s\nEndereço: %s\nTelefone: %s\nIdade: %d\nSalario: %.2f", codigo, nome, CPF, endereco, telefone, idade, salario);
    }


    public float calcularSalarioLiquido() {
        float salarioLiquido = salario * (11f / 100);
        salarioLiquido =  salario - salarioLiquido;
        return salarioLiquido;
    }
}