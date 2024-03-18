import GerenciadorDetarefas.src.Prioridade;
import GerenciadorDetarefas.src.Tarefa;
import GerenciadorDetarefas.src.Usuario;

import java.time.Date;

import com.junit.jupiter.api.Test;
import com.junit.jupiter.api.BeforeEach;
import com.junit.jupiter.api.AfterEach;


public class TestesFuncionaisGerenciadorTarefas {
    
    @BeforeEach
    public void setup(){
        Usuario usuario = new Usuario();
    }

    @AfterEach
    public void tearDown(){
        Usuario = null;
    }

    Date dataAtual = Date.now();
    Date futuroProximo = new date(2024,05,29);
    Date futuroDistante = new Date(40000,06,15);
    Date dataPassada = new Date(2020,02,20);
    Date dataImpossivel = new Date(2024,04,31);

    @Test
    public void adicionarTarefaValidaNormal(){
        usuario.adicionarTarefa("Comprar ovos","", dataAtual, Prioridade.BAIXA);
        assertEquals(1, usuario.getTarefas().length);
    }

    @Test void adicionarTarefaValidaTituloValidoAnormal(){
        usuario.adicionarTarefa("hasgdjasjafk987987u*(&)","", dataAtual, Prioridade.BAIXA);
        assertEquals("hasgdjasjafk987987u*(&)", usuario.getTarefa(0).getTitulo());
    }

    @Test
    public void adicionarTarefaInvalidaTituloInvalidoVazio(){
        usuario.adicionarTarefa("","", dataAtual, Prioridade.BAIXA);
        assertEquals(0, usuario.getTarefas().length);
    }

    @Test
    public void adicionarTarefaInvalidaTituloInvalidoEmBranco(){
        usuario.adicionarTarefa("       ","", dataAtual, Prioridade.BAIXA);
        assertEquals(0, usuario.getTarefas().length);
    }

    @Test
    public void adicionarTarefaInvalidaTituloInvalidoNull(){
        usuario.adicionarTarefa(null,"", dataAtual, Prioridade.BAIXA);
        assertEquals(0, usuario.getTarefas().length);
    }
    
    @Test
    public void adicionarTarefaValidaDataFuturaNormal(){
        usuario.adicionarTarefa("Comprar ovos","", futuroProximo, Prioridade.BAIXA);
        assertEquals(1, usuario.getTarefas().length);
    }

    @Test
    public void adicionarTarefaValidaDataFuturaAnormal(){
        usuario.adicionarTarefa("Comprar ovos","", futuroDistante, Prioridade.BAIXA);
        assertEquals(1, usuario.getTarefas().length);
    }

    @Test
    public void adicionarTarefaInvalidaDataPassada(){
        usuario.adicionarTarefa("Comprar ovos","", dataPassada, Prioridade.BAIXA);
        assertEquals(0, usuario.getTarefas().length);
    }

    @Test
    public void adicionarTarefaInvalidaDataImpossivel(){
        usuario.adicionarTarefa("Comprar ovos","", dataImpossivel, Prioridade.BAIXA);
        assertEquals(0, usuario.getTarefas().length);
    }

    @Test
    public void adicionarTarefaInvalidaPrioridadeNull(){
        usuario.adicionarTarefa("Comprar ovos","", dataAtual, null);
        assertEquals(0, usuario.getTarefas().length);
    }

    @Test
    public void alterarTarefaIdentificadorInvalidoNegativo(){
        usuario.adicionarTarefa("Comprar ovos","", dataAtual, Prioridade.BAIXA);
        usuario.modificarTituloTarefa(-3, "Comprar pão");
        assertEquals("Comprar ovos", usuario.getTarefa(0).getTitulo());
    }

    @Test
    public void alterarTarefaIdentificadorInvalidoMaiorQueTotalTarefas(){
        usuario.adicionarTarefa("Comprar ovos","", dataAtual, Prioridade.BAIXA);
        usuario.modificarTituloTarefa(93, "Comprar pão");
        assertEquals("Comprar ovos", usuario.getTarefa(0).getTitulo());
    }

    @Test
    public void alterarTarefaTituloInvalido(){
        usuario.adicionarTarefa("Comprar ovos","", dataAtual, Prioridade.BAIXA);
        usuario.modificarTituloTarefa(0,null);
        assertEquals("Comprar ovos", usuario.getTarefa(0).getTitulo());
    }

    @Test
    public void alterarTarefaDataInvalida(){
        usuario.adicionarTarefa("Comprar ovos","", dataAtual, Prioridade.BAIXA);
        usuario.modificarPrazoTarefa(0,dataPassada);
        assertEquals(dataAtual, usuario.getTarefa(0).getPrazo());
    }

    @Test
    public void alterarTarefaPrioridadeInvalida(){
        usuario.adicionarTarefa("Comprar ovos","", dataAtual, Prioridade.BAIXA);
        usuario.modificarPrioridade(0,null);
        assertEquals(Prioridade.BAIXA, usuario.getTarefa(0).getPrioridade());
    }

    @Test
    public void alterarTarefaTituloValido(){
        usuario.adicionarTarefa("Comprar ovos","", dataAtual, Prioridade.BAIXA);
        usuario.modificarTituloTarefa(0,"Comprar pão");
        assertEquals("Comprar pão", usuario.getTarefa(0).getTitulo());
    }

    @Test
    public void alterarTarefaDataValida(){
        usuario.adicionarTarefa("Comprar ovos","", dataAtual, Prioridade.BAIXA);
        usuario.modificarPrazoTarefa(0,futuroProximo);
        assertEquals(futuroProximo, usuario.getTarefa(0).getPrazo());
    }

    @Test
    public void alterarTarefaPrioridadeValida(){
        usuario.adicionarTarefa("Comprar ovos","", dataAtual, Prioridade.BAIXA);
        usuario.modificarPrioridadeTarefa(0,Prioridade.MEDIA);
        assertEquals(Prioridade.MEDIA, usuario.getTarefa(0).getPrioridade());
    }

    @Test
    public void apagarTarefaIdentificadorInvalido(){
        usuario.adicionarTarefa("Comprar ovos","", dataAtual, Prioridade.BAIXA);
        usuario.excluirTarefa(-3);
        assertEquals(1, usuario.getTarefas().length);
    }

    @Test
    public void apagarTarefaIdentificadorValido(){
        usuario.adicionarTarefa("Comprar ovos","", dataAtual, Prioridade.BAIXA);
        usuario.excluirTarefa(0);
        assertEquals(0, usuario.getTarefas().length);
    }

}
