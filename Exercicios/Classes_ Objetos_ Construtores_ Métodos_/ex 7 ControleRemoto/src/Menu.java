import java.util.Scanner;

public class Menu {
    private Televisor tv;
    private ControleRemoto controle;

    public Menu(Televisor tv, ControleRemoto controle) {
        this.tv = tv;
        this.controle = controle;
    }

    public void menuControle() {
        Scanner sc = new Scanner(System.in);
        int op;
        do {
            System.out.println("---Controle---");
            if (controle.getLigado() == false) {
                System.out.println("1 - Ligar TV");
            } else {
                System.out.println("1 - Desligar TV");
            }
            System.out.println("2 - Trocar de canal");
            System.out.println("3 - Aumentar volume");
            System.out.println("4 - Diminuir volume");
            System.out.println("5 - Mostrar estado do Obj");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção:");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    if (controle.getLigado() == false) {
                        controle.ligar();
                        System.out.println("TV ligada!");
                    } else {
                        controle.desligar();
                        System.out.println("TV desligada!");
                    }
                    break;

                case 2:
                    if (controle.getLigado() == true) {
                        System.out.println("Informe para qual canal deseja trocar:");
                        int opCanal = sc.nextInt();

                        if (controle.getCanal() == opCanal) {
                            System.out.println("Você já está no canal " + controle.getCanal());
                        }
                        else {
                            controle.trocarCanal(opCanal);
                            System.out.println("Canal trocado para: " + controle.getCanal());
                        }
                    }

                    else {
                        System.out.println("TV está desligada, não é possível trocar de canal!");
                    }

                    break;

                case 3:
                    if (controle.getLigado() == true && controle.getVolume() < 100) {
                        controle.aumentarVolume();
                        System.out.println("Aumentou volume!");
                        System.out.println("Volume: " + controle.getVolume());
                    }

                    else if (controle.getLigado() == false) {
                        System.out.println("TV está desligada, não é possível aumentar volume!");
                    }

                    else {
                        System.out.println("Atingiu volume máximo");
                        System.out.println("Volume: " + controle.getVolume());
                    }
                    break;

                case 4:
                    if (controle.getLigado() == true && controle.getVolume() > 0) {
                        controle.diminuirVolume();
                        System.out.println("Volume diminuiu!");
                        System.out.println("Volume: " + controle.getVolume());
                    } else if (controle.getLigado() == false) {
                        System.out.println("TV está desligada, não é possível diminuir volume!");
                    } else {
                        System.out.println("Atingiu volume mínimo");
                        System.out.println("Volume: " + controle.getVolume());
                    }
                    break;
                case 5:
                    System.out.println(controle.toString());
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (op != 0);
    }

    public void menuTelevisao() {
        Scanner sc = new Scanner(System.in);
        int op;
        do {
            System.out.println("---Televisão---");
            if (tv.getLigado() == false) {
                System.out.println("1 - Ligar TV");
            } else {
                System.out.println("1 - Desligar TV");
            }
            System.out.println("2 - Trocar de canal");
            System.out.println("3 - Aumentar volume");
            System.out.println("4 - Diminuir volume");
            System.out.println("5 - Mostrar estado do Obj");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção:");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    if (tv.getLigado() == false) {
                        tv.ligar();
                        System.out.println("TV ligada!");
                    } else {
                        tv.desligar();
                        System.out.println("TV desligada!");
                    }
                    break;

                case 2:
                    if (tv.getLigado() == true) {
                        System.out.println("Informe para qual canal deseja trocar:");
                        int trocarCanal = sc.nextInt();
                        if (tv.getCanal() == trocarCanal) {
                            System.out.println("Você já está no canal " + tv.getCanal());
                        } else {
                            tv.trocarCanal(trocarCanal);
                            System.out.println("Canal trocado para: " + tv.getCanal());
                        }
                    } else {
                        System.out.println("TV está desligada, não é possível trocar de canal!");
                    }
                    break;

                case 3:
                    if (tv.getLigado() == true && tv.getVolume() < 100) {
                        controle.aumentarVolume();
                        System.out.println("Aumentou volume!");
                        System.out.println("Volume: " + tv.getVolume());
                    }

                    else if (tv.getLigado() == false) {
                        System.out.println("TV está desligada, não é possível aumentar volume!");
                    }

                    else {
                        System.out.println("Atingiu volume máximo");
                        System.out.println("Volume: " + tv.getVolume());
                    }
                    break;

                case 4:
                    if (tv.getLigado() == true && tv.getVolume() > 0) {
                        tv.diminuirVolume();
                        System.out.println("Volume diminuiu!");
                        System.out.println("Volume: " + tv.getVolume());
                    } else if (tv.getLigado() == false) {
                        System.out.println("TV está desligada, não é possível diminuir volume!");
                    } else {
                        System.out.println("Atingiu volume mínimo");
                        System.out.println("Volume: " + tv.getVolume());
                    }
                    break;
                case 5:
                    System.out.println(tv.toString());
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (op != 0);
    }

    public void menuPrincipal() {
        Scanner sc = new Scanner(System.in);
        int op;
        do {
            System.out.println("1 - TV");
            System.out.println("2 - Controle");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção:");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    menuTelevisao();
                    break;
                case 2:
                    menuControle();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (op != 0);
        sc.close();
    }
}