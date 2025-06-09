public class Main {
    public static void main(String[] args) {
        Palco p = new Palco();
        p.add(new Magico("Juão"));
        p.add(new Dancarino("Marcelo"));
        p.add(new Comendiante("Ricardo"));

        p.apresentarShow();
    }
}
