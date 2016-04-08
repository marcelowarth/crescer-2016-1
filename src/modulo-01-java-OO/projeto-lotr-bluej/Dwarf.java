
/**
 * Write a description of class Dwarve here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dwarf
{
    // instance variables - replace the example below with your own
    private String Dwarf_nome;
    private int vida = 110;
    private Status status = Status.VIVO;
    private Inventario inventario = new Inventario();
    private DataTerceiraEra dataNascimento;

    /**
     * Constructor for objects of class Dwarve
     */
    public Dwarf(String nome)
    {
        Dwarf_nome = nome;
        this.dataNascimento = new DataTerceiraEra(1,1,1);
    }

    public Dwarf(String nome, DataTerceiraEra dataNascimento)
    {
        Dwarf_nome = nome;
        this.dataNascimento = dataNascimento;
    }
    
    public void recebeDano()
    {
        if (this.status != Status.MORTO) {
            vida -= 10;
            if(vida <= 0) {
                vida = 0;
                morreu();
            }
        }
    }
    
    public void setNome(String nome){
        Dwarf_nome = nome;
    }
    
    public String getNome() {
        return Dwarf_nome;
    }
    
    public int getVida() {
        return vida;
    }
    
    public Status getStatus() {
        return status;
    }
    
    public DataTerceiraEra getDataNasc() {
        return dataNascimento;
    }
    
    private void morreu() {
        this.status = Status.MORTO;
    }
    
    public void adicionarItem(Item item) {
        inventario.adicionarItem(item);
    }
    
    public void perderItem(Item item) {
        inventario.removeItem(item);
    }
    
    public boolean contemItem(Item item) {
        return inventario.contemItem(item);
    }
    
}
