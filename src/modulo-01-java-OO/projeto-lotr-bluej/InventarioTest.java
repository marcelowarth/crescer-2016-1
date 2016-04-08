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
        assertTrue(inv.contemItem(item));
    }
    
    @Test
    public void removeItem(){
        Inventario inv = new Inventario();
        Item item = new Item("Calca", 100);
        inv.adicionarItem(item);
        inv.removeItem(item);
        assertFalse(inv.contemItem(item));
    }
}
