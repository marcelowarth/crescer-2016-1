import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CestodeLembasTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CestodeLembasTest
{
    @Test
    public void criarCestoComMenosUmLembas() {
        CestodeLembas cesto = new CestodeLembas(-1);
        assertEquals(false, cesto.podeDividirEmPares());
    }
    
    @Test
    public void criarCestoCom2Lembas() {
        CestodeLembas cesto = new CestodeLembas(2);
        boolean esperado = false;
        boolean resultado = cesto.podeDividirEmPares();
        assertEquals(esperado, resultado);
    }
    
    @Test
    public void criarCestoCom4Lembas() {
        CestodeLembas cesto = new CestodeLembas(4);
        boolean esperado = true;
        boolean resultado = cesto.podeDividirEmPares();
        assertEquals(esperado, resultado);
    }
    
    @Test
    public void criarCestoCom98Lembas() {
        CestodeLembas cesto = new CestodeLembas(98);
        assertEquals(true, cesto.podeDividirEmPares());
    }
    
    @Test
    public void criarCestoCom101Lembas() {
        CestodeLembas cesto = new CestodeLembas(101);
        assertEquals(false, cesto.podeDividirEmPares());
    }
}
