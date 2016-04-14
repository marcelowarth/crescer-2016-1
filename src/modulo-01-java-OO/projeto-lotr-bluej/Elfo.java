public class Elfo extends Personagem{
    protected int flechas = 42;
    private int ganhaExp = 1;
    private String toString;
    private static int contaElfos;
    
    public Elfo(String nome) {
        super(nome);
        super.vida = 100;
        contaElfos++;
    }
    
    public Elfo(String nome, int flechas) {
        this(nome);
        this.flechas = flechas;
    }
    
    protected void finalize() throws Throwable {
        contaElfos--;
        super.finalize();
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
    
    public static int getNumElfos() {
        return contaElfos;
    }
    
    public boolean equals(Object obj) {
        Elfo outro = (Elfo)obj;
        return this.getFlechas() == outro.getFlechas() && 
        this.getNome() == outro.getNome() &&
        this.getVida() == outro.getVida();
    }
}