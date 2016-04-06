public class Elfo {
    private String nome;
    private int experiencia, flechas = 42;
    
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
}