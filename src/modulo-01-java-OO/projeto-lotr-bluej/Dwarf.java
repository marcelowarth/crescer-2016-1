
/**
 * Write a description of class Dwarve here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dwarf extends Personagem
{
    // instance variables - replace the example below with your own
    private String nome;
    private DataTerceiraEra dataNascimento;

    /**
     * Constructor for objects of class Dwarve
     */
    public Dwarf(String nome)
    {
        super(nome);
        super.vida = 110;
        this.dataNascimento = new DataTerceiraEra(1,1,1);
    }

    public Dwarf(String nome, DataTerceiraEra dataNascimento)
    {
        super(nome);
        super.vida = 110;
        this.dataNascimento = dataNascimento;
    }
    
    public void recebeDano()
    {
        double numero = this.getNumeroSorte();

        if (numero < 0) {
            this.experiencia += 2;
        } else if (numero > 100) {

            double vidaAposFlechada = (super.vida - 10);
            if (vidaAposFlechada == 0) {
                status = Status.MORTO;
            }

            if (vida > 0) {
                vida = vidaAposFlechada;
            }
        }
    }
    
    public DataTerceiraEra getDataNasc() {
        return dataNascimento;
    }
    
    public double getNumeroSorte() {
        boolean eSeixas = super.nome.equals("Seixas");
        boolean eMeireles = super.nome.equals("Meireles");
        double result = 101.0;
        if (super.nome != null) {
            if (dataNascimento.ehBissexto() && vida >= 80 && vida <= 90) {
                result *= -33;
            //} else if (nome == "Seixas" || nome == "Meireles") {
            } else if (eSeixas || eMeireles) {
                result = (result * 33) % 100;
            }
        }
        return result;
    }
    
    public void tentarSorte() {
        if(getNumeroSorte() == -3333.0) {
            inventario.temSorte();
        }
    }
    
    public static Dwarf descobrirMenosVida(Dwarf dwarf1, Dwarf dwarf2) {
        return dwarf1.getVida() < dwarf2.getVida() ? dwarf1 : dwarf2;
    }
}
