import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Mercado mercado = new Mercado();
        Scanner entrada = new Scanner(System.in);

        int op;
        float valor ;
        String nome ;
        String nomeRemovido;
        String nomeProcurado;

        do {
            System.out.println("---MENU---");
            System.out.println("1 - adicionar produto");
            System.out.println("2 - remover produto");
            System.out.println("3 - pesquisar produto");
            System.out.println("4 - imprimir produto");
            System.out.println("0 - sair");
            System.out.println("digite a opção:");
            op = entrada.nextInt();

            entrada.nextLine(); // limpeza de buffer

            switch (op){
                case 1:
                    System.out.printf("Nome: ");
                    nome = entrada.nextLine();

                    entrada.nextLine(); // limpeza de buffer

                    System.out.printf("Valor: ");
                    valor = entrada.nextInt();

                    mercado.add(new Produto(nome, valor));
                    break;

                case 2:
                    System.out.println("Produto que deseja remover:");
                    nomeRemovido = entrada.nextLine();

                    if(mercado.remover(nomeRemovido)){
                        mercado.remover(nomeRemovido);
                        System.out.println(nomeRemovido + " foi removido!");
                    }
                    else {
                        System.out.println("Lista de produtos esta vazio!");
                    }
                    break;

                case 3:
                    System.out.println("Produto que deseja perquisar:");
                    nomeProcurado = entrada.nextLine();

                    if(mercado.pesquisar(nomeProcurado)){
                        System.out.println(nomeProcurado + " foi achado!");
                    }
                    else {
                        System.out.println(nomeProcurado + " não foi achado!");
                    }
                    break;

                case 4:
                    mercado.imprimir();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção invalida!");
            }


        } while (op != 0);
        entrada.close();
    }
}