public class Personagem
{
    protected String nome;
    protected int experiencia = 0;
    protected Inventario inventario = new Inventario();

    public Personagem(String nome)
    {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    
    public void adicionarItem(Item item) {
        inventario.adicionarItem(item);
    }
    
    public void perderItem(Item item) {
        inventario.removeItem(item);
    }
    
    public boolean contemItem(Item item) {
        return inventario.getItens().contains(item);
    }
    
    public int getExp() {
        return experiencia;
    }
    
    public Inventario getInventario() {
        return this.inventario;
    }
}
