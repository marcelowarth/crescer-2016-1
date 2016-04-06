import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoTest
{
    @Test
    public void atiraFlecha()
    {
        Elfo e1 = new Elfo("e1");
        int numFlInic = e1.getFlechas();
        int numExpInic = e1.getExp();
        e1.atirarFlecha();
        boolean result = (numFlInic > e1.getFlechas() && numExpInic < e1.getExp());
        assertEquals(true, result);
    }
    
    @Test
    public void atirarFlechaDwarfs()
    {
        Elfo e1 = new Elfo("e1");
        Dwarf d1 = new Dwarf("d1");
        int numFlInic = e1.getFlechas();
        int numExpInic = e1.getExp();
        int vidaDwarfInic = d1.getVida();
        e1.atirarFlechaDwarfs(d1);
        boolean result = (numFlInic > e1.getFlechas() 
                            && numExpInic < e1.getExp()
                            && vidaDwarfInic > d1.getVida());
        assertEquals(true, result);
    }
}
