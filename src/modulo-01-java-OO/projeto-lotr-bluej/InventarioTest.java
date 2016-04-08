import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

public class InventarioTest
{
    @Test
    public void adicionaItem(){
        Inventario inv = new Inventario();
        Item item = new Item("Calca", 100);
        inv.adicionarItem(item);        
        assertTrue(inv.getItens().contains(item));
    }
    
    @Test
    public void removeItem(){
        Inventario inv = new Inventario();
        Item item = new Item("Calca", 100);
        inv.adicionarItem(item);
        inv.removeItem(item);
        assertFalse(inv.getItens().contains(item));
    }
    
    @Test
    public void descItensArray() {
        Inventario inv = new Inventario();
        Item item = new Item("Adaga", 1);
        Item item2 = new Item("Escudo", 1);
        Item item3 = new Item("Bracelete", 1);
        inv.adicionarItem(item);
        inv.adicionarItem(item2);
        inv.adicionarItem(item3);
        String esperado = "Adaga, Escudo, Bracelete";
        assertEquals(esperado, inv.getDescricoesItens());
    }
}
