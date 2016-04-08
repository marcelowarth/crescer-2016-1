

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DwarfTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DwarfTest
{
    @Test
    public void recebeDano() {
        Dwarf d1 = new Dwarf("d1");
        int VidaInic = d1.getVida();
        d1.recebeDano();
        assertEquals(true, VidaInic > d1.getVida());
    }
    
    @Test
    public void nasceVivo() {
        Dwarf d1 = new Dwarf("d1");
        assertEquals(Status.VIVO, d1.getStatus());
    }
    
    @Test
    public void mataDwarf() {
        Dwarf d1 = new Dwarf("d1");
        int i = 0;
        while (i<11) {
            d1.recebeDano();
            i++;
        }
        assertEquals(Status.MORTO, d1.getStatus());
    }
    
    @Test
    public void vidaMenorZero() {
        Dwarf d1 = new Dwarf("d1");
        int i = 0;
        while (i<12) {
            d1.recebeDano();
            i++;
        }
        boolean aux = d1.getVida() < 0;
        assertFalse(aux);
    }
    
    @Test
    public void adicionaItem(){
        Dwarf d1 = new Dwarf("d1");
        Item item = new Item("Calca", 100);
        d1.adicionarItem(item);        
        assertTrue(d1.contemItem(item));
    }
    
    @Test
    public void removeItem(){
        Dwarf d1 = new Dwarf("d1");
        Item item = new Item("Calca", 100);
        d1.adicionarItem(item);
        d1.perderItem(item);
        assertFalse(d1.contemItem(item));
    }
    
}
