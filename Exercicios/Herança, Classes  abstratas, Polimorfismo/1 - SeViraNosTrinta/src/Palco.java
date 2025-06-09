public class Palco {
    private Participante[] participantes;
    private int indice;

    public Palco(){
        participantes = new Participante[10];
    }

    public void add(Participante p){
        if(indice < participantes.length){
            participantes[indice++] = p;
        }
    }
    
    public void apresentarShow(){
    for(int i = 0; i < indice; i++){
        participantes[i].seViraNosTrinta();
        }
    
    }
        
}
