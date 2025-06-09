import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int escolha = -1;

        while (escolha != 0) {
            System.out.println("Escolha as opções:");
            System.out.println("1 - Luta recursiva");
            System.out.println("2 - Luta interativa");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            escolha = entrada.nextInt();

            switch (escolha) {
                case 1:
                    Guerreiro g1 = new Guerreiro("Erick", 2000);
                    Guerreiro g2 = new Guerreiro("Felipe", 3000);
                    g1.LutaRecursiva(g2);
                    g2.LutaRecursiva(g1);
                    break;
                case 2:
                    Guerreiro g1r = new Guerreiro("Erick", 2000);
                    Guerreiro g2r = new Guerreiro("Felipe", 3000);
                    g1r.lutaInterativa(g2r);
                    g2r.lutaInterativa(g1r);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }

        entrada.close();
    }
}