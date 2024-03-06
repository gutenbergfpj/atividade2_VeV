package processadorBoletoTeste;

import static org.junit.Assert.*;

import main.Boleto;
import main.Fatura;
import org.junit.Test;
import java.util.List;

/*
1- implementar as classes básicas
2- implementar os testes
3- os testes irão falhar
4- adiciona a classe para processar os boletos
5- os testes devem passar
 */

public class BoletoTest {
    private Fatura fatura;
    private List<Boleto> boletos;

    @Test
    public void testProcessarBoletosFaturaPaga() {
        ProcessadorBoletos processador = new ProcessadorBoletos();
        boletos.add(new Boleto("001", "03/11/1999", 500.00));
        boletos.add(new Boleto("002", "03/11/1999", 500.00));
        processador.processarBoletos(fatura, boletos);
        assertTrue(fatura.isPaga());
    }

    @Test
    public void testProcessarBoletosFaturaNaoPaga() {
        boletos.add(new Boleto("001", "03/11/1999", 500.00));
        processadorBoletos.processarBoletos(fatura, boletos);
        assertFalse(fatura.isPaga());
    }

    @Test
    public void testProcessarBoletosFaturaParcialmentePaga() {
        boletos.add(new Boleto("001", "03/11/1999", 500.00));
        boletos.add(new Boleto("001", "03/11/1999", 500.00));
        processadorBoletos.processarBoletos(fatura, boletos);
        assertFalse(fatura.isPaga());
    }

    @Test
    public void testProcessarBoletosSemBoletos() {
        processadorBoletos.processarBoletos(fatura, boletos);
        assertFalse(fatura.isPaga());
    }

    @Test
    public void testProcessarBoletosFaturaComValorZero() {
        fatura = new Fatura(new String("03/11/2000"), 1500.00, "Cliente 1");
        boletos.add(new Boleto("001", "03/11/1999", 500.00));
        processadorBoletos.processarBoletos(fatura, boletos);
        assertTrue(fatura.isPaga());
    }

    @Test(expected = NullPointerException.class)
    public void testProcessarBoletosComFaturaNula() {
        processadorBoletos.processarBoletos(null, boletos);
    }

    @Test(expected = NullPointerException.class)
    public void testProcessarBoletosComListaDeBoletosNula() {
        processadorBoletos.processarBoletos(fatura, null);
    }

    @Test
    public void testProcessarBoletosComBoletoNulo() {
        boletos.add(null);
        ProcessadorBoleto processador = new processarBoletos(fatura, boletos);
        assertFalse(fatura.isPaga());
    }

    @Test
    public void testProcessarBoletosComBoletoComValorZero() {
        boletos.add(new Boleto("001", "03/11/1999", 500.00));
        processadorBoletos.processarBoletos(fatura, boletos);
        assertFalse(fatura.isPaga());
    }

    @Test
    public void testeCriarBoleto(){
        boletos.add(new Boleto("001", "03/11/1999", 500.00));
        boletos.add(new Boleto("002", "03/11/1999", 500.00));
        int quantidade = boletos.size();

        assertEquals(2, quantidade);

    }
}