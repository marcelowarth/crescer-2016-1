public class Elfo extends Personagem{
    protected int flechas = 42;
    private int ganhaExp = 1;
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
        experiencia += ganhaExp;
        flechas--;
    }
    
    public void atirarFlechaDwarfs(Dwarf dwarf) {
        dwarf.recebeDano();
        experiencia += ganhaExp;
        flechas--;
    }
    
    public int getFlechas() {
        return flechas;
    }
    
    public int getGanhaExp() {
        return ganhaExp;
    }
    
    public String toString() {
        toString = nome + " possui " + flechas + "flechas e " + super.experiencia + " níveis de experiência.";
        return toString;
    }
}