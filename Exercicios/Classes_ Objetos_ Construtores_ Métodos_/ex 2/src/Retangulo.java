public class Retangulo{
    private int largura;
    private int comprimento;

    public Retangulo(int largura, int comprimento){
        this.largura = largura;
        this.comprimento = comprimento;
    }

    public int calcularArea(){
        int area = largura * comprimento;
        return area;
    }

    public int calcularPerimetro(){
        int perimetro =  (2 * largura) + (2 * comprimento);
        return perimetro;
    }

    public void imprimir(){
        System.out.println("Largura: " + largura);
        System.out.println("Comprimento: " + comprimento);
        System.out.println("Area: " + calcularArea());
        System.out.println("Perimetro: " + calcularPerimetro());
    }
}