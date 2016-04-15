import java.util.*;

public class ArteDaGuerra implements Taticas
{
    ArrayList<Elfo> ordemDoAtaque = new ArrayList<>();
    int intencoes = 0;
    int numNoturnos = 0;
    int ataquesMaxNoturnos = 0;
    int notJaUsados = 0;
    
    public void atacar(ArrayList<Elfo> elfos, ArrayList<Dwarf> dwarfs) {
        ordemDoAtaque.clear();
        calculos(elfos, dwarfs);
        for (Elfo en : elfos) {
            if(notJaUsados >= ataquesMaxNoturnos)
                continue;
            if(en instanceof ElfoNoturno)
                notJaUsados++;
            for(Dwarf d : dwarfs){
                en.atirarFlechaDwarfs(d);
            }
            ordemDoAtaque.add(en);
        }
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return ordemDoAtaque;
    }
    
    private void calculos(ArrayList<Elfo> elfos, ArrayList<Dwarf> dwarfs) {
        intencoes = elfos.size()*dwarfs.size();
        for (Elfo en : elfos) {
            if(en instanceof ElfoNoturno)
                numNoturnos++;
        }
        double atqN = intencoes*0.3;
        ataquesMaxNoturnos = (int)atqN;
    }
}
