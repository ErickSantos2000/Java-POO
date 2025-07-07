package app.dao;

import app.model.Aluno;
import app.util.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    // Busca um aluno pelo ID
    public Aluno buscarPorId(int id) {
        String sql = "SELECT id, nome, idade, email_academico, matricula FROM aluno WHERE id = ?";
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Aluno aluno = new Aluno(
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getString("email_academico")
                );
                aluno.setId(rs.getInt("id"));
                aluno.setMatricula(rs.getString("matricula"));
                return aluno;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar aluno por id: " + e.getMessage());
        }
        return null;
    }

    // Lista todos os alunos de uma matéria específica
    public List<Aluno> listarTodosPorMateria(int idMateria) {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT id, nome, idade, email_academico, matricula FROM aluno WHERE id_materia = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idMateria);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Aluno aluno = new Aluno(
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getString("email_academico")
                );
                aluno.setId(rs.getInt("id"));
                aluno.setMatricula(rs.getString("matricula"));
                alunos.add(aluno);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar alunos por matéria: " + e.getMessage());
        }

        return alunos;
    }

    // Você pode incluir outros métodos como inserir, atualizar, deletar, se quiser

}
