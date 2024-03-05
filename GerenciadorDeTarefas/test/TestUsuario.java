package test;

import java.time.Date;

import com.junit.jupiter.api.*;

import gerenciadordetarefas.src.Usuario;
import gerenciadordetarefas.src.Tarefa;
import gerenciadordetarefas.src.Prioridade;

public class TestUsuario {

	// O Junit não está funcionando corretamente na minha máquina
	//Como consequência, os testes estão deixando a desejar enquanto o problema não é resolvido
	
	Usuario usuario = new Usuario();
	
	Date dataPassada = new Date(2023,01,01);
	Date dataAtual = Date.now();
	Date dataProxima = new Date(2023, 03, 21);
	Date dataDistante = new Date (2023, 04, 21);
	Date finalAno = new Date(2023,12,30);
	
	Tarefa tarefa1 = new Tarefa("Comprar cuscuz","e ovos se o preço for bom",dataAtual,Prioridade.BAIXA);
	Tarefa tarefa2 = new Tarefa("Atividade a entregar", "VeV", dataProxima, Prioridade.MEDIA);
	Tarefa tarefa3 = new Tarefa("Pagar boletos", "Plano de saude vence primeiro", dataDistante, Prioridade.ALTA);
	Tarefa tarefa4 = new Tarefa("Vacinar o gato", "", finalAno, Prioridade.ALTA);
		
	@Test
	public void criaNovoUsuarioCorretamente() {
		assertEquals(0,usuario.getTarefas().length);
	}
    
	@Test
	public void adicionaNovaTarefaValida() {
		usuario.adicionarTarefa("Comprar cuscuz","e ovos se o preço for bom",dataAtual,Prioridade.BAIXA);
		assertEquals(tarefa1, usuario.getTarefas()[0]);
		assertEquals(1, usuario.getTarefas().length);
	}
	
	@Test
	public void excluiTarefas() {
		usuario.excluirTarefa(0);
		assertEquals(0,usuario.getTarefas().length);
	}
	
	@Test
	public void adicionaTarefaRepetida() {
		usuario.adicionarTarefa("Comprar cuscuz","e ovos se o preço for bom",dataAtual,Prioridade.BAIXA);
		assertFalse(usuario.adicionarTarefa("Comprar cuscuz","e ovos se o preço for bom",dataAtual,Prioridade.BAIXA));
		assertEquals(1, usuario.getTarefas().length);
		assertEquals(tarefa1, usuario.getTarefa(1));
	}
	
	@Test
	public void adicionaNovaTarefaValida2() {
		usuario.adicionarTarefa("Atividade a entregar", "VeV", dataProxima, Prioridade.MEDIA);
		assertEquals(2, usuario.getTarefas().length);
	}
	
	@Test
	public void modificacaoInvalidaDeTituloComTituloInvalido() {
		usuario.modificarTituloTarefa(1, null);
		assertEquals(tarefa1.getTitulo(),usuario.getTarefa(1).getTitulo());
	}
	
	@Test
	public void modificacaoInvalidaDeTituloComIdInvalida() {
		usuario.modificarTituloTarefa(null, "Comprar macarrão");
		assertEquals(tarefa1.getTitulo(),usuario.getTarefa(1).getTitulo());
	}
	
	@Test
	public void modificacaoInvalidaDeDescricaoIdInvalida() {
		usuario.modificarDescricaoTarefa(null, "Comprar macarrão");
		assertEquals(tarefa1.getDescricao(), usuario.getTarefa(1).getDescricao());
	}
	
	@Test
	public void modificacaoInvalidaDePrazoTarefaInvalidoPassado() {
		usuario.modificarPrazoTarefa(1, dataPassada);
		assertEquals(tarefa1.getPrazo(), usuario.getTarefa(1).getPrazo());
	}
	
	@Test
	public void modificacaoInvalidaDePrazoDataInvalidoNull() {
		usuario.modificarPrazoTarefa(1, null);
		assertEquals(tarefa1.getPrazo(), usuario.getTarefa(1).getPrazo());
	}

	@Test
	public void modificacaoInvalidaDePrioridadeComPrioridadeInvalida() {
		usuario.modificarPrioridade(1, null);
		assertEquals(tarefa1.getPrioridade(), usuario.getTarefa(1).getPrioridade());
	}
	
	@Test
	public void modificacaoInvalidaDePrioridadeComIdInvalida() {
		usuario.modificarPrioridade(-1, Prioridade.ALTA);
		assertEquals(tarefa1.getPrioridade(), usuario.getTarefa(1).getPrioridade());
	}
	
	@Test
	public void modificacaoValidaDeTitulo() {
		usuario.modificarTituloTarefa(1, "Comprar macarrão");
		assertNotEquals(tarefa1.getTitulo(), usuario.getTarefa(1).getTitulo());
	}

	@Test
	public void modificacaoValidaDeDescricao() {
		usuario.modificarDescricaoTarefa(1, "");
		assertNotEquals(tarefa1.getDescricao(), usuario.getTarefa(1).getDescricao());
		
	}

	@Test
	public void modificacaoValidaDePrazo() {
		usuario.modificarPrazoTarefa(1, dataProxima);
		assertNotEquals(tarefa1.getPrazo(), usuario.getTarefa(1).getPrazo());
	}

	@Test
	public void modificacaoValidaDePrioridade() {
		usuario.modificarPrioridade(1, Prioridade.MEDIA);
		assertNotEquals(tarefa1.getPrioridade(), usuario.getTarefa(2).getPrioridade());
	}

	@Test
	public void organizacaoDeTarefasFunciona() {

		usuario = new Usuario();
		usuario.adicionarTarefa("Comprar cuscuz","e ovos se o preço for bom",dataAtual,Prioridade.BAIXA);
		usuario.adicionarTarefa("Atividade a entregar", "VeV", dataProxima, Prioridade.MEDIA);
		usuario.adicionarTarefa("Pagar boletos", "Plano de saude vence primeiro", dataDistante, Prioridade.ALTA);
		usuario.adicionarTarefa("Vacinar o gato", "", finalAno, Prioridade.ALTA);
		
		bool verificador = true;
		Tarefa[] tarefasTeste = {tarefa3, tarefa4, tarefa2, tarefa1};
		Tarefa[] tarefasUsuario = usuario.getTarefas();
		
		if (tarefasUsuario.length == tarefasTeste.length){
			for (int i=0;i<tarefasTeste.length;i++) {
				if (!tarefasUsuario[i].equals(tarefasTeste[i])) {
					verificador = false;
					break;
				}
			}
		} else {
			verificador = false;
		}
		
		assertTrue(verificador);
	}
	
}
