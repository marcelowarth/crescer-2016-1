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
    
    public void ordenarItens() {
        Item itemTroca;
        int count = 0;
        while (count < inventario.size()) {
            for (int i = count + 1; i < inventario.size(); i++) {
                if (inventario.get(count).getQtde()>inventario.get(i).getQtde()) {
                    itemTroca = inventario.get(i);
                    inventario.set(i, inventario.get(count));
                    inventario.set(count, itemTroca);
                }
            }
            count++;
        }
    }
    
    public void temSorteIrish(){
        for(int i = 0; i<inventario.size(); i++) {
            int atual = inventario.get(i).getQtde();
            int countRegressivo = atual;
            int countTotal = 0;
            while (countRegressivo > 0) {
                countTotal += countRegressivo;
                countRegressivo--;
            }
            inventario.get(i).setQtde((countTotal*1000)+atual);
        }
    }
}
