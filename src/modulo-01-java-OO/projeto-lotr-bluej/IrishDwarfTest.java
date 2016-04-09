import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IrishDwarfTest
{
    @Test
    public void temSorteIrish() {
        DataTerceiraEra data = new DataTerceiraEra (1,1,2000);
        IrishDwarf id1 = new IrishDwarf("gimli", data);
        Item item = new Item("Escudo", 1);
        Item item2 = new Item("Elmo", 5);
        Item item3 = new Item("Bota", 3);
        id1.adicionarItem(item);
        id1.adicionarItem(item2);
        id1.adicionarItem(item3);
        id1.recebeDano();
        id1.recebeDano();
        id1.tentarSorte();
        assertEquals(1001, id1.getInventario().getItens().get(0).getQtde());
        assertEquals(15005, id1.getInventario().getItens().get(1).getQtde());
        assertEquals(6003, id1.getInventario().getItens().get(2).getQtde());
    } 
}
