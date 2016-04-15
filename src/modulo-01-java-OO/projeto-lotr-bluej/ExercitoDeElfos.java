import java.util.*;

public class ExercitoDeElfos
{
    private HashMap<String, Elfo> exercito = new HashMap<>();
    private HashMap<Status, ArrayList<Elfo>> exercitoAgrupado = new HashMap<>();
    private Taticas tatica = new NoturnosUltimo();
    
    public void alistaElfo(Elfo elfo) {
        if(elfo instanceof ElfoNoturno || elfo instanceof ElfosVerdes) {
            exercito.put(elfo.getNome(), elfo);
        }
    }
    
    public HashMap getExercito() {
        return exercito;
    }
    
    public void atacar(ArrayList<Dwarf> alvos) {
        this.agruparPorStatus();
        this.tatica.atacar(buscar(Status.VIVO), alvos);
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return this.tatica.getOrdemDoUltimoAtaque();
    }
    
    public void mudarEstrategia(Taticas estrategia) {
        this.tatica = estrategia;
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
