package br.cwi.crescer.aula4.run;

import br.cwi.crescer.aula4.entity.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AppRun {

    static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER16");
    static final EntityManager em = emf.createEntityManager ();
    
    public static void main(String[] args) {
        /*
        em.getTransaction().begin();
        //System.out.println(em.isOpen());
        
        //Pessoa pessoa = em.find(Pessoa.class, 1l);
        Pessoa pessoa = new Pessoa();
        pessoa.setNmPessoa("Marcelo");
        System.out.println(pessoa.getNmPessoa());
        
        em.persist(pessoa);
        
        em.getTransaction().commit();
*/
        
        Query query = em.createQuery("Select p from Pessoa p");
        List<Pessoa> pessoas = query.getResultList();
        
        for(Pessoa p : pessoas) {
            System.out.println(p.getNmPessoa());
        }
        
        em.close();
        emf.close();
    }
}
