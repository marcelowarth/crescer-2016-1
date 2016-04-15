import java.util.*;

public class ArteDaGuerra implements Taticas
{
    ArrayList<Elfo> ordemDoAtaque = new ArrayList<>();
    int numNoturnos = 0;
    int ataquesMaxNoturnos = 0;
    int notJaUsados = 0;
    
    public void atacar(ArrayList<Elfo> elfos, ArrayList<Dwarf> dwarfs) {
        ordemDoAtaque.clear();
        calculos(elfos, dwarfs);
        for (Elfo en : elfos) {
            boolean atacou = false;
            for(Dwarf d : dwarfs){
                if(en instanceof ElfoNoturno && notJaUsados < ataquesMaxNoturnos) {
                    notJaUsados++;
                } else if (en instanceof ElfoNoturno && notJaUsados >= ataquesMaxNoturnos) {
                    continue;
                }
                en.atirarFlechaDwarfs(d);
                atacou = true;
            }
            if(atacou)
                ordemDoAtaque.add(en);
        }
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return ordemDoAtaque;
    }
    
    private void calculos(ArrayList<Elfo> elfos, ArrayList<Dwarf> dwarfs) {
        ataquesMaxNoturnos =  ((int)((elfos.size() * dwarfs.size()) * 0.30));
        for (Elfo en : elfos) {
            if(en instanceof ElfoNoturno)
                numNoturnos++;
        }
    }
}
