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
        String esperado = "Adaga,Escudo,Bracelete";
        assertEquals(esperado, inv.getDescricoesItens());
    }
    
    @Test
    public void primeiroMaisPopular() {
        Inventario inv = new Inventario();
        Item item = new Item("Adaga", 100);
        Item item2 = new Item("Escudo", 10);
        Item item3 = new Item("Bracelete", 1);
        inv.adicionarItem(item);
        inv.adicionarItem(item2);
        inv.adicionarItem(item3);
        assertEquals(item, inv.maisPopular());
    }
    
    @Test
    public void ultimoMaisPopular() {
        Inventario inv = new Inventario();
        Item item = new Item("Adaga", 1);
        Item item2 = new Item("Escudo", 10);
        Item item3 = new Item("Bracelete", 100);
        inv.adicionarItem(item);
        inv.adicionarItem(item2);
        inv.adicionarItem(item3);
        assertEquals(item3, inv.maisPopular());
    }
    
    @Test
    public void ordena() {
        Inventario inv = new Inventario();
        Item item = new Item("Adaga", 1000);
        Item item2 = new Item("Escudo", 10);
        Item item3 = new Item("Bracelete", 100);
        inv.adicionarItem(item);
        inv.adicionarItem(item2);
        inv.adicionarItem(item3);
        inv.ordenarItens();
        assertEquals(item2, inv.getItens().get(0));
        assertEquals(item3, inv.getItens().get(1));
        assertEquals(item, inv.getItens().get(2));
    }
}
