import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest
{
    @Test
    public void atirarFlechaElfoNoturnoPerde5Vida()
    {
        ElfoNoturno e1 = new ElfoNoturno("e1");
        Dwarf d1 = new Dwarf("d1");
        e1.atirarFlechaDwarfs(d1);
        assertEquals(3, e1.getExp());
        assertEquals(95, e1.getVida());
    }
    
    @Test
    public void atirarFlechaElfoNoturnoPerde50Vida()
    {
        ElfoNoturno e1 = new ElfoNoturno("e1");
        Dwarf d1 = new Dwarf("d1");
        for(int i = 0; i < 10; i++){
            e1.atirarFlechaDwarfs(d1);
        }
        assertEquals(30, e1.getExp());
        assertEquals(50, e1.getVida());
    }
    
    @Test
    public void atirarFlechaElfoNoturnoMorre()
    {
        ElfoNoturno e1 = new ElfoNoturno("e1");
        Dwarf d1 = new Dwarf("d1");
        for(int i = 0; i < 20; i++){
            e1.atirarFlechaDwarfs(d1);
        }
        assertEquals(Status.MORTO, e1.getStatus());
        assertEquals(60, e1.getExp());
        assertEquals(0, e1.getVida());
    }
}
