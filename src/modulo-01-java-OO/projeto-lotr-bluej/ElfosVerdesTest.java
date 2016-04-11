import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfosVerdesTest
{
    @Test
    public void atiraFlechaDwarf() {
        ElfosVerdes e1 = new ElfosVerdes("e1");
        Dwarf d1 = new Dwarf("d1");
        e1.atirarFlechaDwarfs(d1);
        assertEquals(2,e1.getExp());
    }
    
    @Test
    public void adicionaItens() {
        ElfosVerdes e1 = new ElfosVerdes("e1");
        Item item = new Item("Escudo", 1);
        Item item2 = new Item("Espada de aço valiriano", 5);
        Item item3 = new Item("Arco e Flecha de Vidro", 100);
        e1.adicionarItem(item);
        e1.adicionarItem(item2);
        e1.adicionarItem(item3);
        assertEquals(2, e1.getInventario().getItens().size());
        assertEquals(item2.getDesc(), e1.getInventario().getItens().get(0).getDesc());
        assertEquals(item3.getDesc(), e1.getInventario().getItens().get(1).getDesc());
    }
}
