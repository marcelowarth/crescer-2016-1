

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class DwarfTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DwarfTest
{
    @Test
    public void recebeDano() {
        Dwarf d1 = new Dwarf("d1");
        int VidaInic = d1.getVida();
        d1.recebeDano();
        assertEquals(true, VidaInic > d1.getVida());
    }
}
