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
    
    @Test
    public void calcularDiferencaComZeroEUm() {
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(13, 91)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(0, 0)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(1, 1)));

        HobbitContador contador = new HobbitContador();
        assertEquals(1092, contador.calcularDiferenca(arrayDePares));
    }
    
    @Test
    public void calcularDiferencaArrayVazio() {
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        HobbitContador contador = new HobbitContador();
        assertEquals(0, contador.calcularDiferenca(arrayDePares));
    }
    
    @Test
    public void calcularDiferencaArrayComZeros() {
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(0, 0)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(0, 0)));
        arrayDePares.add(new ArrayList<>(Arrays.asList(0, 0)));
        HobbitContador contador = new HobbitContador();
        assertEquals(0, contador.calcularDiferenca(arrayDePares));
    }
    
    @Test
    public void calcularDiferencaArrayUmValorZero() {
        ArrayList<ArrayList<Integer>> arrayDePares = new ArrayList<>();
        arrayDePares.add(new ArrayList<>(Arrays.asList(0, 1)));
        HobbitContador contador = new HobbitContador();
        assertEquals(0, contador.calcularDiferenca(arrayDePares));
    }
}
