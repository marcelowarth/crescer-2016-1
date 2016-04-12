import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest
{
    @Test
    public void adicionaCalca100() {
        int qtde = 100;
        String desc = "Calca";
        Item item = new Item(desc, qtde);
        assertEquals(qtde, item.getQtde());
        assertEquals(desc, item.getDesc());
    }
    
    @Test
    public void adicionaChapeuMenos100() {
        int qtde = -100;
        String desc = "Chapeu";
        Item item = new Item(desc, qtde);
        assertEquals(qtde, item.getQtde());
        assertEquals(desc, item.getDesc());
    }
    
    @Test
    public void metodoEqualsTrue() {
        Item item = new Item("Chapeu", 1);
        Item item2 = new Item("Chapeu", 1);
        assertTrue(item.equals(item2));
    }
    
    @Test
    public void metodoEqualsFalse() {
        Item item = new Item("Chapeu", 1);
        Item item2 = new Item("Chapeu", 2);
        assertFalse(item.equals(item2));
    }
}
