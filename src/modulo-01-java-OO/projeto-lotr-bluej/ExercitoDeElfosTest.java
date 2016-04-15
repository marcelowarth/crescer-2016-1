import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class ExercitoDeElfosTest
{
    @After
    public void tearDown() {
        System.gc();
    }
    
    @Test
    public void adicionaNoExercito() {
        Elfo e1 = new Elfo("Legolas");
        Elfo e2 = new ElfoNoturno("elfo1");
        Elfo e3 = new ElfosVerdes("elfo2");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistaElfo(e1);
        exercito.alistaElfo(e2);
        exercito.alistaElfo(e3);
        
        assertEquals(false, exercito.getExercito().containsKey("Legolas"));
        assertEquals(true, exercito.getExercito().containsKey("elfo1"));
        assertEquals(true, exercito.getExercito().containsKey("elfo2"));
    }
    
    @Test
    public void retornaAgrupado() {
        Elfo e1 = new ElfosVerdes("Legolas");
        Elfo e2 = new ElfoNoturno("elfo1");
        Elfo e3 = new ElfosVerdes("elfo2");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        Dwarf d1 = new Dwarf("d1");
        for(int i = 0; i < 90; i++){
            e2.atirarFlechaDwarfs(d1);
        }
        exercito.alistaElfo(e1);
        exercito.alistaElfo(e2);
        exercito.alistaElfo(e3);
        exercito.agruparPorStatus();
        
        assertEquals(1, exercito.buscar(Status.MORTO).size());
        assertEquals(2, exercito.buscar(Status.VIVO).size());
    }
    
    @Test
    public void exercitoAtacaNoturnosUltimo() {
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
        
        exercito.atacar(dwarfs);
        
        ArrayList<Elfo> obtido = exercito.getOrdemDoUltimoAtaque();
        
        boolean saiuVerdes = false, erro = false;
        for(Elfo e : obtido) {
            if(e instanceof ElfoNoturno && !saiuVerdes) {
                saiuVerdes = true;
            }
            if(e instanceof ElfosVerdes && saiuVerdes) {
                erro = true;
            }
        }
        
        assertFalse(erro);        
    }
    
    @Test
    public void exercitoAtacaArteDaGuerra() {
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
        
        exercito.mudarEstrategia(new ArteDaGuerra());
        exercito.atacar(dwarfs);
        
        ArrayList<Elfo> obtido = exercito.getOrdemDoUltimoAtaque();
        
        assertEquals(3, obtido.size());
    }
    
    @Test
    public void exercitoAtacaIntercalado() {
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
        
        exercito.mudarEstrategia(new Intercalado());
        exercito.atacar(dwarfs);
        
        ArrayList<Elfo> obtido = exercito.getOrdemDoUltimoAtaque();
        
        boolean ordemCerta = true;
        String tipoUltimo = "";
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
    public void exercitoAtacaIntercaladoNull() {
        Elfo e1 = new ElfoNoturno("ASD");
        Elfo e2 = new ElfoNoturno("ASD2");
        Elfo e4 = new ElfosVerdes("ASD4");
        ExercitoDeElfos exercito = new ExercitoDeElfos();
        exercito.alistaElfo(e1);
        exercito.alistaElfo(e2);
        exercito.alistaElfo(e4);
        
        ArrayList<Dwarf> dwarfs = new ArrayList<>();
        dwarfs.add(new Dwarf("d1"));
        dwarfs.add(new Dwarf("d2"));
        
        exercito.mudarEstrategia(new Intercalado());
        exercito.atacar(dwarfs);
        
        ArrayList<Elfo> obtido = exercito.getOrdemDoUltimoAtaque();
        
        assertNull(obtido);
    }
}












