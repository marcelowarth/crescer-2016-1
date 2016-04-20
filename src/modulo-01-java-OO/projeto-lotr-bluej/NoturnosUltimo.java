import java.util.*;

public class NoturnosUltimo implements Taticas
{
    ArrayList<Elfo> ordemDoAtaque = new ArrayList<>();
    private HashMap<Status, ArrayList<Elfo>> exercitoAgrupado = new HashMap<>();
    
    
    public void atacar(ArrayList<Elfo> elfos, ArrayList<Dwarf> dwarfs) {
        ArrayList<Elfo> elfoNoturno = new ArrayList<>();
        agruparPorStatus(elfos);
        
        for(Elfo elfo : buscar(Status.VIVO)) {
            if(elfo instanceof ElfosVerdes) {
                atiraEOrdem(elfo, dwarfs);
            } else {
                elfoNoturno.add(elfo);
            }
        }
        for(Elfo elfo : elfoNoturno) {
                atiraEOrdem(elfo, dwarfs);
        }
    }
    
    public void atiraEOrdem(Elfo elfo, ArrayList<Dwarf> dwarfs) {
        for(Dwarf d : dwarfs){
            elfo.atirarFlechaDwarfs(d);
        }
        ordemDoAtaque.add(elfo);
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return ordemDoAtaque;
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
