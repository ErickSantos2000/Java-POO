public class Helicoptero {
    private boolean ligado;
    private int altitude;
    private int capacidade;
    private int quantasPessoas;


    public Helicoptero(int capacidade) {
        this.capacidade = capacidade;
        ligado = false;
        quantasPessoas = 0;
        altitude = 0;
    }

    public boolean getLigado(){
        return ligado;
    }

    public int getAltitude() {
        return altitude;
    }

    public boolean entra() {
        if (altitude > 0) {
            return false;
        }
        else if (quantasPessoas == capacidade) {
            return false;
        }
        else {
            quantasPessoas++;
            return true;
        }
    }

    public boolean sai() {
        if (altitude > 0){
            return false;
        }
        else if (0 == quantasPessoas) {
            return false;
        } else {
            quantasPessoas--;
            return true;
        }
    }

    public boolean ligar() {
        if (ligado) {
            return false;
        } else {
            ligado = true;
            return true;
        }
    }

    public boolean desligar() {
        if (altitude > 0) {
            return false;
        } else if (!ligado) {
            return false;
        } else {
            ligado = false;
            return true;
        }
    }

    public boolean decolar() {
        if (ligado && altitude == 0) {
            altitude += 10;
            return true;
        } else {
            return false;
        }
    }

    public boolean aterrissar() {
        if (altitude > 0) {
            altitude = 0;
            return true;
        } else {
            return false;
        }
    }


    public String toString() {
        return String.format("\nLigado: %b\nAltitude: %d\nCapacidade: %d\nQuantidade de pessoas: %d\n",
                ligado, altitude, capacidade, quantasPessoas);
    }


}