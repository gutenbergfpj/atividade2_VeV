package processadorBoletoTeste;

import static org.junit.Assert.*;

import main.Boleto;
import main.Fatura;
import main.ProcessadorBoletos;
import org.junit.Test;

import java.util.ArrayList;
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
        Fatura fatura = new Fatura(new String(), 1500.00F, "Cliente Teste");
        List<Boleto> boletos = new ArrayList<>();
        boletos.add(new Boleto("001", "03/11/1999", 500.00F));
        boletos.add(new Boleto("002", "03/11/1999", 500.00F));
        boletos.add(new Boleto("003", "03/11/1899", 500.00F));
        processador.processarBoletos(fatura, boletos);
        assertTrue(fatura.isPaga());
    }

    @Test
    public void testProcessarBoletosFaturaNaoPaga() {
        Fatura fatura = new Fatura(new String(), 1500.00F, "Cliente Teste");
        List<Boleto> boletos = new ArrayList<>();
        ProcessadorBoletos processador = new ProcessadorBoletos();
        boletos.add(new Boleto("001", "03/11/1999", 500.00F));
        processador.processarBoletos(fatura, boletos);
        assertFalse(fatura.isPaga());
    }

    @Test
    public void testProcessarBoletosFaturaParcialmentePaga() {
        Fatura fatura = new Fatura(new String(), 1500.00F, "Cliente Teste");
        List<Boleto> boletos = new ArrayList<>();
        ProcessadorBoletos processador = new ProcessadorBoletos();
        boletos.add(new Boleto("001", "03/11/1999", 500.00F));
        boletos.add(new Boleto("001", "03/11/1999", 500.00F));
        processador.processarBoletos(fatura, boletos);
        assertFalse(fatura.isPaga());
    }

    @Test
    public void testProcessarBoletosSemBoletos() {
        Fatura fatura = new Fatura(new String(), 1500.00F, "Cliente Teste");
        List<Boleto> boletos = new ArrayList<>();
        ProcessadorBoletos processador = new ProcessadorBoletos();
        processador.processarBoletos(fatura, boletos);
        assertFalse(fatura.isPaga());
    }

    @Test
    public void testProcessarBoletosFaturaComValorZero() {
        List<Boleto> boletos = new ArrayList<>();
        ProcessadorBoletos processador = new ProcessadorBoletos();
        fatura = new Fatura(new String("03/11/2000"), 0F, "Cliente 1");
        boletos.add(new Boleto("001", "03/11/1999", 500.00F));
        processador.processarBoletos(fatura, boletos);
        assertTrue(fatura.isPaga());
    }

    @Test(expected = NullPointerException.class)
    public void testProcessarBoletosComFaturaNula() {
        ProcessadorBoletos processador = new ProcessadorBoletos();
        fatura = new Fatura(new String(""), 0F, "");
        processador.processarBoletos(null, boletos);
    }

    @Test(expected = NullPointerException.class)
    public void testProcessarBoletosComListaDeBoletosNula() {
        List<Boleto> boletos = new ArrayList<>();
        ProcessadorBoletos processador = new ProcessadorBoletos();
        processador.processarBoletos(fatura, null);
    }

    @Test
    public void testProcessarBoletosComBoletoNulo() {
        List<Boleto> boletos = new ArrayList<>();
        boletos.add(null);
        fatura = new Fatura(new String(""), 0F, "");
        ProcessadorBoletos processador = new ProcessadorBoletos(fatura, boletos);
        assertFalse(fatura.isPaga());
    }

    @Test
    public void testProcessarBoletosComBoletoComValorZero() {

        ProcessadorBoletos processador = new ProcessadorBoletos();
        fatura = new Fatura(new String("04/11/1999"), 2F, "joao");
        List<Boleto> boletos = new ArrayList<>();
        boletos.add(new Boleto("001", "03/11/1999", 0F));
        processador.processarBoletos(fatura, boletos);
        assertFalse(fatura.isPaga());
    }

    @Test
    public void testeCriarBoleto(){
        List<Boleto> boletos = new ArrayList<>();
        boletos.add(new Boleto("001", "03/11/1999", 500.00F));
        boletos.add(new Boleto("002", "03/11/1999", 500.00F));
        int quantidade = boletos.size();

        assertEquals(2, quantidade);

    }
}