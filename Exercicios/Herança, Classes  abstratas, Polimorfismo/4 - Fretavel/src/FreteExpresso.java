public class FreteExpresso extends Frete {
    private int nivelExigencia;

    public FreteExpresso(double distanciaKm, double valorPorKm, int nivelExigencia) {
        super(distanciaKm, valorPorKm);
        this.nivelExigencia = nivelExigencia;
    }

    @Override
    public double calcularFrete() {
        return (getDistanciaKm() * getValorPorKm()) + (nivelExigencia * 50);
    }
}
