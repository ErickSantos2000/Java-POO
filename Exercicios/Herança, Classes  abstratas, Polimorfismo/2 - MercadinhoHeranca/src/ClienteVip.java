public class ClienteVip extends Cliente{
    private String numeroCartao;

    public ClienteVip(String nome, double valorDaCompra, String numeroCartao){
        super(nome, valorDaCompra);
        this.numeroCartao = numeroCartao;
    }


    public double calcularPagamento() {
        return getValorDaCompra() * 0.90;
        
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public String toString() {
        return super.toString() + "\nNumero do Cartão: " + numeroCartao;
    }
}
