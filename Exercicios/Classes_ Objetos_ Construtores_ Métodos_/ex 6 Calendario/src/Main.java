public class Main{
    public static void main(String [] args){
        Calendario q1 = new Calendario(26, 9 , 2000);
        Calendario q2 = new Calendario(1,12,2202);

        q1.mostraData();
        q2.mostraData();

        q1.anoBissexto();
        q2.anoBissexto();

    }
}