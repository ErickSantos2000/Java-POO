public class Frota {
    private int indice;
    private Helicoptero[] vetor;

    public Frota() {
        vetor = new Helicoptero[20];
    }

    public void add(Helicoptero h) {
        if (vetor.length == indice) {
            System.out.println("Está cheio!");
        } else {
            vetor[indice++] = h;
        }
    }

    public void imprimir(){
        if(indice == 0){
            System.out.println("Lista vazia");
        }

        for(int i = 0; i < vetor.length; i++){
            if(vetor[i] != null)
                System.out.println( "(" + i + ")" + vetor[i]);
        }
    }

    public Helicoptero[] getVetor() {
        return vetor;
    }

    public boolean entra(int escolha) {
        if(vetor[escolha] == null){
            System.out.println("opção de helicoptero invalida");
            return false;
        }
        return vetor[escolha].entra();
    }

    public boolean sai(int escolha) {
        if(vetor[escolha] == null){
            System.out.println("opção de helicoptero invalida");
            return false;
        }
        else {
            return vetor[escolha].sai();
        }
    }

    public boolean ligar(int escolha) {
        if(vetor[escolha] == null){
            System.out.println("opção de helicoptero invalida");
            return false;
        }
        else {
            return vetor[escolha].ligar();
        }
    }

    public boolean desligar(int escolha) {
        if(vetor[escolha] == null){
            System.out.println("opção de helicoptero invalida");
            return false;
        }
        return vetor[escolha].desligar();
    }

    public boolean decolar(int escolha) {
        if(vetor[escolha] == null){
            System.out.println("opção de helicoptero invalida");
            return false;
        }
        return vetor[escolha].decolar();
    }

    public boolean aterrissar(int escolha) {
        if(vetor[escolha] == null){
            System.out.println("opção de helicoptero invalida");
            return false;
        }
        return vetor[escolha].aterrissar();
    }

    public void estadoHelicoptero(int escolha){
        if( vetor[escolha] != null){
            System.out.println("(" + escolha + ")" + vetor[escolha].toString());
        }
        else {
            System.out.println("Não tem helicopetero para exibir estado!");
        }
    }
}