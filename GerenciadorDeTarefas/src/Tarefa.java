import java.util.Date;
import java.util.Objects;

public class Tarefa{

    private int idTarefa;
    private String titulo;
    private String descricao;
    private Date prazo;
    private Prioridade prioridade;

    Tarefa(int idTarefa, String titulo, String descricao, Date prazo, Prioridade prioridade){
    	
        this.idTarefa = idTarefa;
    	this.titulo = titulo;
        this.descricao = descricao;
        this.prazo = prazo;
        this.prioridade = prioridade;

    }

    public int getIdTarefa(){
        return this.idTarefa;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public void setTitulo(String novoTitulo){
        this.titulo = novoTitulo;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public void setDescricao(String novaDescricao){
    	
        novaDescricao.trim();
    	if (novaDescricao.isEmpty() || novaDescricao == null) {
    		this.descricao = "";
    	} else {
    		this.descricao = novaDescricao;
    	}
        
    }

    public Date getPrazo(){
        return this.prazo;
    }

    public void setPrazo(Date novoPrazo){
        this.prazo = novoPrazo;
    }

    public Prioridade getPrioridade(){
        return this.prioridade;
    }

    public void setPrioridade(Prioridade novaPrioridade){
        this.prioridade = novaPrioridade;
    }

    @Override
    public String toString() {
    	return this.titulo + "\n"
    			+ this.descricao + "\n"
    			+ "Prazo: " + this.prazo + "\n"
    			+ "Prioridade: " + this.prioridade;
    }
    
	@Override
	public int hashCode() {
		return Objects.hash(descricao, prazo, prioridade, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(prazo, other.prazo)
				&& prioridade == other.prioridade && Objects.equals(titulo, other.titulo);
	}

	

}