package main;

public class Fatura {
    private String data;
    private double valorTotal;
    private String nomeCliente;
    private boolean paga;

    public Fatura(String data, double valorTotal, String nomeCliente) {
        this.data = data;
        this.valorTotal = valorTotal;
        this.nomeCliente = nomeCliente;
        this.paga = false;
    }

    public String getData() {
        return data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public boolean isPaga() {
        return paga;
    }

    public void marcarComoPaga() {
        this.paga = true;
    }
}
