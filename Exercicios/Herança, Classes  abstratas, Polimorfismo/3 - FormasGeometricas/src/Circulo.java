public class Circulo extends FormaGeometrica {
    private double raio;
    private double pi;

    public Circulo(double raio){
        pi = 3.14;
        this.raio = raio;
    }

        public void calcularArea(){
            double calculo = raio * raio * pi;
            setArea(calculo);
        }

        public void desenhar(){
            System.out.println("Círculo:");
            System.out.println("  ***  ");
            System.out.println(" *   * ");
            System.out.println(" *   * ");
            System.out.println("  ***  ");

        }

    public String toString() {
        return "Area circulo: " + getArea();
    }
}
