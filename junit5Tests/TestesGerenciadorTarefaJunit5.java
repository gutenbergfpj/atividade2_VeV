import GerenciadorDetarefas.src.Prioridade;
import GerenciadorDetarefas.src.Tarefa;
import GerenciadorDetarefas.src.Usuario;

import java.time.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Assertions;

public class TestesGerenciadorTarefaJunit5 {
    
    @BeforeEach
    public void setup(){
        Usuario usuario = new Usuario();
        Date dataAtual = Date.now();
        Date futuroProximo = new date(2024,05,29);
        Date futuroDistante = new Date(40000,06,15);
        Date dataPassada = new Date(2020,04,20);
        Date dataImpossivel = new Date(2024,04,31);
    }

    @AfterEach
    public void tearDown(){
        Usuario = null;
    }

    Date dataAtual = Date.now();
    Date futuroProximo = new date(2024,05,29);
    Date futuroDistante = new Date(40000,06,15);
    Date dataPassada = new Date(2020,04,20);
    Date dataImpossivel = new Date(2024,04,31);

    @Test
    @DisplayName("Adiciona uma tarefa completamente válida")
    public void adicionarTarefaValidaNormal(){
        usuario.adicionarTarefa("Comprar ovos","", dataAtual, Prioridade.BAIXA);
        assertEquals(1, usuario.getTarefas().length);
    }

    @Test
    @DisplayName("Tenta adicionar uma tarefa replicada")
    public void adicionarTarefaValidaReplicada(){
        usuario.adicionarTarefa("Comprar ovos","", dataAtual, Prioridade.BAIXA);
        usuario.adicionarTarefa("Comprar ovos","", dataAtual, Prioridade.BAIXA);
        assertEquals(1, usuario.getTarefas().length);
    }

    @Test
    @DisplayName("Adiciona uma tarefa valida, mas com título absurdo")
    public void adicionarTarefaValidaTituloValidoAnormal(){
        usuario.adicionarTarefa("hasgdjasjafk987987u*(&)","", dataAtual, Prioridade.BAIXA);
        assertEquals("hasgdjasjafk987987u*(&)", usuario.getTarefa(0).getTitulo());
    }

    @ParameterizedTest
    @DisplayName("Tenta adicionar tarefas com título inválido")
    @ValueSource(stringsInvalidas = {"","  ",null})
    public void adicionarTarefaComNomeInvalido(String strInv){
        usuario.adicionarTarefa(strInv,"", dataAtual, Prioridade.BAIXA);
        assertEquals(0,usuario.getTarefas().length);
    }

    @Test
    @DisplayName("Adiciona uma tarefa com data de conclusão absurda, mas válida")
    public void adicionarTarefaValidaDataFuturaAnormal(){
        usuario.adicionarTarefa("Comprar ovos","", futuroDistante, Prioridade.BAIXA);
        assertEquals(1, usuario.getTarefas().length);
    }

    @ParameterizedTest
    @DisplayName("Tenta adicionar várias tarefas com datas inválidas")
    @ValueSource(datasInvalidas = {dataPassada, dataImpossivel, null})
    public void adicionarTarefaComConclusaoInvalida(Date dataInv){
        usuario.adicionarTarefa("Comprar ovos","", dataInv, Prioridade.BAIXA);
        assertEquals(0,usuario.getTarefas().length);
    }

    @Test
    @DisplayName("Tenta adicionar uma tarefa com prioridade null")
    public void adicionarTarefaInvalidaPrioridadeNull(){
        usuario.adicionarTarefa("Comprar ovos","", dataAtual, null);
        assertEquals(0, usuario.getTarefas().length);
    }

    @Disabled("Vários testes que envolvem recuperação, manipulação, ou deleção de tarefas individuais estão desabilitados até o ajuste do código responsável na classe Usuario")
    @Test
    @DisplayName("Tenta recuperar uma tarefa provendo número identificador negativo")
    public void alterarTarefaIdentificadorInvalidoNegativo(){
        assertThrows(IllegalArgumentException.class, ()->{usuario.getTarefa(-3);});
    }

    @Disabled("Vários testes que envolvem recuperação, manipulação, ou deleção de tarefas individuais estão desabilitados até o ajuste do código responsável na classe Usuario")
    @Test
    @DisplayName("Tenta recuperar uma tarefa provendo número identificador maior que o total de tarefas cadastradas")
    public void recuperarTarefaIdentificadorInvalidoMaiorQueTotalTarefas(){
        assertThrows(IllegalArgumentException.class, ()->{usuario.getTarefa(97);});
    }

    @Disabled("Vários testes que envolvem recuperação, manipulação, ou deleção de tarefas individuais estão desabilitados até o ajuste do código responsável na classe Usuario")
    @Test
    @DisplayName("Tenta modificar o título de uma tarefa válida com valor inválido de string")
    public void alterarTarefaTituloInvalido(){
        usuario.adicionarTarefa("Comprar ovos","", dataAtual, Prioridade.BAIXA);
        usuario.modificarTituloTarefa(0,null);
        assertEquals("Comprar ovos", usuario.getTarefa(0).getTitulo());
    }

    @Disabled("Vários testes que envolvem recuperação, manipulação, ou deleção de tarefas individuais estão desabilitados até o ajuste do código responsável na classe Usuario")
    @Test
    @DisplayName("Tenta modificar o prazo final de uma tarefa para uma data inválida")
    public void alterarTarefaDataInvalida(){
        usuario.adicionarTarefa("Comprar ovos","", dataAtual, Prioridade.BAIXA);
        usuario.modificarPrazoTarefa(0,dataPassada);
        assertEquals(dataAtual, usuario.getTarefa(0).getPrazo());
    }

    @Disabled("Vários testes que envolvem recuperação, manipulação, ou deleção de tarefas individuais estão desabilitados até o ajuste do código responsável na classe Usuario")
    @Test
    @DisplayName("Tenta modificar a prioridade de uma tarefa para um valor inválido")
    public void alterarTarefaPrioridadeInvalida(){
        usuario.adicionarTarefa("Comprar ovos","", dataAtual, Prioridade.BAIXA);
        usuario.modificarPrioridade(0,null);
        assertEquals(Prioridade.BAIXA, usuario.getTarefa(0).getPrioridade());
    }

    @Disabled("Vários testes que envolvem recuperação, manipulação, ou deleção de tarefas individuais estão desabilitados até o ajuste do código responsável na classe Usuario")
    @Test
    @DisplayName("Altera o título de uma tarefa para um novo título válido")
    public void alterarTarefaTituloValido(){
        usuario.adicionarTarefa("Comprar ovos","", dataAtual, Prioridade.BAIXA);
        usuario.modificarTituloTarefa(0,"Comprar pão");
        assertEquals("Comprar pão", usuario.getTarefa(0).getTitulo());
    }

    @Disabled("Vários testes que envolvem recuperação, manipulação, ou deleção de tarefas individuais estão desabilitados até o ajuste do código responsável na classe Usuario")
    @Test
    @DisplayName("Altera o prazo de uma tarefa para uma nova data válida")
    public void alterarTarefaDataValida(){
        usuario.adicionarTarefa("Comprar ovos","", dataAtual, Prioridade.BAIXA);
        usuario.modificarPrazoTarefa(0,futuroProximo);
        assertEquals(futuroProximo, usuario.getTarefa(0).getPrazo());
    }

    @Disabled("Vários testes que envolvem recuperação, manipulação, ou deleção de tarefas individuais estão desabilitados até o ajuste do código responsável na classe Usuario")
    @Test
    @DisplayName("Altera a prioridade de uma tarefa para uma nova prioridade válida")
    public void alterarTarefaPrioridadeValida(){
        usuario.adicionarTarefa("Comprar ovos","", dataAtual, Prioridade.BAIXA);
        usuario.modificarPrioridadeTarefa(0,Prioridade.MEDIA);
        assertEquals(Prioridade.MEDIA, usuario.getTarefa(0).getPrioridade());
    }

    @Disabled("Vários testes que envolvem recuperação, manipulação, ou deleção de tarefas individuais estão desabilitados até o ajuste do código responsável na classe Usuario")
    @Test
    @DisplayName("Tenta apagar uma tarefa utilizando um identificador inválido")
    public void apagarTarefaIdentificadorInvalido(){
        usuario.adicionarTarefa("Comprar ovos","", dataAtual, Prioridade.BAIXA);
        usuario.excluirTarefa(-3);
        assertEquals(1, usuario.getTarefas().length);
    }

    @Disabled("Vários testes que envolvem recuperação, manipulação, ou deleção de tarefas individuais estão desabilitados até o ajuste do código responsável na classe Usuario")
    @Test
    @DisplayName("Apaga uma tarefa com sucesso")
    public void apagarTarefaIdentificadorValido(){
        usuario.adicionarTarefa("Comprar ovos","", dataAtual, Prioridade.BAIXA);
        usuario.excluirTarefa(0);
        assertEquals(0, usuario.getTarefas().length);
    }

    @Test
    @DisplayName("Verifica se as tarefas cadastradas são mostradas em ordem correta: Prioridade alta>media>baixa e, dentro das prioridades, datas de vencimento mais próximas são indexadas primeiro")
	public void organizacaoDeTarefasFunciona() {

		usuario.adicionarTarefa("Comprar cuscuz","e ovos se o preço for bom",dataAtual,Prioridade.BAIXA);
		usuario.adicionarTarefa("Atividade a entregar", "VeV", new Date(2024,04,08), Prioridade.MEDIA);
		usuario.adicionarTarefa("Pagar boletos", "Plano de saude vence primeiro", futuroProximo, Prioridade.ALTA);
		usuario.adicionarTarefa("Vacinar o gato", "", new Date(2024,12,31), Prioridade.ALTA);
		
		Tarefa[] tarefasTeste = {tarefa3, tarefa4, tarefa2, tarefa1};
		Tarefa[] tarefasUsuario = usuario.getTarefas();
		
		Assertions.assertArrayEquals(tarefasTeste, tarefasUsuario);
	}
}
