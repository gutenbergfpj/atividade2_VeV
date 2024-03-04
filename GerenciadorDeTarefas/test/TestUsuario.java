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
	
	Date dataAtual = Date.now();
	Date dataProxima = new Date(2023, 03, 06);
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
		usuario.adicionarTarefa(tarefa1);
		assertEquals(novaTarefa, usuario.getTarefas()[0]);
		assertEquals(1, usuario.getTarefas().length);
	}
	
	@Test
	public void excluiTarefas() {
		usuario.excluirTarefa(tarefa1);
		assertEquals(0,usuario.getTarefas().length);
	}
	
	@Test
	public void adicionaTarefaRepetida() {
		usuario.adicionarTarefa(tarefa1);
		assertFalse(usuario.adicionarTarefa(tarefa1));
		assertEquals(1, usuario.getTarefas().length);
	}
	
	@Test
	public void adicionaNovaTarefaValida2() {
		usuario.adicionarTarefa(tarefa2);
		assertEquals(2, usuario.getTarefas().length);
	}
	
	@Test
	public void modificacaoInvalidaDeTituloComTituloInvalido() {
		usuario.modificarTituloTarefa(tarefa1, null);
		assertEquals(tarefa1.getTitulo(),usuario.getTarefas()[1].getTitulo());
	}
	
	@Test
	public void modificacaoInvalidaDeTituloComTarefaInvalida() {
		usuario.modificarTituloTarefa(null, "Comprar macarrão");
		assertEquals(tarefa1.getTitulo(),usuario.getTarefas()[1].getTitulo());
	}
	
	@Test
	public void modificacaoInvalidaDeDescricaoTarefaInvalida() {
		usuario.modificarDescricaoTarefa(null, "Comprar macarrão");
		assertEquals(tarefa1.getDescricao(), usuario.getTarefas()[1].getDescricao());
	}
	
	@Test
	public void modificacaoInvalidaDePrazoTarefaInvalida() {
		usuario.modificarPrazoTarefa(null, dataAtual);
		assertEquals(tarefa1.getPrazo(), usuario.getTarefas()[1].getPrazo());
	}
	
	@Test
	public void modificacaoInvalidaDePrazoDataInvalida() {
		usuario.modificarPrazoTarefa(tarefa1, null);
		assertEquals(tarefa1.getPrazo(), usuario.getTarefas()[1].getPrazo());
	}

	@Test
	public void modificacaoInvalidaDePrioridadeComPrioridadeInvalida() {
		usuario.modificarPrioridade(tarefa1, null);
		assertEquals(tarefa1.getPrioridade(), usuario.getTarefas()[1].getPrioridade());
	}
	
	@Test
	public void modificacaoInvalidaDePrioridadeComTarefaInvalida() {
		usuario.modificarPrioridade(null, Prioridade.ALTA);
		assertEquals(tarefa1.getPrioridade(), usuario.getTarefas()[1].getPrioridade());
	}
	
	@Test
	public void modificacaoValidaDeTitulo() {
		usuario.modificarTituloTarefa(tarefa1, "Comprar macarrão");
		assertNotEquals(tarefa1.getTitulo(), usuario.getTarefas()[1].getTitulo());
	}

	@Test
	public void modificacaoValidaDeDescricao() {
		usuario.modificarDescricaoTarefa(tarefa1, "");
		assertNotEquals(tarefa1.getDescricao(), usuario.getTarefas()[1].getDescricao());
		
	}

	@Test
	public void modificacaoValidaDePrazo() {
		usuario.modificarPrazoTarefa(tarefa1, dataProxima);
		assertNotEquals(tarefa1.getPrazo(), usuario.getTarefas()[1].getPrazo());
	}

	@Test
	public void modificacaoValidaDePrioridade() {
		usuario.modificarPrioridade(tarefa1, Prioridade.MEDIA);
		assertNotEquals(tarefa1.getPrioridade(), usuario.getTarefas()[1].getPrioridade());
	}

	@Test
	public void organizacaoDeTarefasFunciona() {
		
		usuario = new Usuario();
		usuario.adicionarTarefa(tarefa1);
		usuario.adicionarTarefa(tarefa2);
		usuario.adicionarTarefa(tarefa3);
		usuario.adicionarTarefa(tarefa4);
		
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
