// Exercicio 7.2 da lista 6: ele nao pode morrer pois a vida nunca chegará a 0.

public class ElfoNoturno extends Elfo
{
    private int ganhaExpEN = (super.getGanhaExp()*3);
    
    public ElfoNoturno(String nome)
    {
        super(nome);
    }
    
    public ElfoNoturno(String nome, int flechas) {
        super(nome, flechas);
    }
    
    public void atirarFlechaDwarfs(Dwarf dwarf) {
        if(super.getStatus() != Status.MORTO) {
            dwarf.recebeDano();
            experiencia += ganhaExpEN;
            super.flechas--;
            super.vida -= (super.vida*0.05);
            if (super.getVida() < 1)
                this.morreu();
        }
    }
    
    protected void morreu() {
        this.status = Status.MORTO;
    }
}
