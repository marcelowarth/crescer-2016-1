public class Elfo {
    private String nome;
    private int experiencia, flechas = 42;
    private int vidaDwarve = 110;
    private boolean dwarveVivo = true;
    
    public Elfo(String nome) {
        this.nome = nome;
    }
    
    public void atirarFlecha() {
        experiencia++;
        flechas--;
    }
    
    public void atirarFlechaDwarves() {
        if(dwarveVivo == true){
            if(vidaDwarve > 0) {
                experiencia++;
                flechas--;
                vidaDwarve = vidaDwarve - 10;
            } else
                dwarveVivo = false;
        } else {
            reviveDwarve();
        }
            
            
    }
    
    public void reviveDwarve(){
        dwarveVivo = true;
        vidaDwarve = 110;
    }
}