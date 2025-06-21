public class Aluno extends Pessoa {
    private String matricula;

    public Aluno(String nome, String  matricula){
        super(nome);
        this.matricula = matricula;
    }

    @Override
    public String getNome() {
        return super.getNome();
    }
    public String getMatricula() {
        return matricula;
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public boolean equals(Object obj){
        // verifica se o endereço de memoria é o msm
        if(this == obj) return true;

        // verifica se o objeto a ser comparado é null
        if(obj == null) return false;

        // verifica se a instancia de ambos são a msm
        if(this.getClass() != obj.getClass()) return false;

        // converte para aluno
        Aluno outro = (Aluno) obj;

        // compara a matricula de ambos
        return this.matricula.equals(outro.matricula);
    }

    public int hashCode(){
        int resultado = 17;
        resultado = 31 * resultado + (matricula == null ? 0 : matricula.hashCode());
        return resultado;
    }

//    public int hashCode() {
//        int resultado = 17;
//
//        if (matricula != null) {
//            resultado = 31 * resultado + matricula.hashCode();
//        } else {
//            resultado = 31 * resultado + 0; // opcional, pois +0 não muda nada
//        }
//
//        return resultado;
//    }
}
