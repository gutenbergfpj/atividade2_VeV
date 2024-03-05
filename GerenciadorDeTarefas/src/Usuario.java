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

	public Tarefa getTarefa(int idTarefa){

		return this.tarefas.get(idTarefa);

	}

    public Tarefa[] getTarefas(){
    
    	Tarefa[] arrayTarefas = (Tarefa[]) tarefas.values().toArray();
    	
    	if (this.tarefas.isEmpty() || this.tarefas.size() == 1) {
    		return arrayTarefas; 
    	} else {
    		return sortTarefas(arrayTarefas);
    	}

    }

    public Tarefa adicionarTarefa(String titulo, String descricao, Date prazo, Prioridade prioridade){

		Tarefa novaTarefa = new Tarefa(totalTarefas, titulo, descricao, prazo, prioridade);

        if (validadorString(titulo) || validadorData(prazo) || prioridade == null || this.tarefas.containsValue(novaTarefa)) {
        	throw new IllegalArgumentException();
        } else {
			totalTarefas++;
        	return this.tarefas.put(novaTarefa.getIdTarefa(),novaTarefa);
        }
    	
    }

    public void excluirTarefa(int idTarefa){

        this.tarefas.remove(idTarefa);

    }

    public void modificarTituloTarefa(int idTarefa, String novoTitulo){
    	
    	if (validadorString(novoTitulo) || idTarefa <= 0) throw new IllegalArgumentException();
    	
    	if (this.tarefas.containsKey(idTarefa)) {
			this.tarefas.get(idTarefa).setTitulo(novoTitulo);
    	} else {
    		throw new IllegalArgumentException();
    	}
        
    }

    public void modificarDescricaoTarefa(int idTarefa, String novaDescricao){
    	
    	if (idTarefa <= 0) throw new IllegalArgumentException();
    	
    	if (this.tarefas.containsKey(idTarefa)) {
    		this.tarefas.get(idTarefa).setDescricao(novaDescricao);
    	} else {
    		throw new IllegalArgumentException();
    	}
        
    }

    public void modificarPrazoTarefa(int idTarefa, Date novoPrazo){
    	
    	if (validadorData(novoPrazo) || idTarefa <= 0) throw new IllegalArgumentException();
        
    	if (this.tarefas.containsKey(idTarefa)) {
    		this.tarefas.get(idTarefa).setPrazo(novoPrazo);
    	} else {
    		throw new IllegalArgumentException();
    	}
    }

    public void modificarPrioridade(int idTarefa, Prioridade novaPrioridade){
    	
    	if (idTarefa <= 0 || novaPrioridade == null) throw new IllegalArgumentException();
    	
    	if (this.tarefas.containsKey(idTarefa)) {
    		this.tarefas.get(idTarefa).setPrioridade(novaPrioridade);
    	} else {
    		throw new IllegalArgumentException();
    	}
        
    }
    
    private boolean validadorString(String string){

        string.trim();
        return string.isEmpty() || string == null;

    }

    private boolean validadorData(Date data){

        Date dataLocal = new Date();
        return data == null || data.compareTo(dataLocal) < 0;

    }
    
    private Tarefa[] sortTarefas(Tarefa[] tarefas) {
    	
    	List<Tarefa> altas = new ArrayList<Tarefa>();
    	List<Tarefa> medias = new ArrayList<Tarefa>();
    	List<Tarefa> baixas = new ArrayList<Tarefa>();
    	
    	for (Tarefa t: tarefas) {
    		if (t.getPrioridade().equals(Prioridade.ALTA)) {
    			altas.add(t);
    		} else if (t.getPrioridade().equals(Prioridade.MEDIA)) {
    			medias.add(t);
    		} else if (t.getPrioridade().equals(Prioridade.BAIXA)) {
    			baixas.add(t);
    		}
    	}
    	
    	Tarefa[] arrayAltas = new Tarefa[altas.size()];
    	Tarefa[] arrayMedias = new Tarefa[medias.size()];
    	Tarefa[] arrayBaixas = new Tarefa[baixas.size()];
    	
    	if (altas.size() > 1) {
    		arrayAltas = dataSort(arrayAltas);
    	}
    	
    	if (medias.size()> 1) {
    		arrayMedias = dataSort(arrayMedias);
    	}
    	
    	if (baixas.size() > 1) {
    		arrayBaixas = dataSort(arrayBaixas);
    	}
    	
    	return concatenadorDeArrays(arrayAltas, arrayMedias, arrayBaixas);

    }
    
    private Tarefa[] dataSort(Tarefa[] tarefas) {
    	
    	int n = tarefas.length;
    	
        for (int i=1; i < n; ++i) {
        	
            Tarefa tarefa = tarefas[i];
            int j = i - 1;
 
            while (j >= 0 && tarefas[j].getPrazo().compareTo(tarefa.getPrazo()) > 0) {
            	tarefas[j + 1] = tarefas[j];
                j = j - 1;
            }
            
            tarefas[j + 1] = tarefa;
        }
        
        return tarefas;

    }
    
    private Tarefa[] concatenadorDeArrays(Tarefa[] altas, Tarefa[] medias, Tarefa[] baixas) {
    	
    	Tarefa[] retorno = new Tarefa[altas.length+medias.length+baixas.length];
    	
    	int iterador = 0;
    	
    	for (Tarefa t: altas) {
    		retorno[iterador] = t;
    		iterador++;
    	}
    	
    	for (Tarefa t: medias) {
    		retorno[iterador] = t;
    		iterador++;
    	}
    	
    	for (Tarefa t: baixas) {
    		retorno[iterador] = t;
    		iterador++;
    	}
    	
    	return retorno;
		
    }
}
