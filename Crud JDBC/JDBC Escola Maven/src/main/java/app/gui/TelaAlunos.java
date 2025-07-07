package app.gui;

import app.dao.AlunoDAO;
import app.model.Aluno;
import app.model.Professor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TelaAlunos extends JFrame {

    private Professor professor;
    private JTable tabela;
    private DefaultTableModel modeloTabela;
    private AlunoDAO alunoDAO;

    public TelaAlunos(Professor professor) {
        this.professor = professor;
        this.alunoDAO = new AlunoDAO();

        setTitle("Alunos da matéria: " + professor.getMateria().getNome());
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        criarComponentes();
        carregarAlunos();
    }

    private void criarComponentes() {
        String[] colunas = {"ID", "Nome", "Email", "Matrícula", "Idade"};
        modeloTabela = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };

        tabela = new JTable(modeloTabela);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        tabela.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tabela.getSelectedRow() != -1) {
                int linha = tabela.getSelectedRow();
                int alunoId = (int) modeloTabela.getValueAt(linha, 0);
                Aluno aluno = alunoDAO.buscarPorId(alunoId);
                if (aluno != null) {
                    new TelaDetalhesAluno(professor, aluno).setVisible(true);
                }
            }
        });

        JScrollPane scroll = new JScrollPane(tabela);
        add(scroll, BorderLayout.CENTER);
    }

    private void carregarAlunos() {
        modeloTabela.setRowCount(0);

        List<Aluno> alunos = alunoDAO.listarTodosPorMateria(professor.getMateria().getId());
        for (Aluno a : alunos) {
            modeloTabela.addRow(new Object[]{
                a.getId(), a.getNome(), a.getEmail_academico(), a.getMatricula(), a.getIdade()
            });
        }
    }
}
