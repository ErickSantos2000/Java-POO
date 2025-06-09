
public class ControleRemoto {
    private Televisor tv;

    public ControleRemoto(Televisor tv) {
        this.tv = tv;
    }

    // get e set
    public int getCanal() {
        return tv.getCanal();
    }

    public void setCanal(int canal) {
        tv.setCanal(canal);
    }

    // get
    public int getVolume() {
        return tv.getVolume();
    }

    // get e set
    public void setLigado(boolean ligado) {
        setLigado(ligado);
    }

    public boolean getLigado() {
        return tv.getLigado();
    }

    public void ligar() {
        tv.ligar();
    }

    public void desligar() {
        tv.desligar();
    }

    public void aumentarVolume() {
        tv.aumentarVolume();
    }

    public void diminuirVolume() {
        tv.diminuirVolume();
    }

    public void trocarCanal(int novoCanal) {
        tv.trocarCanal(novoCanal);
    }

    public String toString() {
        return tv.toString();
    }
}