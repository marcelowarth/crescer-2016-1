import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercitoDeElfosTest
{
    @After
    public void tearDown() {
        System.gc();
    }
    
    @Test
    public void adicionaNoExercito() {
        Elfo e1 = new Elfo("Legolas");
        Elfo e2 = new ElfoNoturno("elfo1");
        Elfo e3 = new ElfosVerdes("elfo2");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistaElfo(e1);
        exercito.alistaElfo(e2);
        exercito.alistaElfo(e3);
        
        assertEquals(false, exercito.getExercito().containsKey("Legolas"));
        assertEquals(true, exercito.getExercito().containsKey("elfo1"));
        assertEquals(true, exercito.getExercito().containsKey("elfo2"));
    }
    
    @Test
    public void retornaAgrupado() {
        Elfo e1 = new ElfosVerdes("Legolas");
        Elfo e2 = new ElfoNoturno("elfo1");
        Elfo e3 = new ElfosVerdes("elfo2");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Dwarf d1 = new Dwarf("d1");
        for(int i = 0; i < 90; i++){
            e2.atirarFlechaDwarfs(d1);
        }
        exercito.alistaElfo(e1);
        exercito.alistaElfo(e2);
        exercito.alistaElfo(e3);
        exercito.agruparPorStatus();
        
        assertEquals(1, exercito.buscar(Status.MORTO).size());
        assertEquals(2, exercito.buscar(Status.VIVO).size());
    }
}
