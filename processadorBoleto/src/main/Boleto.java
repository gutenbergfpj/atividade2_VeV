package main;

public class Boleto {
    private String codigo;
    private String data;
    private double valorPago;

    public Boleto(String codigo, String data, double valorPago) {
        this.codigo = codigo;
        this.data = data;
        this.valorPago = valorPago;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getData() {
        return data;
    }

    public double getValorPago() {
        return valorPago;
    }
}
