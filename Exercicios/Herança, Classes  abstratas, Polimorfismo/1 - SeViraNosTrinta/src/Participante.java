public abstract class Participante {
    private String nome;

    public Participante(String nome){
        this.nome = nome;
    }

    public abstract void seViraNosTrinta();

    public String getNome() {
        return nome;
    }
}