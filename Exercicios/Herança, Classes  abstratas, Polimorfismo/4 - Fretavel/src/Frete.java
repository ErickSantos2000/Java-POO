public abstract class Frete implements Fretavel {
    private double distanciaKm;
    private double valorPorKm;

    public Frete(double distanciaKm, double valorPorKm) {
        this.distanciaKm = distanciaKm;
        this.valorPorKm = valorPorKm;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }

    public double getValorPorKm() {
        return valorPorKm;
    }

    public void setDistanciaKm(double distanciaKm) {
        this.distanciaKm = distanciaKm;
    }

    public void setValorPorKm(double valorPorKm) {
        this.valorPorKm = valorPorKm;
    }
}
