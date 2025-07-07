package app.gui;

import app.dao.ProfessorDAO;
import app.model.Professor;

import javax.swing.*;

public class LoginTela extends JFrame {
    private JTextField emailField;
    private JPasswordField senhaField;
    private JButton loginButton;

    public LoginTela() {
        setTitle("Login do Professor");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel(new java.awt.GridLayout(3, 2));
        painel.add(new JLabel("Email:"));
        emailField = new JTextField();
        painel.add(emailField);

        painel.add(new JLabel("Senha:"));
        senhaField = new JPasswordField();
        painel.add(senhaField);

        loginButton = new JButton("Entrar");
        painel.add(new JLabel());
        painel.add(loginButton);

        add(painel);

        loginButton.addActionListener(e -> logar());
    }

    private void logar() {
        String email = emailField.getText();
        String senha = new String(senhaField.getPassword());

        ProfessorDAO professorDAO = new ProfessorDAO();
        Professor professor = professorDAO.autenticar(email, senha);

        if (professor != null) {
            JOptionPane.showMessageDialog(this, "Bem-vindo, " + professor.getNome());

            // Abrir TelaAlunos (lista alunos da matéria)
            new TelaAlunos(professor).setVisible(true);

            dispose(); // fecha o login
        } else {
            JOptionPane.showMessageDialog(this, "Email ou senha inválidos");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginTela().setVisible(true));
    }
}
