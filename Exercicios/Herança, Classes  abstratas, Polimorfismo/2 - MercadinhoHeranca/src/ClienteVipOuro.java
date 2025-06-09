public class ClienteVipOuro extends ClienteVip {
    private String endereco;

    public ClienteVipOuro(String nome, double valorDaCompra, String numeroCartao, String endereco){
        super(nome, valorDaCompra, numeroCartao);
        this.endereco = endereco;
    }

    public double calcularPagamento() {
        return getValorDaCompra() * 0.85;
        
    }

    @Override
    public String toString() {
        return super.toString() + "\nEndereco: " + endereco;
    }
}
