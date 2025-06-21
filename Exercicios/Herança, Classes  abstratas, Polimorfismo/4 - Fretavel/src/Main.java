public class Main {
    public static void main(String[] args) {
        CadastroFrete cadastro = new CadastroFrete();
        FretePadrao padrao = new FretePadrao(100, 10);
        FreteExpresso expresso = new FreteExpresso(150, 10, 2);
        FreteSuperExpresso superF = new FreteSuperExpresso(100, 10, 3, 100);

        cadastro.add(padrao);
        cadastro.add(expresso);
        cadastro.add(superF);


        System.out.println("Total: " + cadastro.calcularTotalFrete());
    }
}