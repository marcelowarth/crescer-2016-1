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
}
