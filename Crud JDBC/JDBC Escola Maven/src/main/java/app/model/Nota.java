package app.model;

public class Nota {
    private int id;
    private int alunoId;
    private double valor;

    public Nota(int id, int alunoId, double valor) {
        this.id = id;
        this.alunoId = alunoId;
        this.valor = valor;
    }

    public int getId() { return id; }
    public int getAlunoId() { return alunoId; }
    public double getValor() { return valor; }

    public void setId(int id) { this.id = id; }
    public void setAlunoId(int alunoId) { this.alunoId = alunoId; }
    public void setValor(double valor) { this.valor = valor; }
}
