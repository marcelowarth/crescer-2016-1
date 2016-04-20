import java.util.*;

public class Intercalado implements Taticas
{
    ArrayList<Elfo> ordemDoAtaque = null;
    private HashMap<Status, ArrayList<Elfo>> exercitoAgrupado = new HashMap<>();
    
    public void atacar(ArrayList<Elfo> elfos, ArrayList<Dwarf> dwarfs) {
        agruparPorStatus(elfos);
        organiza(buscar(Status.VIVO));
        if(ordemDoAtaque != null) {
            for (Elfo en : ordemDoAtaque) {
                for(Dwarf d : dwarfs){
                    en.atirarFlechaDwarfs(d);
                }
            }
        }
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return ordemDoAtaque;
    }
    
    private void organiza(ArrayList<Elfo> elfos) {
        ArrayList<Elfo> noturnos = new ArrayList<>();
        ArrayList<Elfo> verdes = new ArrayList<>();
        
        for(Elfo e : elfos) {
            if (e instanceof ElfoNoturno)
                noturnos.add(e);
            if (e instanceof ElfosVerdes)
                verdes.add(e);
        }
        
        if(noturnos.size() == verdes.size()) {
            for (int i = 0; i < noturnos.size(); i++) {
                ordemDoAtaque = new ArrayList<>();
                ordemDoAtaque.add(noturnos.get(i));
                ordemDoAtaque.add(verdes.get(i));
            }
        }
    }
    
    public void agruparPorStatus(ArrayList<Elfo> exercito){
       exercitoAgrupado.clear();
       for(Elfo elfo : exercito){
           if(!exercitoAgrupado.containsKey(elfo.getStatus()))
               exercitoAgrupado.put(elfo.getStatus(), new ArrayList<Elfo>());
           exercitoAgrupado.get(elfo.getStatus()).add(elfo);
       }
    }
    
    public ArrayList<Elfo> buscar(Status status) {
       return exercitoAgrupado.get(status);
    }
}
