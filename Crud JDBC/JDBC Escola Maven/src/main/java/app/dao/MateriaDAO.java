package app.dao;

import app.model.Materia;
import app.util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MateriaDAO {

    public void inserir(Materia materia) {
        String sql = "INSERT INTO materia(nome) VALUES (?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, materia.getNome());
            stmt.executeUpdate();
            System.out.println("Matéria inserida com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir matéria: " + e.getMessage());
        }
    }

    public List<Materia> listarTodas() {
        List<Materia> materias = new ArrayList<>();
        String sql = "SELECT id, nome FROM materia";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Materia materia = new Materia(rs.getInt("id"), rs.getString("nome"));
                materias.add(materia);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar matérias: " + e.getMessage());
        }

        return materias;
    }

    public Materia buscarPorId(int id) {
        String sql = "SELECT id, nome FROM materia WHERE id = ?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Materia(rs.getInt("id"), rs.getString("nome"));
            }

        } catch (SQLException e) {
            System.out.println("Erro ao buscar matéria: " + e.getMessage());
        }

        return null;
    }
}
