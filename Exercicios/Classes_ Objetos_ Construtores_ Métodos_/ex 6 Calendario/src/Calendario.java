public class Calendario{
    private int dia;
    private int mes;
    private int ano;

    public Calendario(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public String nomeMes(int m) {
        switch (m) {
            case 1:
                return "Janeiro";
            case 2:
                return "Fevereiro";
            case 3:
                return "Março";
            case 4:
                return "Abril";
            case 5:
                return "Maio";
            case 6:
                return "Junho";
            case 7:
                return "Julho";
            case 8:
                return "Agosto";
            case 9:
                return "Setembro";
            case 10:
                return "Outubro";
            case 11:
                return "Novembro";
            case 12:
                return "Dezembro";
            default:
                return null;
        }

    }

    public void mostraData(){
        System.out.println(dia + " de " + nomeMes(mes) + " de " + ano);
    }

    public void anoBissexto(){
        if (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0)) {
            System.out.println("É bissexto!");
        } else {
            System.out.println("Não é bissexto");
        }
    }

}