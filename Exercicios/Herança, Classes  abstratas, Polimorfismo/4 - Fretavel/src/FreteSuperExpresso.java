public class FreteSuperExpresso extends Frete {
    private int nivelExigencia;
    private double valorDoSeguro;

    public FreteSuperExpresso(double distanciKm, double valorPorKm, int nivelExigencia, double valorDoSeguro){
        super(distanciKm, valorPorKm);
        this.nivelExigencia = nivelExigencia;
        this.valorDoSeguro = valorDoSeguro;
    }

    public double calcularFrete(){
        return (getDistanciaKm() * getValorPorKm()) + (nivelExigencia * 100) +  valorDoSeguro;
    }
}
