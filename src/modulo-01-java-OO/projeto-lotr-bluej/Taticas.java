import java.util.*;

public interface Taticas
{
    public void atacar(ArrayList<Elfo> elfos, ArrayList<Dwarf> dwarfs);
    public ArrayList<Elfo> getOrdemDoUltimoAtaque();
}
