package processadorBoletoTeste;

import main.Boleto;
import main.Fatura;
import main.ProcessadorBoletos;
import org.junit.Test;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertAll;

public class Junit5BoletoTest {

    private Fatura fatura;
    List<Boleto> boletos = new ArrayList<>();
    ProcessadorBoletos processador = new ProcessadorBoletos();

    @AfterEach
    public void tearDown(){
        boletos.clear();
    }

    @Test
    @Order(1)
    @RepeatedTest(7)
    @Tag("FaturaPaga")
    @DisplayName("Testar fatura paga com o conjunto de boletos iguais aos valores da fatura")
    public void testProcessarBoletosFaturaPaga() {
        Fatura fatura = new Fatura(new String(), 1500.00F, "Cliente Teste");
        boletos.add(new Boleto("001", "03/11/1999", 500.00F));
        boletos.add(new Boleto("002", "03/11/1999", 500.00F));
        boletos.add(new Boleto("003", "03/11/1899", 500.00F));
        processador.processarBoletos(fatura, boletos);
        assertTrue(fatura.isPaga());
    }

    @Test
    @Order(2)
    @Tag("FaturaNaoPaga")
    @DisplayName("Testar se a fatura é paga com os boletos sendo inferiores ao valor da fatura")
    public void testProcessarBoletosFaturaNaoPaga() {
        Fatura fatura = new Fatura(new String(), 1500.00F, "Cliente Teste");
        boletos.add(new Boleto("001", "03/11/1999", 500.00F));
        processador.processarBoletos(fatura, boletos);
        assertFalse(fatura.isPaga());
    }

    @Test
    @Order(3)
    @Tag("FaturaNaoPaga")
    @DisplayName("Testar se a fatura é paga com um valor parcial ao valor da fatura")
    public void testProcessarBoletosFaturaParcialmentePaga() {
        Fatura fatura = new Fatura(new String(), 1500.00F, "Cliente Teste");
        boletos.add(new Boleto("001", "03/11/1999", 500.00F));
        boletos.add(new Boleto("001", "03/11/1999", 500.00F));
        processador.processarBoletos(fatura, boletos);
        assertFalse(fatura.isPaga());
    }

    @Test
    @Order(4)
    @Tag("FaturaNaoPaga")
    @DisplayName("criar uma fatura que não é paga, pois nao há criação de boletos")
    public void testProcessarBoletosSemBoletos() {
        Fatura fatura = new Fatura(new String(), 1500.00F, "Cliente Teste");
        processador.processarBoletos(fatura, boletos);
        assertFalse(fatura.isPaga());
    }

    @Test
    @Order(5)
    @Tag("FaturaPaga")
    @DisplayName("Testar se a fatura é paga iniciando sua fatura zerada")
    public void testProcessarBoletosFaturaComValorZero() {
        fatura = new Fatura(new String("03/11/2000"), 0F, "Cliente 1");
        boletos.add(new Boleto("001", "03/11/1999", 500.00F));
        processador.processarBoletos(fatura, boletos);
        assertTrue(fatura.isPaga());
    }

    @Test(expected = NullPointerException.class)
    @Order(6)
    @DisplayName("testando a criação de uma fatura vazia")
    public void testProcessarBoletosComFaturaNula() {
        fatura = new Fatura(new String(""), 0F, "");
        processador.processarBoletos(null, boletos);
    }

    @Test(expected = NullPointerException.class)
    @Order(7)
    @DisplayName("testar a criação de uma lista vazia de boletos")
    public void testProcessarBoletosComListaDeBoletosNula() {
        processador.processarBoletos(fatura, null);
    }

    @Test
    @Order(8)
    @DisplayName("Teste com lista nula de boleto")
    public void testProcessarBoletosComBoletoNulo() {
        boletos.add(null);
        fatura = new Fatura(new String(""), 0F, "");
        ProcessadorBoletos processador = new ProcessadorBoletos(fatura, boletos);
        assertFalse(fatura.isPaga());
    }

    @Test
    @Order(9)
    @Tag("FaturaNaoPaga")
    @DisplayName("teste com adição de boleto de valor zerado")
    public void testProcessarBoletosComBoletoComValorZero() {
        fatura = new Fatura(new String("04/11/1999"), 2F, "joao");
        boletos.add(new Boleto("001", "03/11/1999", 0F));
        processador.processarBoletos(fatura, boletos);
        assertFalse(fatura.isPaga());
    }

    @Test
    @Order(10)
    @DisplayName("teste simples para verificar a quantidade correta de boletos sendo criados")
    public void testeCriarBoleto(){
        boletos.add(new Boleto("001", "03/11/1999", 500.00F));
        boletos.add(new Boleto("002", "03/11/1999", 500.00F));
        int quantidade = boletos.size();
        assertEquals(2, quantidade);
    }

    @Test
    @Order(11)
    @DisplayName("variando a quantidade de boletos")
    public void testeCriarBoletoComVariacaoQuantidade(){
        boletos.add(new Boleto("001", "03/11/1999", 500.00F));
        boletos.add(new Boleto("002", "03/11/1999", 500.00F));
        int quantidade = boletos.size();
        assertAll("Quantidade",
                () -> assertEquals(2, quantidade),
                () -> assertEquals(1, quantidade),
                () -> assertEquals(0, quantidade)
        );

    }
}
