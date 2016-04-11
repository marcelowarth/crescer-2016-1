public class Elfo extends Personagem{
    private int flechas = 42;
    private String toString;
    
    public Elfo(String nome) {
        super(nome);
        super.vida = 100;
    }
    
    public Elfo(String nome, int flechas) {
        super(nome);
        super.vida = 100;
        this.flechas = flechas;
    }
    
    public void atirarFlecha() {
        experiencia++;
        flechas--;
    }
    
    public void atirarFlechaDwarfs(Dwarf dwarf) {
        dwarf.recebeDano();
        experiencia++;
        flechas--;
    }
    
    public int getFlechas() {
        return flechas;
    }
    
    public String toString() {
        toString = nome + " possui " + flechas + "flechas e " + super.experiencia + " níveis de experiência.";
        return toString;
    }
}