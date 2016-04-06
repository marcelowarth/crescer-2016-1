
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

    /**
     * Constructor for objects of class Dwarve
     */
    public Dwarf(String nome)
    {
        Dwarf_nome = nome;
    }

    public void recebeDano()
    {
        vida -= 10;
    }
    
    public void setNome(String nome){
        Dwarf_nome = nome;
    }
    
    public String getNome() {
        return Dwarf_nome;
    }
}
