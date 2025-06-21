public class Retangulo extends FormaGeometrica {
    private double comprimento;
    private double altura;

    public Retangulo(double comprimento, double altura){
        this.altura = altura;
        this.comprimento = comprimento;
    }

    public void calcularArea(){
        double calculo = comprimento * altura;
        setArea(calculo);
    }

    public void desenhar() {
        System.out.println("Retângulo:");
        for (int i = 0; i < 3; i++) {
            System.out.println("*******");
        }
    }

    public String toString() {
        return "Area retangulo: " + getArea();
    }
}


    
