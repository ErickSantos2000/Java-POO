public class FretePadrao extends Frete  {

    public FretePadrao(double distanciKm, double valorPorKm){
        super(distanciKm, valorPorKm);
    }

    public double calcularFrete(){
        return getDistanciaKm() * getValorPorKm();
    }

}
