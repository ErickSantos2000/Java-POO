package app.dao;

import app.model.Nota;
import app.util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotaDAO {

    public void inserir(Nota nota) {
        String sql = "INSERT INTO nota(aluno_id, valor) VALUES (?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, nota.getAlunoId());
            stmt.setDouble(2, nota.getValor());
            stmt.executeUpdate();

            System.out.println("Nota inserida com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao inserir nota: " + e.getMessage());
        }
    }

    public void inserirOuAtualizar(int alunoId, double valor) {
        String sqlVerifica = "SELECT id FROM nota WHERE aluno_id = ?";
        String sqlInsere = "INSERT INTO nota (aluno_id, valor) VALUES (?, ?)";
        String sqlAtualiza = "UPDATE nota SET valor = ? WHERE aluno_id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmtVerifica = conn.prepareStatement(sqlVerifica)) {

            stmtVerifica.setInt(1, alunoId);
            ResultSet rs = stmtVerifica.executeQuery();

            if (rs.next()) {
                // Já existe nota → atualizar
                try (PreparedStatement stmtAtualiza = conn.prepareStatement(sqlAtualiza)) {
                    stmtAtualiza.setDouble(1, valor);
                    stmtAtualiza.setInt(2, alunoId);
                    stmtAtualiza.executeUpdate();
                }
            } else {
                // Não existe nota → inserir
                try (PreparedStatement stmtInsere = conn.prepareStatement(sqlInsere)) {
                    stmtInsere.setInt(1, alunoId);
                    stmtInsere.setDouble(2, valor);
                    stmtInsere.executeUpdate();
                }
            }

        } catch (SQLException e) {
            System.out.println("Erro ao inserir ou atualizar nota: " + e.getMessage());
        }
    }

    public List<Nota> listarPorAluno(int alunoId) {
        List<Nota> notas = new ArrayList<>();
        String sql = "SELECT id, valor FROM nota WHERE aluno_id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, alunoId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Nota nota = new Nota(rs.getInt("id"), alunoId, rs.getDouble("valor"));
                notas.add(nota);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar notas: " + e.getMessage());
        }

        return notas;
    }
}
