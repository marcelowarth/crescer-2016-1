
/**
 * Write a description of class Dwarve here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dwarf
{
    // instance variables - replace the example below with your own
    private String nome;
    private int vida = 110, experiencia;
    private Status status = Status.VIVO;
    private Inventario inventario = new Inventario();
    private DataTerceiraEra dataNascimento;

    /**
     * Constructor for objects of class Dwarve
     */
    public Dwarf(String nome)
    {
        this.nome = nome;
        this.dataNascimento = new DataTerceiraEra(1,1,1);
    }

    public Dwarf(String nome, DataTerceiraEra dataNascimento)
    {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
    
    public void recebeDano()
    {
        double numero = this.getNumeroSorte();

        if (numero < 0) {
            this.experiencia += 2;
        } else if (numero > 100) {

            int vidaAposFlechada = this.vida - 10;
            if (vidaAposFlechada == 0) {
                status = Status.MORTO;
            }

            if (vida > 0) {
                vida = vidaAposFlechada;
            }
        }
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
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
    
    public int getExp() {
        return experiencia;
    }
    
    public double getNumeroSorte() {
        boolean eSeixas = this.nome.equals("Seixas");
        boolean eMeireles = this.nome.equals("Meireles");
        double result = 101.0;
        if (dataNascimento.ehBissexto() && vida >= 80 && vida <= 90) {
            result *= -33;
        //} else if (nome == "Seixas" || nome == "Meireles") {
        } else if (eSeixas || eMeireles) {
            result = (result * 33) % 100;
        }
        return result;
    }
}
