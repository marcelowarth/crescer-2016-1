
/**
 * Write a description of class IrishDwarf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IrishDwarf extends Dwarf
{
    public IrishDwarf(String nome) {
        super(nome);
    }
    
    public IrishDwarf(String nome, DataTerceiraEra dataNasc) {
        super(nome, dataNasc);
    }
    
    public void tentarSorte() {
        if(getNumeroSorte() == -3333.0) {
            inventario.temSorteIrish();
        }
    }
}
