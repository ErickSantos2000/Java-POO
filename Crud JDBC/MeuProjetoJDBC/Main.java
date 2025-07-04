

import java.util.Scanner;
import src.dao.MedicoDAO;
import src.dao.PacienteDAO;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MedicoDAO medicoDAO = new MedicoDAO();
        PacienteDAO pacienteDAO = new PacienteDAO();

        int opcao;

        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Inserir Médico");
            System.out.println("2. Listar Médicos");
            System.out.println("3. Buscar Médico por Nome");
            System.out.println("4. Deletar Médico por ID");
            System.out.println();
            System.out.println("5. Inserir Paciente");
            System.out.println("6. Listar Pacientes");
            System.out.println("7. Buscar Paciente por Nome");
            System.out.println("8. Deletar Paciente por ID");

            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
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
                    medicoDAO.inserirPessoa(nomeMed, idadeMed, cpfMed, esp);
                    break;

                case 2:
                    medicoDAO.listar();
                    break;

                case 3:
                    System.out.print("Nome a buscar: ");
                    String nomeBuscaMed = scanner.nextLine();
                    medicoDAO.consultaNome(nomeBuscaMed);
                    break;

                case 4:
                    System.out.print("ID do médico para deletar: ");
                    int idMed = scanner.nextInt();
                    medicoDAO.deletarIdPessoa(idMed);
                    break;

                case 5:
                    System.out.print("Nome do paciente: ");
                    String nomePac = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idadePac = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpfPac = scanner.nextLine();
                    System.out.print("Sintomas: ");
                    String sintomas = scanner.nextLine();
                    pacienteDAO.inserirPessoa(nomePac, idadePac, cpfPac, sintomas);
                    break;

                case 6:
                    pacienteDAO.listar();
                    break;

                case 7:
                    System.out.print("Nome a buscar: ");
                    String nomeBuscaPac = scanner.nextLine();
                    pacienteDAO.consultaNome(nomeBuscaPac);
                    break;

                case 8:
                    System.out.print("ID do paciente para deletar: ");
                    int idPac = scanner.nextInt();
                    pacienteDAO.deletarIdPessoa(idPac);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
