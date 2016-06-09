/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.aula3;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marcelo.moura
 */
public class PessoaDAUTest {
    
    public PessoaDAUTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of insert method, of class PessoaDAU.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        Pessoa pessoa = new Pessoa(1l, "TesteInsert");
        PessoaDAU instance = new PessoaDAU();
        instance.insert(pessoa);
        List<Pessoa> lista = instance.findNome("TesteInsert");
        if(lista.size()>1) {
            fail("Retornou mais de um registro.");
        }
        assertEquals("TesteInsert", lista.get(0).getNome());
    }

    /**
     * Test of update method, of class PessoaDAU.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Pessoa pessoa = new Pessoa(1l, "TesteUpdate");
        PessoaDAU instance = new PessoaDAU();
        //instance.
        instance.update(pessoa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class PessoaDAU.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Pessoa pessoa = null;
        PessoaDAU instance = new PessoaDAU();
        instance.delete(pessoa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listAll method, of class PessoaDAU.
     */
    @Test
    public void testListAll() {
        System.out.println("listAll");
        PessoaDAU instance = new PessoaDAU();
        List<Pessoa> expResult = null;
        List<Pessoa> result = instance.listAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findNome method, of class PessoaDAU.
     */
    @Test
    public void testFindNome() {
        System.out.println("findNome");
        String nome = "";
        PessoaDAU instance = new PessoaDAU();
        List<Pessoa> expResult = null;
        List<Pessoa> result = instance.findNome(nome);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
