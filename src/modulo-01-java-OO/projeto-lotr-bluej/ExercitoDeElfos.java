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
    
    public ArrayList<Elfo> buscar(Status status) {
        ArrayList<Elfo> array = new ArrayList<>();
        
        for (HashMap.Entry<Status, Elfo> entry : exercitoAgrupado.entrySet()) {
            if (entry.getKey() == status) {
                array.add(entry.getValue());
            }
        }
        
        return array;
    }
}
