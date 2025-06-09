public class Fita{
    private String titulo;
    private int precoAluguelDia;

    public Fita(String titulo, int precoAluguelDia){
        this.titulo = titulo;
        this.precoAluguelDia =  precoAluguelDia;
    }

    public String getTitulo(){
        return titulo;
    }
    public int getPrecoAluguelDia(){
        return precoAluguelDia;
    }

    public int getValorAluguel(int dias){
        int aluguel  = precoAluguelDia * dias;
        return aluguel;
    }

    public String toString(){
        return "Titulo: "+ titulo + " Preço do aluguel: "+ precoAluguelDia;
    }
}