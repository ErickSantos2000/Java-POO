public class Produto {
    private String nome;
    private float valor;

    public Produto(String nome, Float valor){
        this.nome = nome;
        this.valor = valor;
    }

    public String toString() {
        return String.format("Nome: %s\nValor: %.2f\n", nome, valor);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        Produto outroProduto = (Produto) obj;

        return nome.equalsIgnoreCase(outroProduto.nome);
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}