public class Quadrado extends FormaGeometrica {
    private double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    public void calcularArea() {
        double calculo = lado * lado;
        setArea(calculo);
        System.out.println("Retângulo:");
        for (int i = 0; i < 3; i++) {
            System.out.println("*******");
        }

    }

    public String toString() {
        return "Área do quadrado: " + getArea();
    }
}
