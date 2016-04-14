import java.util.*;

public class ExercitoDeElfos
{
    private HashMap<String, Elfo> exercito = new HashMap<>();
    private HashMap<Status, ArrayList<Elfo>> exercitoAgrupado = new HashMap<>();
    
    public void alistaElfo(Elfo elfo) {
        if(elfo instanceof ElfoNoturno || elfo instanceof ElfosVerdes) {
            exercito.put(elfo.getNome(), elfo);
        }
    }
    
    public HashMap getExercito() {
        return exercito;
    }
    
    public void agruparPorStatus(){
       exercitoAgrupado.clear();
       for(Elfo elfo : exercito.values()){
           if(!exercitoAgrupado.containsKey(elfo.getStatus()))
               exercitoAgrupado.put(elfo.getStatus(), new ArrayList<Elfo>());
           exercitoAgrupado.get(elfo.getStatus()).add(elfo);
       }
    }
    
    public ArrayList<Elfo> buscar(Status status) {
       return exercitoAgrupado.get(status);
    }    
}
