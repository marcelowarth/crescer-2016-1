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
    
    public ArrayList<Item> getItens() {
        return this.inventario;
    }
    
    public String getDescricoesItens() {
        String stringDesc = "";
        for(int i = 0; i<inventario.size(); i++) {
            stringDesc += inventario.get(i).getDesc();
            if(i<inventario.size()-1) {
                stringDesc += ",";
            }
        }
        return stringDesc;
    }
    
    public void temSorte(){
        for(int i = 0; i<inventario.size(); i++) {
            int atual = inventario.get(i).getQtde();
            inventario.get(i).setQtde(atual+1000);
        }
    }
    
    public Item maisPopular() {
        Item itemMais = inventario.get(0);
        for(int i = 1; i < inventario.size(); i++) {
            if (itemMais.getQtde()<inventario.get(i).getQtde()) {
                itemMais = inventario.get(i);
            }
        }
        return itemMais;
    }
}
