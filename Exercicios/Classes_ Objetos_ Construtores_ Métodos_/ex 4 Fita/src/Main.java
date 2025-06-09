public class Main {
    public static void main(String[] args){
        Fita f = new Fita("Anel", 20);

        System.out.println("Titulo: "+ f.getTitulo());
        System.out.println("Preço do aluguel: "+ f.getPrecoAluguelDia());

        System.out.println();

        System.out.println("Aluguel por dia: " + f.getValorAluguel(3));
        System.out.println(f.toString());
    }
}