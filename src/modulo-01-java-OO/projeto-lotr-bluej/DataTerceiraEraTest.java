import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest
{
    @Test
    public void criaData25125004(){
        int diaEnv = 25;
        int mesEnv = 12;
        int anoEnv = 5004;
        DataTerceiraEra d1 = new DataTerceiraEra(diaEnv,mesEnv,anoEnv);
        boolean resultado = (diaEnv == d1.getDia() && mesEnv == d1.getMes() && anoEnv == d1.getAno());
        assertEquals(true, resultado);
    }
    
    @Test
    public void ehBissexto10102000(){
        DataTerceiraEra d1 = new DataTerceiraEra(10,10,2000);
        boolean resultado = d1.ehBissexto();
        assertEquals(true, resultado);
    }
    
    @Test
    public void ehBissexto10102001(){
        DataTerceiraEra d1 = new DataTerceiraEra(10,10,2001);
        boolean resultado = d1.ehBissexto();
        assertEquals(false, resultado);
    }
}
