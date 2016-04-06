public class Elfo {
    private String nome;
    private int experiencia, flechas = 42;
    private String toString;
    
    public Elfo(String nome) {
        this.nome = nome;
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
    
    public int getExp() {
        return experiencia;
    }
    
    public int getFlechas() {
        return flechas;
    }
    
    public String toString() {
        toString = nome + " possui " + flechas + " e " + experiencia + " níveis de experiência.";
        return toString;
    }
}