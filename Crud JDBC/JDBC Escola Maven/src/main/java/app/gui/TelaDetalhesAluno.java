package app.gui;

import app.dao.NotaDAO;
import app.model.Aluno;
import app.model.Nota;
import app.model.Professor;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaDetalhesAluno extends JFrame {

    private Professor professor;
    private Aluno aluno;
    private NotaDAO notaDAO;

    private JTextField nomeField;
    private JTextField idadeField;
    private JTextField emailField;
    private JTextField matriculaField;
    private JTextField notaField;
    private JButton salvarNotaButton;

    public TelaDetalhesAluno(Professor professor, Aluno aluno) {
        this.professor = professor;
        this.aluno = aluno;
        this.notaDAO = new NotaDAO();

        setTitle("Detalhes do Aluno: " + aluno.getNome());
        setSize(350, 250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 5, 5));

        criarComponentes();
        carregarDados();
    }

    private void criarComponentes() {
        add(new JLabel("Nome:"));
        nomeField = new JTextField();
        nomeField.setEditable(false);
        add(nomeField);

        add(new JLabel("Idade:"));
        idadeField = new JTextField();
        idadeField.setEditable(false);
        add(idadeField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        emailField.setEditable(false);
        add(emailField);

        add(new JLabel("Matrícula:"));
        matriculaField = new JTextField();
        matriculaField.setEditable(false);
        add(matriculaField);

        add(new JLabel("Nota:"));
        notaField = new JTextField();
        add(notaField);

        salvarNotaButton = new JButton("Salvar Nota");
        salvarNotaButton.addActionListener(e -> salvarNota());
        add(salvarNotaButton);
    }

    private void carregarDados() {
        nomeField.setText(aluno.getNome());
        idadeField.setText(String.valueOf(aluno.getIdade()));
        emailField.setText(aluno.getEmail_academico());
        matriculaField.setText(aluno.getMatricula());

        List<Nota> notas = notaDAO.listarPorAluno(aluno.getId());
        if (!notas.isEmpty()) {
            notaField.setText(String.valueOf(notas.get(0).getValor()));
        }
    }

    private void salvarNota() {
        try {
            double valor = Double.parseDouble(notaField.getText());

            notaDAO.inserirOuAtualizar(aluno.getId(), valor);
            JOptionPane.showMessageDialog(this, "Nota salva com sucesso!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Digite um valor numérico válido para a nota.");
        }
    }
}
