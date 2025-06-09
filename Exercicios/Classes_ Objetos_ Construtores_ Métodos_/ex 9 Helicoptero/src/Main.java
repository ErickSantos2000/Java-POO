import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner e = new Scanner(System.in);
        Frota frota = new Frota();

        int op;
        int escolha;

        do {
            System.out.println("1 - Cadastrar Helicoptero");
            System.out.println("2 - Ligar Helicoptero");
            System.out.println("3 - Desligar Helicoptero");
            System.out.println("4 - Aterrissar");
            System.out.println("5 - Decolar");
            System.out.println("6 - Sair do Helicoptero");
            System.out.println("7 - Entrar no Helicoptero");
            System.out.println("8 - Imprimir lista Helicopteros");
            System.out.println("9 - Estado do Helicoptero");
            System.out.println("0 - Sair do menu");

            System.out.println("Opção: ");
            op = e.nextInt();
            e.nextLine();

            switch (op) {
                case 1:
                    int capacidade;
                    System.out.println("Capacidade:");
                    capacidade = e.nextInt();

                    frota.add(new Helicoptero(capacidade));
                    break;
                case 2:
                    System.out.println("Escolha o helicoptero: ");
                    escolha = e.nextInt();

                    if(frota.ligar(escolha)){
                        System.out.println("Helicopetero " + escolha + " ligou");

                    }
                    else {
                        System.out.println("Helicóptero já está ligado!");

                    }
                    break;

                case 3:
                    System.out.println("Escolha o helicoptero: ");
                    escolha = e.nextInt();

                    if(frota.desligar(escolha)){
                        System.out.println("Helicopetero " + escolha + " desligou");
                    }
                    else {
                        System.out.println("Helicoptero esta no ar ou desligado!");
                    }

                    break;
                case 4:
                    System.out.println("Escolha o helicoptero: ");
                    escolha = e.nextInt();

                    if (frota.aterrissar(escolha)){
                        System.out.println("Helicopetero " + escolha + " aterrissou");
                    }
                    else {
                        System.out.println("Não é possível aterrissar em solo.");
                    }

                    break;

                case 5:
                    System.out.println("Escolha o helicoptero: ");
                    escolha = e.nextInt();

                    if(frota.decolar(escolha)){
                        System.out.println("Helicopetero " + escolha + " decolou");
                    }
                    else {
                        System.out.println("Não é possível decolar. Verifique se o helicóptero está ligado e no solo.");
                    }

                    break;

                case 6:
                    System.out.println("Escolha o helicoptero: ");
                    escolha = e.nextInt();

                    if(frota.sai(escolha)){
                        System.out.println("Saiu 1 do Helicopetero " + escolha);
                    }
                    else{
                        System.out.println("Não é possivel sair pessoas do Helicopetero. Verique se esta vazio ou no ar.");
                    }

                    break;

                case 7:
                    System.out.println("Escolha o helicoptero: ");
                    escolha = e.nextInt();

                    if(frota.entra(escolha)){
                        System.out.println("Entrou 1 pessoa no Helicopetero " + escolha);
                    }

                    break;

                case 8:
                    frota.imprimir();
                    break;

                case 9:
                    System.out.println("Escolha o helicoptero: ");
                    escolha = e.nextInt();
                    frota.estadoHelicoptero(escolha);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção invalida...");
                    break;

            }
        } while (op != 0);
        e.close();
    }
}
