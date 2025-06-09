public class Quadrado{
    private int lado;

    public Quadrado(int lado){
        this.lado = lado;
    }

    public void setLado(int lado){
        this.lado = lado;
    }

    public int calcularArea(){
        int area = lado * lado;
        return area;
    }

    public int calcularPerimetro(){
        int perimetro = 4 * lado;
        return perimetro;
    }

    public void imprimir(){
        System.out.println("Lado: " + lado);
        System.out.println("Area: " + calcularArea());
        System.out.println("Perimetro: " + calcularPerimetro());
    }
}