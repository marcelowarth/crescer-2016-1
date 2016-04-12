import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.lang.Object;

public class ElfoTest
{
    @Test
    public void verificaConstrFlechas(){
        int numFlech = 100;
        Elfo e1 = new Elfo("e1",numFlech);
        assertEquals(numFlech, e1.getFlechas());
    }
    
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
        double vidaDwarfInic = d1.getVida();
        e1.atirarFlechaDwarfs(d1);
        boolean result = (numFlInic > e1.getFlechas() 
                            && numExpInic < e1.getExp()
                            && vidaDwarfInic > d1.getVida());
        assertEquals(true, result);
    }
    
    @Test
    public void VerificaString()
    {
        Elfo e1 = new Elfo("e1");
        String stringInic = e1.toString();
        e1.atirarFlecha();
        
        boolean result = stringInic.equals(e1.toString());
        assertEquals(false, result);
        
        //assertEquals(stringInic, e1.toString());
    }
    
    @Test
    public void verificaQtdeElfos3() {
        int qteAntes = Elfo.getNumElfos();
        Elfo e1 = new Elfo("e1");
        Elfo e2 = new ElfosVerdes("e2");
        Elfo e3 = new ElfoNoturno("e3");
        assertEquals(qteAntes + 3, Elfo.getNumElfos());
    }
}
