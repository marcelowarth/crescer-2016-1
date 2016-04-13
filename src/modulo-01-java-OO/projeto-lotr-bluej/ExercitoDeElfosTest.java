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
}
