public class Mercado {
    private Produto [] vetor;
    private Produto produto;
    private int indice;

    public int getIndice() {
        return indice;
    }

    public Produto[] getVetor() {
        return vetor;
    }

    public Mercado(){
        vetor = new Produto[20];
    }

    public void add(Produto p){
        if(indice == vetor.length){
            System.out.println("Ta cheio!");
        }
        else{
            vetor[indice++] = p;
        }
    }

    public boolean pesquisar(String nomeProcurado){

        for(int i = 0; i < vetor.length; i++){
            if(vetor[i] != null && vetor[i].getNome().equals(nomeProcurado)){
                return true;
            }
        }
        return false;
    }

    public boolean remover(String produtoRemovido){
        Produto [] novoVetor = new Produto[20];
        int j = 0;

        if(indice == 0){
            return false;
        }
        else{
            for(int i = 0; i < vetor.length; i++){
                if (vetor[i] != null && !vetor[i].getNome().equals(produtoRemovido)){
                    novoVetor[j++] = vetor[i];
                }
            }

            for(int i = 0; i < j; i++){
                vetor[i] = novoVetor[i];
            }

            for(int i = j; i < vetor.length; i++){
                vetor[i] = null;
            }

            indice = j;
            return true;
        }
    }

    public void imprimir(){
        int cont = 0;
        for(int i = 0; i < vetor.length; i++){
            if(vetor[i] != null){
                cont++;
                System.out.println("Produto " + cont + "\n" +vetor[i]);
            }

        }
    }
}