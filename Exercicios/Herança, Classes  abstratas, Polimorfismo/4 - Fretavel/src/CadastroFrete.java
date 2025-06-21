public class CadastroFrete {
    private Frete vetor [];
    private int indice;

    public CadastroFrete(){
        vetor = new Frete[10];
        indice = 0;
    }

    public void add(Frete f){
        vetor[indice++] = f;
    }

    public double calcularTotalFrete(){
        double total = 0;
        for(int i =  0; i < indice; i++){
            total = vetor[i].calcularFrete() + total;
        }
        return total;
    }
}
