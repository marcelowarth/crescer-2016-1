import java.util.*;

public class NoturnosUltimo implements Taticas
{
    ArrayList<Elfo> ordemDoAtaque = new ArrayList<>();
    
    public void atacar(ArrayList<Elfo> elfos, ArrayList<Dwarf> dwarfs) {
        ArrayList<Elfo> elfoNoturno = new ArrayList<>();
        
        for(Elfo elfo : elfos) {
            if(elfo instanceof ElfosVerdes) {
                for(Dwarf d : dwarfs){
                    elfo.atirarFlechaDwarfs(d);
                    ordemDoAtaque.add(elfo);
                }
            } else {
                elfoNoturno.add(elfo);
            }
        }
        for(Elfo elfo : elfoNoturno) {
            for(Dwarf d : dwarfs){
                elfo.atirarFlechaDwarfs(d);
                ordemDoAtaque.add(elfo);
            }
        }
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return ordemDoAtaque;
    }
}
