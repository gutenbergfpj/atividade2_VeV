package main;

public class Boleto {
    private String codigo;
    private String data;
    private Float valorPago;

    public Boleto(String codigo, String data, Float valorPago) {
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
