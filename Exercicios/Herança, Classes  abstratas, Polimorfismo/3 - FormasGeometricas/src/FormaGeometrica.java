public abstract class FormaGeometrica {
    private double area;

    public FormaGeometrica(){

    }

    public abstract void calcularArea();

    public abstract void desenhar();
    
    public double getArea() {
        return area;
    }
    
    public void setArea(double area) {
        this.area = area;
    }

}