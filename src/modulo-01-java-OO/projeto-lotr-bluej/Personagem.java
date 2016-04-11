public class Personagem
{
    protected String nome;
    protected int experiencia = 0;
    protected int vida = 0;
    protected Status status = Status.VIVO;
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
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public int getVida() {
        return vida;
    }
    
    public Status getStatus() {
        return status;
    }
    
    private void morreu() {
        this.status = Status.MORTO;
    }
}
