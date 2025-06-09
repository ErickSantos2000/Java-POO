
public class Main {
    public static void main(String[] args) {
        Televisor tv = new Televisor(0, 0, false);
        ControleRemoto controle = new ControleRemoto(tv);
        Menu menu = new Menu(tv, controle);

        menu.menuPrincipal();

    }
}