
public class Televisor {
    private int canal;
    private int volume;
    private boolean ligado;

    public Televisor(int canal, int volume, boolean ligado) {
        this.canal = canal;
        this.ligado = ligado;
        this.volume = volume;
    }

    // get e set
    public int getCanal() {
        return canal;
    }

    public void setCanal(int canal) {
        this.canal = canal;
    }

    // get
    public int getVolume() {
        return volume;
    }

    // get e set
    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    public boolean getLigado() {
        return ligado;
    }

    public void ligar() {
        this.ligado = true;
    }

    public void desligar() {
        this.ligado = false;
    }

    public void aumentarVolume() {
        volume++;
    }

    public void diminuirVolume() {
        volume--;
    }

    public void trocarCanal(int novoCanal) {
        setCanal(novoCanal);
    }

    public String toString() {
        return "Canal: " + canal + " | Volume: " + volume + " | Ligado: " + ligado;
    }
}
