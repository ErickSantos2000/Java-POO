import java.util.Scanner;
import src.dao.MedicoDAO;
import src.dao.PacienteDAO;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MedicoDAO medicoDAO = new MedicoDAO();
        PacienteDAO pacienteDAO = new PacienteDAO();

        int opcaoPrincipal;
        int opcaoMedico;
        int opcaoPaciente;

        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Menu Médico");
            System.out.println("2. Menu Paciente");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcaoPrincipal = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcaoPrincipal) {
                case 1:
                    do {
                        System.out.println("\n--- MENU MÉDICO ---");
                        System.out.println("1. Inserir Médico");
                        System.out.println("2. Listar Médicos");
                        System.out.println("3. Buscar Médico por Nome");
                        System.out.println("4. Deletar Médico por ID");
                        System.out.println("5. Atualizar Médico");
                        System.out.println("0. Voltar");
                        System.out.print("Escolha uma opção: ");
                        opcaoMedico = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcaoMedico) {
                            case 1:
                                System.out.print("Nome do médico: ");
                                String nomeMed = scanner.nextLine();

                                System.out.print("Idade: ");
                                int idadeMed = scanner.nextInt();
                                scanner.nextLine();

                                System.out.print("CPF: ");
                                String cpfMed = scanner.nextLine();

                                System.out.print("Especialidade: ");
                                String esp = scanner.nextLine();

                                medicoDAO.inserir(nomeMed, idadeMed, cpfMed, esp);
                                break;

                            case 2:
                                medicoDAO.listar();
                                break;

                            case 3:
                                System.out.print("Nome a buscar: ");
                                String nomeBuscaMed = scanner.nextLine();
                                medicoDAO.consultaPorNome(nomeBuscaMed);
                                break;

                            case 4:
                                System.out.print("ID do médico para deletar: ");
                                int idMed = scanner.nextInt();
                                scanner.nextLine();
                                medicoDAO.deletar(idMed);
                                break;

                            case 5:
                                System.out.print("Id: ");
                                idMed = scanner.nextInt();
                                scanner.nextLine();

                                System.out.print("Nome: ");
                                String novoNome = scanner.nextLine();

                                System.out.print("Idade: ");
                                int novaIdade = scanner.nextInt();
                                scanner.nextLine();

                                System.out.print("CPF: ");
                                String novoCpf = scanner.nextLine();

                                System.out.print("Especialidade: ");
                                String novasEspecialidade = scanner.nextLine();

                                medicoDAO.atualizar(idMed, novoNome, novaIdade, novoCpf, novasEspecialidade);
                                break;

                            case 0:
                                System.out.println("Voltando ao menu principal...");
                                break;

                            default:
                                System.out.println("Opção inválida!");
                        }
                    } while (opcaoMedico != 0);
                    break;

                case 2:
                    do {
                        System.out.println("\n--- MENU PACIENTE ---");
                        System.out.println("1. Inserir Paciente");
                        System.out.println("2. Listar Pacientes");
                        System.out.println("3. Buscar Paciente por Nome");
                        System.out.println("4. Deletar Paciente por ID");
                        System.out.println("5. Atualizar Paciente");
                        System.out.println("0. Voltar");
                        System.out.print("Escolha uma opção: ");
                        opcaoPaciente = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcaoPaciente) {
                            case 1:
                                System.out.print("Nome do paciente: ");
                                String nomePac = scanner.nextLine();

                                System.out.print("Idade: ");
                                int idadePac = scanner.nextInt();
                                scanner.nextLine();

                                String cpfPac = scanner.nextLine();

                                System.out.print("Sintomas: ");
                                String sintomas = scanner.nextLine();

                                pacienteDAO.inserir(nomePac, idadePac, cpfPac, sintomas);
                                break;

                            case 2:
                                pacienteDAO.listar();
                                break;

                            case 3:
                                System.out.print("Nome a buscar: ");
                                String nomeBuscaPac = scanner.nextLine();
                                pacienteDAO.consultaPorNome(nomeBuscaPac);
                                break;

                            case 4:
                                System.out.print("ID do paciente para deletar: ");
                                int idPac = scanner.nextInt();
                                scanner.nextLine();
                                pacienteDAO.deletar(idPac);
                                break;

                            case 5:
                                System.out.print("Id: ");
                                idPac = scanner.nextInt();
                                scanner.nextLine();

                                System.out.print("Nome: ");
                                String novoNomePac = scanner.nextLine();

                                System.out.print("Idade: ");
                                int novaIdadePac = scanner.nextInt();
                                scanner.nextLine();

                                System.out.print("CPF: ");
                                String novoCpfPac = scanner.nextLine();

                                System.out.print("Sintomas: ");
                                String novosSintomas = scanner.nextLine();

                                pacienteDAO.atualizar(idPac, novoNomePac, novaIdadePac, novoCpfPac, novosSintomas);
                                break;

                            case 0:
                                System.out.println("Voltando ao menu principal...");
                                break;

                            default:
                                System.out.println("Opção inválida!");
                        }
                    } while (opcaoPaciente != 0);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcaoPrincipal != 0);

        scanner.close();
    }
}
