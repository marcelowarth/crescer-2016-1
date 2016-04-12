

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
        double VidaInic = d1.getVida();
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
    public void adicionarItemNoInventario() {
        Dwarf dwarf = new Dwarf("Ben-Hurin");
        Item itemASerAdicionado = new Item("Escudo", 1);
        dwarf.adicionarItem(itemASerAdicionado);

        assertEquals(itemASerAdicionado, dwarf.getInventario().getItens().get(0));
        assertEquals(1, dwarf.getInventario().getItens().size());
    }

    @Test
    public void adicionarDoisItensNoInventario() {
        Dwarf dwarf = new Dwarf("Ben-Hurin");
        Item primeiroItemASerAdicionado = new Item("Escudo", 1);
        Item segundoItemASerAdicionado = new Item("Adagas", 3);
        dwarf.adicionarItem(primeiroItemASerAdicionado);
        dwarf.adicionarItem(segundoItemASerAdicionado);
        assertEquals(primeiroItemASerAdicionado, dwarf.getInventario().getItens().get(0));
        assertEquals(segundoItemASerAdicionado, dwarf.getInventario().getItens().get(1));
        assertEquals(2, dwarf.getInventario().getItens().size());
    }

    @Test
    public void adicionarItemEPerderNoInventario() {
        Dwarf dwarf = new Dwarf("Ben-Hurin");
        Item item = new Item("Escudo", 1);
        dwarf.adicionarItem(item);
        dwarf.perderItem(item);
        assertEquals(0, dwarf.getInventario().getItens().size());
    }

    @Test
    public void criarDwarfSemDataNascimento() {
        Dwarf dwarf = new Dwarf("André Nunin");
        assertEquals(1, dwarf.getDataNasc().getDia());
        assertEquals(1, dwarf.getDataNasc().getMes());
        assertEquals(1, dwarf.getDataNasc().getAno());
    }
    
    @Test
    public void criarDwarfComDataNascimento() {
        Dwarf dwarf = new Dwarf("André Nunin", new DataTerceiraEra(17, 10, 1945));
        assertEquals(17, dwarf.getDataNasc().getDia());
        assertEquals(10, dwarf.getDataNasc().getMes());
        assertEquals(1945, dwarf.getDataNasc().getAno());
    }
    
    @Test
    public void criarDwarfComDataNascimentoNula() {
        Dwarf dwarf = new Dwarf("André Nunin", null);
        assertNull(dwarf.getDataNasc());
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
        
        Dwarf d1 = new Dwarf(new String("Seixas"), data);
        //Dwarf d1 = new Dwarf("Seixas", data);
        Dwarf d2 = new Dwarf("Meireles", data);
        double numeroSorte1 = d1.getNumeroSorte();
        double numeroSorte2 = d2.getNumeroSorte();
        double esperado = (101.0*33)%100;
        assertEquals(esperado, numeroSorte1, 0);
        assertEquals(esperado, numeroSorte2, 0);
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
        
        assertEquals(110, d1.getVida(), 0);
        assertEquals(0, d1.getExp());
        assertEquals(100, d2.getVida(), 0);
        assertEquals(0, d2.getExp());
        assertEquals(90, d3.getVida(), 0);
        assertEquals(2, d3.getExp());
    }
    
    @Test
    public void verificaSorteUmItem() {
        DataTerceiraEra data = new DataTerceiraEra(31,10,2000);
        Dwarf d1 = new Dwarf("Lep", data);
        Item item = new Item("Escudo", 1);
        d1.adicionarItem(item);
        d1.recebeDano();
        d1.recebeDano();
        d1.tentarSorte();
        assertEquals(1001, d1.getInventario().getItens().get(0).getQtde());
    }
    
    @Test
    public void verificaSorte3Itens() {
        DataTerceiraEra data = new DataTerceiraEra(31,10,2000);
        Dwarf d1 = new Dwarf("Lep", data);
        Item item = new Item("Escudo", 1);
        Item item2 = new Item("Elmo", 5);
        Item item3 = new Item("Bota", 100);
        d1.adicionarItem(item);
        d1.adicionarItem(item2);
        d1.adicionarItem(item3);
        d1.recebeDano();
        d1.recebeDano();
        d1.tentarSorte();
        assertEquals(1001, d1.getInventario().getItens().get(0).getQtde());
        assertEquals(1005, d1.getInventario().getItens().get(1).getQtde());
        assertEquals(1100, d1.getInventario().getItens().get(2).getQtde());
    }
    
    @Test
    public void verificaSorteNaoTem() {
        Dwarf d1 = new Dwarf("Lep");
        Item item = new Item("Escudo", 1);
        d1.adicionarItem(item);
        d1.recebeDano();
        d1.recebeDano();
        d1.tentarSorte();
        assertEquals(1, d1.getInventario().getItens().get(0).getQtde());
    }
}
