package app.dao;
import app.model.Materia;
import app.model.Professor;
import app.util.Conexao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import app.model.Professor;

public class ProfessorDAO {

    public void inserir(Professor professor){

        try {
            Connection conexao = Conexao.conectar();

            // insersão de usuario
            String sqlUsuario = "INSERT INTO usuario (nome, email_academico, senha) VALUES (?, ?, ?) RETURNING id";
            PreparedStatement stmtUsuario = conexao.prepareStatement(sqlUsuario);

            int idUsuario;

            stmtUsuario.setString(1, professor.getNome());
            stmtUsuario.setString(2, professor.getEmail_academico());
            stmtUsuario.setString(3, professor.getSenha());

            ResultSet resultado = stmtUsuario.executeQuery();

            if (resultado.next()) {
                idUsuario = resultado.getInt("id");
            } else {
                throw new SQLException("Erro ao inserir usuário");
            }

            resultado.close();
            stmtUsuario.close();

            // insersão de professor
            String  sqlProfessor = "INSERT INTO professor(id_usuario, matricula, id_materia) VALUES (?, ?, ?)";
            PreparedStatement stmtProfessor = conexao.prepareStatement(sqlProfessor);

            stmtProfessor.setInt(1, idUsuario);
            stmtProfessor.setString(2, professor.getMatricula());
            stmtProfessor.setInt(3, professor.getMateria().getId());
            stmtProfessor.executeUpdate();

            System.out.println("Inserido com sucessor");
            stmtProfessor.close();

        } catch (SQLException excecao){
            // Captura e exibe qualquer erro que ocorra durante a operação com o banco
            System.out.println("Erro ao inserir: " + excecao.getMessage());
        }
    }



    public List<Professor> listarTodos() {
        List<Professor> professores = new ArrayList<>();

        String sql = """
        SELECT 
            u.nome AS nome_usuario,
            u.email_academico,
            u.senha,
            p.matricula,
            m.id AS materia_id,
            m.nome AS nome_materia
        FROM professor p
        JOIN usuario u ON u.id = p.id_usuario
        JOIN materia m ON m.id = p.id_materia
        """;

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                // Construir o objeto Materia
                Materia materia = new Materia(
                        rs.getInt("materia_id"),
                        rs.getString("nome_materia")
                );

                // Construir o objeto Professor
                Professor professor = new Professor(
                        rs.getString("nome_usuario"),
                        rs.getString("email_academico"),
                        rs.getString("senha"),
                        rs.getString("matricula"),
                        materia
                );

                professores.add(professor);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar professores: " + e.getMessage());
        }

        return professores;
    }

    public Professor autenticar(String email, String senha) {
        String sql = """
        SELECT u.id AS usuario_id, u.nome, u.email_academico, u.senha,
               p.matricula,
               m.id AS materia_id, m.nome AS materia_nome
        FROM professor p
        JOIN usuario u ON p.id_usuario = u.id
        JOIN materia m ON p.id_materia = m.id
        WHERE u.email_academico = ? AND u.senha = ?
    """;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Cria o objeto Materia
                Materia materia = new Materia(rs.getInt("materia_id"), rs.getString("materia_nome"));

                // Cria o professor com base nos dados
                Professor professor = new Professor(
                        rs.getString("nome"),
                        rs.getString("email_academico"),
                        rs.getString("senha"),
                        rs.getString("matricula"),
                        materia
                );

                professor.setId(rs.getInt("usuario_id"));
                return professor;
            }

        } catch (SQLException e) {
            System.out.println("Erro ao autenticar professor: " + e.getMessage());
        }

        return null;
    }


}
