public class Mercadinho {
    private Cliente vetor [];
    private int indice;

    public Mercadinho(){
        vetor = new Cliente[10];
        indice = 0;
    }

    public void add(Cliente c){
        vetor[indice++] = c;
    }

    public double valorTotal(){
        int total = 0;
        for(int i = 0; i < indice; i++){
            total += vetor[i].calcularPagamento();
        }

        return total;
    }

    public void imprimirClientes(){
       
        for(int i = 0; i < indice; i++){
            if(vetor[i] != null){
                System.out.println("\n" + vetor[i].toString() + "\n");
            }
            
        }

    
    }


}
