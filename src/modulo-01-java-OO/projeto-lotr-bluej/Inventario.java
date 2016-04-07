import java.util.*;

public class Inventario
{
    // instance variables - replace the example below with your own
    private ArrayList<Item> inventario = new ArrayList<>();

    public void adicionarItem(Item item) {
        inventario.add(item);
    }
    
    public void removeItem(Item item) {
        inventario.remove(item);
    }
}
