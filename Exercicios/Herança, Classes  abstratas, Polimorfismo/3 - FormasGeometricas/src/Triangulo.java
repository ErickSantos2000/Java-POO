public class Triangulo extends FormaGeometrica {
    private double altura;
    private double base;

    public Triangulo( double altura, double base){
        this.altura = altura;
        this.base = base;
    }

    public void calcularArea(){
        double calculo = (base * altura) / 2;
        setArea(calculo);
        System.out.println("Triângulo:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("*".repeat(i));
        }

    }

    public String toString() {
        return "Area triangulo: " + getArea();
    }

}
