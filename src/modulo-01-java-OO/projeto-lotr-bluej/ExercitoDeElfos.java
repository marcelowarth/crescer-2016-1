import java.util.*;

public class ExercitoDeElfos
{
    private HashMap<String, Elfo> exercito = new HashMap<>();
    private HashMap<Status, Elfo> exercitoAgrupado = new HashMap<>();
    
    public void alistaElfo(Elfo elfo) {
        if(elfo instanceof ElfoNoturno || elfo instanceof ElfosVerdes) {
            exercito.put(elfo.getNome(), elfo);
        }
    }
    
    public HashMap getExercito() {
        return exercito;
    }
    
    public void agruparPorStatus() {
        for(Elfo elfo : exercito.values()) {
            exercitoAgrupado.put(elfo.getStatus(), elfo);
        }
    }
    
    public HashMap getExercitoAgrupado() {
        return exercito;
    }
}
