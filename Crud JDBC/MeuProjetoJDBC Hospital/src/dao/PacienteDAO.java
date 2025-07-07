package src.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.OperacoesDAO;
import src.util.Conexao;
import src.model.Paciente;

public class PacienteDAO implements OperacoesDAO<Paciente> {

    private ArrayList<Paciente> pacientes = new ArrayList<>();
    
    public PacienteDAO(){
        pacientes = new ArrayList<>();
    }

    public void inserir(String nome, int idade, String cpf, String sintomas) {
        try {
            Connection conexao = Conexao.conectar();
            String sqlInserir = "INSERT INTO paciente (nome, idade, cpf, sintomas) VALUES (?, ?, ?, ?)";
            PreparedStatement stmtInserir = conexao.prepareStatement(sqlInserir);

            stmtInserir.setString(1, nome);
            stmtInserir.setInt(2, idade);
            stmtInserir.setString(3, cpf);
            stmtInserir.setString(4, sintomas);

            stmtInserir.executeUpdate();

            System.out.println("Paciente inserido com sucesso!");

            stmtInserir.close();
            conexao.close();

        } catch (SQLException excecao) {
            System.out.println("Erro ao inserir paciente: " + excecao.getMessage());
        }
    }

    

    public ArrayList<Paciente> listar() {
        try {Connection conexao = Conexao.conectar();

             // exibi de forma ordenada
            String sqlListar = "SELECT * FROM medico ORDER BY id ASC";
            PreparedStatement stmtListar = conexao.prepareStatement(sqlListar);
            ResultSet resultado = stmtListar.executeQuery();

            if (!resultado.isBeforeFirst()) {
                System.out.println("A tabela de pacientes está vazia!");
            } else {
                System.out.println("Paciente listado:");
                while (resultado.next()) {
                    int id = resultado.getInt("id");
                    String nome = resultado.getString("nome");
                    int idade = resultado.getInt("idade");
                    String cpf = resultado.getString("cpf");
                    String sintomas = resultado.getString("sintomas");

                    pacientes.add(new Paciente(id, nome, idade, cpf ,sintomas));

                    
                    System.out.println("ID: " + id + " Nome: " + nome + " Idade: " + idade +
                            " CPF: " + cpf + " Sintomas: " + sintomas);
                }
            }

            resultado.close();
            stmtListar.close();
            conexao.close();

        } catch (SQLException excecao) {
            System.out.println("Erro ao listar pacientes: " + excecao.getMessage());
        }

        return pacientes;
    }

    public void consultaPorNome(String nomeBusca) {
        try {
            Connection conexao = Conexao.conectar();

            String sqlConsultaNome = "SELECT * FROM paciente WHERE nome ILIKE ?";
            PreparedStatement stmtConsulta = conexao.prepareStatement(sqlConsultaNome);

            stmtConsulta.setString(1, "%" + nomeBusca + "%");
            ResultSet resultado = stmtConsulta.executeQuery();

            if (!resultado.isBeforeFirst()) {
                System.out.println("A tabela está vazia ou nenhum paciente com esse nome foi encontrado.");
            } else {
                while (resultado.next()) {
                    int id = resultado.getInt("id");
                    String nome = resultado.getString("nome");
                    int idade = resultado.getInt("idade");
                    String cpf = resultado.getString("cpf");
                    String sintomas = resultado.getString("sintomas");

                    System.out.println("Paciente encontrado:");
                    System.out.println("ID: " + id + " Nome: " + nome + " Idade: " + idade +
                            " CPF: " + cpf + " Sintomas: " + sintomas);
                }
            }

            resultado.close();
            stmtConsulta.close();
            conexao.close();

        } catch (SQLException excecao) {
            System.out.println("Erro ao consultar paciente: " + excecao.getMessage());
        }
    }

    public void atualizar(int id, String nome, int idade, String cpf, String campoExtra){

        try{
            Connection conexao = Conexao.conectar();
            String sqlAtualizar = "UPDATE paciente SET nome = ?, idade = ?, cpf = ?, sintomas = ? WHERE id = ?";
            PreparedStatement stmtAtualizar = conexao.prepareStatement(sqlAtualizar);

            stmtAtualizar.setString(1, nome);
            stmtAtualizar.setInt(2, idade);
            stmtAtualizar.setString(3, cpf);
            stmtAtualizar.setString(4, campoExtra);
            stmtAtualizar.setInt(5, id);

            int linhasAfetadas = stmtAtualizar.executeUpdate();

            if(linhasAfetadas > 0){
                System.out.println("Paciente atualizado com sucesso!");
            }
            else {
                
            }
          
            stmtAtualizar.close();

        } catch (SQLException e) {
        System.out.println("Erro ao atualizar paciente: " + e.getMessage());
        }
    }

    public int deletar(int ID) {
        try {Connection conexao = Conexao.conectar();

            String sqlConsulta = "SELECT * FROM paciente WHERE id = ?";
            PreparedStatement stmtConsulta = conexao.prepareStatement(sqlConsulta);
            stmtConsulta.setInt(1, ID);
            ResultSet resultado = stmtConsulta.executeQuery();

            if (!resultado.isBeforeFirst()) {
                System.out.println("Nenhum paciente com esse ID foi encontrado ou a tabela está vazia.");
                resultado.close();
                stmtConsulta.close();
                conexao.close();
                return 0;
            } else {
                while (resultado.next()) {
                    int id = resultado.getInt("id");
                    String nome = resultado.getString("nome");
                    int idade = resultado.getInt("idade");
                    String cpf = resultado.getString("cpf");
                    String sintomas = resultado.getString("sintomas");

                    System.out.println("Paciente deletado:");
                    System.out.println("ID: " + id + " Nome: " + nome + " Idade: " + idade +
                            " CPF: " + cpf + " Sintomas: " + sintomas);
                }
            }

            resultado.close();
            stmtConsulta.close();

            String sqlDeletar = "DELETE FROM paciente WHERE id = ?";
            PreparedStatement stmtDeletar = conexao.prepareStatement(sqlDeletar);
            stmtDeletar.setInt(1, ID);

            int linhaAfetadas = stmtDeletar.executeUpdate();

            stmtDeletar.close();
            conexao.close();

            return linhaAfetadas;

        } catch (SQLException excecao) {
            System.out.println("Erro ao deletar paciente: " + excecao.getMessage());
            return -1;
        }
    }
}
