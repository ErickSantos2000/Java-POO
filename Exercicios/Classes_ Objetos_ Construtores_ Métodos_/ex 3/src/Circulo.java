public class Circulo{
    private float raio;

    public Circulo(float raio){
        this.raio = raio;
    }

    float pi = 3.141516f;

    public float calcularArea(){
        float area = (pi * raio * raio);
        return area;
    }

    public float calcularPerimetro(){
        float perimetro =  (2 * pi * raio);
        return perimetro;
    }
    public void imprimir(){
        System.out.println("Raio: " + raio);
        System.out.println("Area: " + calcularArea());
        System.out.println("Perimetro: " + calcularPerimetro());
    }
}