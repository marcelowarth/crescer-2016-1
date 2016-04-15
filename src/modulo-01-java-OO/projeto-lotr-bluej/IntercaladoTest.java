import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class IntercaladoTest
{
    @After
    public void tearDown() {
        System.gc();
    }
    
    @Test
    public void testaIntercalado() {
        Elfo e1 = new ElfoNoturno("ASD");
        Elfo e2 = new ElfoNoturno("ASD2");
        Elfo e3 = new ElfosVerdes("ASD3");
        Elfo e4 = new ElfosVerdes("ASD4");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistaElfo(e1);
        exercito.alistaElfo(e2);
        exercito.alistaElfo(e3);
        exercito.alistaElfo(e4);
        
        ArrayList<Dwarf> dwarfs = new ArrayList<>();
        dwarfs.add(new Dwarf("d1"));
        dwarfs.add(new Dwarf("d2"));
        
        Intercalado in = new Intercalado();
        exercito.agruparPorStatus();
        in.atacar(exercito.buscar(Status.VIVO), dwarfs);
        
        
        boolean ordemCerta = true;
        String tipoUltimo = "";
        ArrayList<Elfo> obtido = in.getOrdemDoUltimoAtaque();
        for(Elfo e : obtido) {
            if(e instanceof ElfoNoturno && ordemCerta && tipoUltimo != e.getClass().getName()) {
                tipoUltimo = obtido.getClass().getName();
            } else if(e instanceof ElfosVerdes && ordemCerta && tipoUltimo != e.getClass().getName()) {
                tipoUltimo = obtido.getClass().getName();
            } else {
                ordemCerta = false;
                break;
            }
        }
        
        assertTrue(ordemCerta);
    }
}
