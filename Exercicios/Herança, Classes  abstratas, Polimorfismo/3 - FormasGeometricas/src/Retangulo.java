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
        System.out.println("Quadrado:");
        for (int i = 0; i < 5; i++) {
            System.out.println("*****");
        }

    }

    public String toString() {
        return "Area retangulo: " + getArea();
    }
}


    
