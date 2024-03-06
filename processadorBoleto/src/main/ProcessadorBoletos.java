package main;

import java.util.List;
public class ProcessadorBoletos {
    public ProcessadorBoletos(Fatura fatura, List<Boleto> boletos) {
    }

    public ProcessadorBoletos() {
    }

    public void processarBoletos(Fatura fatura, List<Boleto> boletos) {
        double totalPago = 0;
        for (Boleto boleto : boletos) {
            totalPago += boleto.getValorPago();
            Pagamento pagamento = new Pagamento((float) boleto.getValorPago(), boleto.getData(), "BOLETO");
        }
        if (totalPago >= fatura.getValorTotal()) {
            fatura.marcarComoPaga();
        }
    }
}
