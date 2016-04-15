import java.util.*;

public class Intercalado implements Taticas
{
    ArrayList<Elfo> ordemDoAtaque = new ArrayList<>();
    
    public void atacar(ArrayList<Elfo> elfos, ArrayList<Dwarf> dwarfs) {
        organiza(elfos);
        if(!ordemDoAtaque.isEmpty()) {
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
                ordemDoAtaque.add(noturnos.get(i));
                ordemDoAtaque.add(verdes.get(i));
            }
        }
    }
}
