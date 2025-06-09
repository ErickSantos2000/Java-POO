import java.util.Random;


public class Guerreiro {
    private String nome;
    private int energia;
    private int codigo;

    Random random = new Random();



    public Guerreiro(String nome, int codigo){
        this.nome = nome;
        this.codigo = codigo;
        energia = 5;
    }

    public int getEnergia() {
        return energia;
    }

    public String getNome(){
        return nome;
    }

    public boolean aumentaEnergia(){
        if(energia < 5){
            energia++;
            return true;
        }
        else {
            return false;
        }
    }

    public void diminuiEnergia(){
        if(energia > 0){
            energia--;
        }
        else {
            System.out.println(nome + " esta sem energia!");
        }
    }

    public void alimentaSe(){
        if(aumentaEnergia()){
            System.out.println(nome + " aumentou energia!");
        }
        else{
            System.out.println("Energia chegou ao maximo!");
        }
    }

    public void atacar(Guerreiro oponente){

        int numeroAleatorio = random.nextInt(2);
        if(numeroAleatorio == 1){
            oponente.diminuiEnergia();
            System.out.println(nome + " acertou ataque!");
        }
        else{
            System.out.println(nome + " errou ataque!");
        }

    }

    public void lutaInterativa(Guerreiro oponente){
        Random random = new Random();
        int rodada = 0;

        while (this.getEnergia() != 0 && oponente.getEnergia() != 0){
            rodada++;
            System.out.println("---Rodada " + rodada + "------------");
            this.atacar(oponente);
            oponente.atacar(this);
            int numeroAleatorio = random.nextInt(2);

            if(numeroAleatorio == 1){
                this.alimentaSe();
            }
            else {
                oponente.alimentaSe();
            }

            System.out.println();

            System.out.println("Enegia de " + this.getNome()+ " "+ this.getEnergia());
            System.out.println("Enegia de " + oponente.getNome()+ " "+ oponente.getEnergia());
            System.out.println("------------------------");

        }

        if(this.getEnergia() == 0){
            System.out.println(oponente.getNome() + " ganhou!");
        }
        else{
            System.out.println(this.getNome() + " ganhou!");
        }
    }

    public void LutaRecursiva(Guerreiro oponente) {
        Random random = new Random();
        int rodada = 0;



        System.out.println("---Rodada " + rodada + "------------");
        this.atacar(oponente);
        oponente.atacar(this);

        int numeroAleatorio = random.nextInt(2);
        if (numeroAleatorio == 1) {
            this.alimentaSe();
        } else {
            oponente.alimentaSe();
        }

        System.out.println();
        System.out.println("Energia de " + this.getNome() + ": " + this.getEnergia());
        System.out.println("Energia de " + oponente.getNome() + ": " + oponente.getEnergia());
        System.out.println("------------------------");


        if (this.getEnergia() == 0) {
            System.out.println(oponente.getNome() + " ganhou!");
            return;
        }

        if (oponente.getEnergia() == 0) {
            System.out.println(this.getNome() + " ganhou!");
            return;
        }


        LutaRecursiva(oponente);
    }



    public String toString() {
        return String.format("Nome: %s\nEnergia: %d\nCodigo: %d", nome, energia, codigo);
    }
}