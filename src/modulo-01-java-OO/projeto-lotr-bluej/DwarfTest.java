

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
    
    @Test
    public void testaDataNascimento(){
        DataTerceiraEra data = new DataTerceiraEra(31,10,5000);
        Dwarf d1 = new Dwarf("d1", data);
        assertEquals(data, d1.getDataNasc());
    }
    
    @Test
    public void bissextoEntre8090() {
        DataTerceiraEra data = new DataTerceiraEra(31,10,2000);
        Dwarf d1 = new Dwarf("d1", data);
        d1.recebeDano();
        d1.recebeDano();
        double numeroSorte = d1.getNumeroSorte();
        double esperado = 101.0*-33;
        boolean aux = (esperado == numeroSorte);
        assertTrue(aux);
    }
    
    @Test
    public void naoBissextoSeixasMeireles() {
        DataTerceiraEra data = new DataTerceiraEra(31,10,2001);
        //Dwarf d1 = new Dwarf(new String("Seixas"), data);
        Dwarf d1 = new Dwarf("Seixas", data);
        Dwarf d2 = new Dwarf("Meireles", data);
        double numeroSorte1 = d1.getNumeroSorte();
        double numeroSorte2 = d2.getNumeroSorte();
        double esperado = (101.0*33)%100;
        assertTrue(esperado == numeroSorte1);
        assertTrue(esperado == numeroSorte2);
        
        //assertEquals(esperado, numeroSorte1);
        //assertEquals(esperado, numeroSorte2);
    }
    
    @Test
    public void verifica3possibilidadesRecebeDano() {
        DataTerceiraEra dataB = new DataTerceiraEra(31,10,2000);
        DataTerceiraEra dataNB = new DataTerceiraEra(31,10,2001);
        Dwarf d1 = new Dwarf("Seixas", dataNB);
        Dwarf d2 = new Dwarf("xxx", dataNB);
        Dwarf d3 = new Dwarf("d1", dataB);
        d1.recebeDano();
        d2.recebeDano();
        d3.recebeDano();
        d3.recebeDano();
        d3.recebeDano();
        
        assertEquals(110, d1.getVida());
        assertEquals(0, d1.getExp());
        assertEquals(100, d2.getVida());
        assertEquals(0, d2.getExp());
        assertEquals(90, d3.getVida());
        assertEquals(2, d3.getExp());
    }
}
