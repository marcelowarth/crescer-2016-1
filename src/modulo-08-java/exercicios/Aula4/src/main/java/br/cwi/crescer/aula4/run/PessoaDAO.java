/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.aula4.run;

import br.cwi.crescer.aula4.entity.Pessoa;
import javax.persistence.EntityManager;

/**
 *
 * @author marcelo.moura
 */
public class PessoaDAO extends DAO<Pessoa> {
    
    final EntityManager entityManager;
    
    public PessoaDAO(EntityManager entityManager) {
        super(Pessoa.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
    
}
