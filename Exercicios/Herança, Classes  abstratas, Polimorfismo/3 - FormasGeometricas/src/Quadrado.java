public class Quadrado extends FormaGeometrica {
    private double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }

    public void calcularArea() {
        double calculo = lado * lado;
        setArea(calculo);
    }

    public void desenhar(){
        System.out.println("Quadrado:");
        for (int i = 0; i < 5; i++) {
            System.out.println("*****");
        }
    }

    public String toString() {
        return "Área do quadrado: " + getArea();
    }
}
