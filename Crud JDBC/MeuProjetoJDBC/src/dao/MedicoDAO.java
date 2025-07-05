package src.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.OperacoesDAO;
import src.util.Conexao;
import src.model.Medico;

public class MedicoDAO implements OperacoesDAO<Medico>  {

    private ArrayList<Medico> medicos = new ArrayList<>();
    
    public MedicoDAO() {
        medicos = new ArrayList<>();
    }

    public void inserir(String nome, int idade, String cpf, String especialidade) {
        
        try {Connection conexao = Conexao.conectar();

            
            String sqlInserir = "INSERT INTO medico (nome, idade, cpf, especialidade) VALUES (?, ?, ?, ?)";
            PreparedStatement stmtInserir = conexao.prepareStatement(sqlInserir);

            stmtInserir.setString(1, nome);
            stmtInserir.setInt(2, idade);
            stmtInserir.setString(3, cpf);
            stmtInserir.setString(4, especialidade);

            stmtInserir.executeUpdate();

            System.out.println("Médico inserido com sucesso!");

            stmtInserir.close();
            conexao.close();

        } catch (SQLException excecao) {
            System.out.println("Erro ao inserir médico: " + excecao.getMessage());
        }
    }

    
    public ArrayList<Medico> listar() {
        try {Connection conexao = Conexao.conectar();

            // exibi de forma ordenada
            String sqlListar = "SELECT * FROM medico ORDER BY id ASC";
            PreparedStatement stmtListar = conexao.prepareStatement(sqlListar);
            ResultSet resultado = stmtListar.executeQuery();

            if (!resultado.isBeforeFirst()) {
                System.out.println("A tabela de médicos está vazia!");
            } else {
                
                System.out.println("Médico listado:");
                while (resultado.next()) {
                    int id = resultado.getInt("id");
                    String nome = resultado.getString("nome");
                    int idade = resultado.getInt("idade");
                    String cpf = resultado.getString("cpf");
                    String especialidade = resultado.getString("especialidade");

                    medicos.add(new Medico(id, nome, idade, cpf, especialidade));

                    System.out.println("ID: " + id + " Nome: " + nome + " Idade: " + idade +
                            " CPF: " + cpf + " Especialidade: " + especialidade);
                }
            }

            resultado.close();
            stmtListar.close();
            conexao.close();

        } catch (SQLException excecao) {
            System.out.println("Erro ao listar médicos: " + excecao.getMessage());
        }

        return medicos;
    }

    public void consultaPorNome(String nomeBusca) {
        try {Connection conexao = Conexao.conectar();

        

            String sqlConsultaNome = "SELECT * FROM medico WHERE nome ILIKE ?";
            PreparedStatement stmtConsulta = conexao.prepareStatement(sqlConsultaNome);

            stmtConsulta.setString(1, "%" + nomeBusca + "%");
            ResultSet resultado = stmtConsulta.executeQuery();

            if (!resultado.isBeforeFirst()) {
                System.out.println("A tabela está vazia ou nenhum médico com esse nome foi encontrado.");
            } else {
                while (resultado.next()) {
                    int id = resultado.getInt("id");
                    String nome = resultado.getString("nome");
                    int idade = resultado.getInt("idade");
                    String cpf = resultado.getString("cpf");
                    String especialidade = resultado.getString("especialidade");

                    System.out.println("Médico encontrado:");
                    System.out.println("ID: " + id + " Nome: " + nome + " Idade: " + idade +
                            " CPF: " + cpf + " Especialidade: " + especialidade);
                }
            }

            resultado.close();
            stmtConsulta.close();
            conexao.close();

        } catch (SQLException excecao) {
            System.out.println("Erro ao consultar médico: " + excecao.getMessage());
        }
    }

    public void atualizar(int id, String nome, int idade, String cpf, String campoExtra){

        try{
            Connection conexao = Conexao.conectar();
            String sqlAtualizar = "UPDATE medico SET nome = ?, idade = ?, cpf = ?, especialidade = ? WHERE id = ?";
            PreparedStatement stmtAtualizar = conexao.prepareStatement(sqlAtualizar);

            stmtAtualizar.setString(1, nome);
            stmtAtualizar.setInt(2, idade);
            stmtAtualizar.setString(3, cpf);
            stmtAtualizar.setString(4, campoExtra);
            stmtAtualizar.setInt(5, id);

            int linhasAfetadas = stmtAtualizar.executeUpdate();

            if(linhasAfetadas > 0){
                System.out.println("Médico atualizado com sucesso!");
            }
            else {
                
            }
          
            stmtAtualizar.close();

        } catch (SQLException e) {
        System.out.println("Erro ao atualizar médico: " + e.getMessage());
        }
    }
    

    public int deletar(int ID) {
        try {Connection conexao = Conexao.conectar();

            String sqlConsulta = "SELECT * FROM medico WHERE id = ?";
            PreparedStatement stmtConsulta = conexao.prepareStatement(sqlConsulta);
            stmtConsulta.setInt(1, ID);
            ResultSet resultado = stmtConsulta.executeQuery();

            if (!resultado.isBeforeFirst()) {
                System.out.println("Nenhum médico com esse ID foi encontrado ou a tabela está vazia.");
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
                    String especialidade = resultado.getString("especialidade");

                    System.out.println("Médico deletado:");
                    System.out.println("ID: " + id + " Nome: " + nome + " Idade: " + idade +
                            " CPF: " + cpf + " Especialidade: " + especialidade);
                }
            }

            resultado.close();
            stmtConsulta.close();

            String sqlDeletar = "DELETE FROM medico WHERE id = ?";
            PreparedStatement stmtDeletar = conexao.prepareStatement(sqlDeletar);
            stmtDeletar.setInt(1, ID);

            int linhasAfetadas = stmtDeletar.executeUpdate();

            stmtDeletar.close();
            conexao.close();

            return linhasAfetadas;

        } catch (SQLException excecao) {
            System.out.println("Erro ao deletar médico: " + excecao.getMessage());
            return -1;
        }
    }

}
