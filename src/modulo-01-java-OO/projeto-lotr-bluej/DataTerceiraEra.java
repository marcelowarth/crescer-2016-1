import java.util.GregorianCalendar; 

/**
 * Write a description of class DataTerceiraEra here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DataTerceiraEra
{
    // instance variables - replace the example below with your own
    private int dia, mes, ano;

    /**
     * Constructor for objects of class DataTerceiraEra
     */
    public DataTerceiraEra(int dia, int mes, int ano)
    {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    
    public int getDia(){
        return dia;
    }
    
    public int getMes(){
        return mes;
    }
    
    public int getAno(){
        return ano;
    }
    
    public boolean ehBissexto(){
        return (new GregorianCalendar().isLeapYear(ano));        
    }
    
}
