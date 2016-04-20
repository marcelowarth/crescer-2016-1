import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class IntercaladoTest
{
    @After
    public void tearDown() {
        System.gc();
    }
    
    @Test
    public void testaIntercalado() {
        Elfo e1 = new ElfoNoturno("ASD");
        Elfo e2 = new ElfoNoturno("ASD2");
        Elfo e3 = new ElfosVerdes("ASD3");
        Elfo e4 = new ElfosVerdes("ASD4");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistaElfo(e1);
        exercito.alistaElfo(e2);
        exercito.alistaElfo(e3);
        exercito.alistaElfo(e4);
        
        ArrayList<Dwarf> dwarfs = new ArrayList<>();
        dwarfs.add(new Dwarf("d1"));
        dwarfs.add(new Dwarf("d2"));
        
        Intercalado in = new Intercalado();
        exercito.agruparPorStatus();
        in.atacar(exercito.buscar(Status.VIVO), dwarfs);
        
        
        boolean ordemCerta = true;
        String tipoUltimo = "";
        ArrayList<Elfo> obtido = in.getOrdemDoUltimoAtaque();
        for(Elfo e : obtido) {
            if(e instanceof ElfoNoturno && ordemCerta && tipoUltimo != e.getClass().getName()) {
                tipoUltimo = obtido.getClass().getName();
            } else if(e instanceof ElfosVerdes && ordemCerta && tipoUltimo != e.getClass().getName()) {
                tipoUltimo = obtido.getClass().getName();
            } else {
                ordemCerta = false;
                break;
            }
        }
        
        assertTrue(ordemCerta);
    }
    
    @Test
    public void testaIntercaladoSem5050() {
        Elfo e1 = new ElfoNoturno("ASD");
        Elfo e3 = new ElfosVerdes("ASD3");
        Elfo e4 = new ElfosVerdes("ASD4");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistaElfo(e1);
        exercito.alistaElfo(e3);
        exercito.alistaElfo(e4);
        
        ArrayList<Dwarf> dwarfs = new ArrayList<>();
        dwarfs.add(new Dwarf("d1"));
        dwarfs.add(new Dwarf("d2"));
        
        Intercalado in = new Intercalado();
        exercito.agruparPorStatus();
        in.atacar(exercito.buscar(Status.VIVO), dwarfs);
        
        assertNull(in.getOrdemDoUltimoAtaque());
    }
    
    @Test
    public void exercitoIntercaladoComeçandoComElfoNoturno() {
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudarEstrategia(new Intercalado());
        Elfo night1 = new ElfoNoturno("Night 1");
        Elfo night2 = new ElfoNoturno("Night 2");
        Elfo green1 = new ElfosVerdes("Green 1");
        Elfo night3 = new ElfoNoturno("Night 3");
        Elfo green2 = new ElfosVerdes("Green 2");
        Elfo green3 = new ElfosVerdes("Green 3");
        exercito.alistaElfo(night1);
        exercito.alistaElfo(night2);
        exercito.alistaElfo(green1);
        exercito.alistaElfo(night3);
        exercito.alistaElfo(green2);
        exercito.alistaElfo(green3);
        List<Elfo> esperado = new ArrayList<>(Arrays.asList(night3, green2, night1, green1, night2, green3));
        // Act
        exercito.atacar(new ArrayList<>(Arrays.asList(new Dwarf("D1"), new Dwarf("D2"), new Dwarf("D3"))));
        // Assert
        ArrayList<Elfo> resultado = exercito.getOrdemDoUltimoAtaque();
        assertEquals(esperado, resultado);
    }

    @Test
    public void exercitoIntercaladoComeçandoComElfoVerde() {
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudarEstrategia(new Intercalado());
        Elfo night1 = new ElfoNoturno("EN1");
        Elfo night2 = new ElfoNoturno("EN2");
        Elfo green1 = new ElfosVerdes("EV1");
        Elfo green2 = new ElfosVerdes("EV2");
        exercito.alistaElfo(night1);
        exercito.alistaElfo(night2);
        exercito.alistaElfo(green1);
        exercito.alistaElfo(green2);
        List<Elfo> esperado = new ArrayList<>(Arrays.asList(green2, night2, green1, night1));
        // Act
        exercito.atacar(new ArrayList<>(Arrays.asList(new Dwarf("D1"), new Dwarf("D2"), new Dwarf("D3"))));
        // Assert
        ArrayList<Elfo> resultado = exercito.getOrdemDoUltimoAtaque();
        assertEquals(esperado, resultado);
    }

    @Test
    public void exercitoDesproporcionalNãoAtaca() {
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudarEstrategia(new Intercalado());
        Elfo night1 = new ElfoNoturno("Noturno 1");
        Elfo night2 = new ElfoNoturno("Elfo Noturno 2");
        Elfo green1 = new ElfosVerdes("Elfo Verde 1");
        exercito.alistaElfo(green1);
        exercito.alistaElfo(night1);
        exercito.alistaElfo(night2);
        // Act
        exercito.atacar(new ArrayList<>(Arrays.asList(new Dwarf("D1"), new Dwarf("D2"), new Dwarf("D3"))));
        // Assert
        ArrayList<Elfo> resultado = exercito.getOrdemDoUltimoAtaque();
        assertTrue(resultado.isEmpty());
    }

    @Test
    public void exercitoSoDeUmTipoNãoAtaca() {
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudarEstrategia(new Intercalado());
        Elfo night1 = new ElfoNoturno("Noturno 1");
        Elfo night2 = new ElfoNoturno("Elfo Noturno 2");
        exercito.alistaElfo(night1);
        exercito.alistaElfo(night2);
        // Act
        exercito.atacar(new ArrayList<>(Arrays.asList(new Dwarf("D1"), new Dwarf("D2"), new Dwarf("D3"))));
        // Assert
        ArrayList<Elfo> resultado = exercito.getOrdemDoUltimoAtaque();
        assertTrue(resultado.isEmpty());
    }

    @Test
    public void ataqueComExercitoVazio() {
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudarEstrategia(new Intercalado());
        exercito.atacar(new ArrayList<>(Arrays.asList(new Dwarf("D1"), new Dwarf("D2"))));
        List<Elfo> ordemAtaque = exercito.getOrdemDoUltimoAtaque();
        assertTrue(ordemAtaque.isEmpty());
    }

    @Test
    public void exercitoIntercaladoComElfoNoturnoMortoDesproporcional() {
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudarEstrategia(new Intercalado());
        Elfo night1 = new ElfoNoturno("EN1");
        for (int i = 0; i < 90; i++) night1.atirarFlechaDwarfs(new Dwarf("D1"));
        Elfo night2 = new ElfoNoturno("EN2");
        Elfo green1 = new ElfosVerdes("EV1");
        Elfo green2 = new ElfosVerdes("EV2");
        exercito.alistaElfo(night1);
        exercito.alistaElfo(night2);
        exercito.alistaElfo(green1);
        exercito.alistaElfo(green2);
        // Act
        exercito.atacar(new ArrayList<>(Arrays.asList(new Dwarf("D1"), new Dwarf("D2"), new Dwarf("D3"))));
        // Assert
        assertTrue(exercito.getOrdemDoUltimoAtaque().isEmpty());
    }

    @Test
    public void exercitoIntercaladoComElfoNoturnoMortoProporcional() {
        // Arrange
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.mudarEstrategia(new Intercalado());
        Elfo night1 = new ElfoNoturno("EN1");
        for (int i = 0; i < 90; i++) night1.atirarFlechaDwarfs(new Dwarf("D1"));
        Elfo night2 = new ElfoNoturno("EN2");
        Elfo night3 = new ElfoNoturno("EN3");
        Elfo green1 = new ElfosVerdes("EV1");
        Elfo green2 = new ElfosVerdes("EV2");
        exercito.alistaElfo(night1);
        exercito.alistaElfo(night2);
        exercito.alistaElfo(night3);
        exercito.alistaElfo(green1);
        exercito.alistaElfo(green2);
        List<Elfo> esperado = new ArrayList<>(Arrays.asList(green2, night2, green1, night3));
        // Act
        exercito.atacar(new ArrayList<>(Arrays.asList(new Dwarf("D1"), new Dwarf("D2"), new Dwarf("D3"))));
        // Assert
        assertEquals(esperado, exercito.getOrdemDoUltimoAtaque());
    }
}
