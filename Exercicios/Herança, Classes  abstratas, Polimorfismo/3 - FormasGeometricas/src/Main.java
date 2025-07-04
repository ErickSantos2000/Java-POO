
public class
Main {
    public static void main(String[] args) {
        Circulo c = new Circulo(10);
        Quadrado q = new Quadrado(10);
        Retangulo r = new Retangulo(10, 10);
        Triangulo t = new Triangulo(10, 10);

        System.out.println();
        c.calcularArea();
        c.desenhar();
        System.out.println(c.toString());

        System.out.println();

        q.calcularArea();
        q.desenhar();
        System.out.println(q.toString());

        System.out.println();

        r.calcularArea();
        r.desenhar();
        System.out.println(r.toString());

        System.out.println();

        t.calcularArea();
        t.desenhar();
        System.out.println(t.toString());
        System.out.println();
    }
}
