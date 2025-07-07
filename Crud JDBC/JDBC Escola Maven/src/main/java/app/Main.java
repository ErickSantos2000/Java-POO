package app;
import app.dao.NotaDAO;
import app.gui.LoginTela;
import app.model.Nota;

import java.util.List;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new LoginTela().setVisible(true));
}
}
