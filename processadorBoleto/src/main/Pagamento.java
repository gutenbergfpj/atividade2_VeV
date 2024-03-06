package main;

public class Pagamento {
    private Float valorPago;
    private String data;
    private String tipo;

    public Pagamento(Float valorPago, String data, String tipo) {
        this.valorPago = valorPago;
        this.data = data;
        this.tipo = tipo;
    }

    public double getValorPago() {
        return valorPago;
    }

    public String getData() {
        return data;
    }

    public String getTipo() {
        return tipo;
    }
}
