package main;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Fatura fatura = new Fatura(new String(), 1500.00, "Cliente Teste");
        List<Boleto> boletos = new ArrayList<>();
        boletos.add(new Boleto("001", "03/11/1999", 500.00));
        boletos.add(new Boleto("002", "03/11/1998", 400.00));
        boletos.add(new Boleto("003", "04/11/1999", 600.00));

        ProcessadorBoletos processador = new ProcessadorBoletos();
        processador.processarBoletos(fatura, (java.util.List<Boleto>) boletos);

        System.out.println("main.Fatura Paga: " + fatura.isPaga());
    }
}