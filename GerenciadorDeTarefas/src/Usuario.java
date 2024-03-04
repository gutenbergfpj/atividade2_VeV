import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Usuario {

	private int totalTarefas;
    private Map<Integer,Tarefa> tarefas;

    public Usuario(){

		this.totalTarefas = 0;
        this.tarefas = new HashMap<Integer,Tarefa>();
        
    }

    public Tarefa[] getTarefas(){
    
    	return null;

    }

    public Tarefa adicionarTarefa(Tarefa novaTarefa){
        
		return null;
    	
    }

    public void excluirTarefa(int idTarefa){
        this.tarefas.remove(idTarefa);
    }

    public void modificarTituloTarefa(int idTarefa, String novoTitulo){
    	
    	return;
        
    }

    public void modificarDescricaoTarefa(int idTarefa, String novaDescricao){
    	
    	return;
        
    }

    public void modificarPrazoTarefa(int idTarefa, Date novoPrazo){
    	
    	return;
    }

    public void modificarPrioridade(int idTarefa, Prioridade novaPrioridade){
    	
    	return;
        
    }
    
    private boolean validadorString(String string){

        return false;
		
    }

    private boolean validadorData(Date data){

        return false;

	}
    private Tarefa[] sortTarefas(Tarefa[] tarefas) {
    	
    	return null;

    }
    
    private Tarefa[] dataSort(Tarefa[] tarefas) {
    	
    	return null;

    }
    
    private Tarefa[] concatenadorDeArrays(Tarefa[] altas, Tarefa[] medias, Tarefa[] baixas) {
    	
    	return null;

    }
}
