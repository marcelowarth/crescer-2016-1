import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class HobbitContadorTest
{
    @Test
    public void calculaDiferenca1Item() {
        HobbitContador hobbit = new HobbitContador();
        ArrayList<ArrayList<Integer>> array = new ArrayList<>();
        array.add(new ArrayList<>(Arrays.asList(15,18)));
        assertEquals(180, hobbit.calcularDiferenca(array));
    }
    
    @Test
    public void calculaDiferenca3Item() {
        HobbitContador hobbit = new HobbitContador();
        ArrayList<ArrayList<Integer>> array = new ArrayList<>();
        array.add(new ArrayList<>(Arrays.asList(15,18)));
        array.add(new ArrayList<>(Arrays.asList(5,4)));
        array.add(new ArrayList<>(Arrays.asList(60,12)));
        assertEquals(840, hobbit.calcularDiferenca(array));
    }
}
