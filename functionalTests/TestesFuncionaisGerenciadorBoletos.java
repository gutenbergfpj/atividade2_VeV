package processadorBoletoTeste;

import static org.junit.Assert.*;

import main.Boleto;
import main.Fatura;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
public class TestesFuncionaisGerenciadorBoletos {
    private Fatura fatura;
    private List<Boleto> boletos;

    @Test
    public void testeFaturaValorMinimo() {
        Fatura fatura = new Fatura(new String(), 00F, "teste1");
        assertEquals(false, fatura.isPaga());
    }
    @Test
    public void testeFaturaValorMaximo() {

        Fatura fatura = new Fatura(new String(), 100000000000F, "teste1");
        assertEquals(false, fatura.isPaga());
    }

    @Test
    public void testeBoletoValorMinimo() {
        Fatura fatura = new Fatura(new String(), 100F, "teste1");
        List<Boleto> boletos = new ArrayList<>();
        boletos.add(new Boleto("001", "03/11/1999", 1F));
        assertEquals(false, fatura.isPaga());
    }

    @Test
    public void testeBoletoValorMaximo() {
        Fatura fatura = new Fatura(new String(), 10F, "teste1");
        List<Boleto> boletos = new ArrayList<>();
        boletos.add(new Boleto("001", "03/11/1999", 1F));
        boletos.add(new Boleto("001", "03/11/1999", 8F));
        assertEquals(false, fatura.isPaga());
    }

    @Test
    public void testeFaturaAbaixoValorBoletos() {
        Fatura fatura = new Fatura(new String(), 100F, "teste1");
        List<Boleto> boletos = new ArrayList<>();
        boletos.add(new Boleto("1", "03/11/1999", 50F));
        boletos.add(new Boleto("2", "03/11/1999", 29F));
        assertEquals(false, fatura.isPaga());
    }

    @Test
    public void testeFaturaIgualValorBoletos() {
        Fatura fatura = new Fatura(new String(), 100F, "teste1");
        List<Boleto> boletos = new ArrayList<>();
        boletos.add(new Boleto("1", "03/11/1999", 50F));
        boletos.add(new Boleto("2", "03/11/1999", 50F));
        assertEquals(true, fatura.isPaga());
    }

    @Test
    public void testeFaturaAcimaValorBoletos() {
        Fatura fatura = new Fatura(new String(), 100F, "teste1");
        List<Boleto> boletos = new ArrayList<>();
        boletos.add(new Boleto("1", "03/11/1999", 50F));
        boletos.add(new Boleto("2", "03/11/1999", 60F));
        assertEquals(true, fatura.isPaga());
    }

    @Test
    public void testeTabelaDecisão() {

        Fatura fatura = new Fatura(new String(), 100F, "teste1");
        List<Boleto> boletos = new ArrayList<>();

        assertEquals(false, fatura.isPaga());
        boletos.add(new Boleto("1", "01/01/2024", 30.00F));
        assertEquals(false, fatura.isPaga());
        boletos.add(new Boleto("2", "02/01/2024", 50.00F));
        assertEquals(false, fatura.isPaga());
        boletos.add(new Boleto("3", "02/01/2024", 50.00F));
        assertEquals(true, fatura.isPaga());

    }
}

