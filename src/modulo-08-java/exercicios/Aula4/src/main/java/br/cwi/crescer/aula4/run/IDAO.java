/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.aula4.run;

import java.util.List;

/**
 *
 * @author marcelo.moura
 */
public interface IDAO<T> {
    
    void insert(T t);
    void update(T t);
    void delete(T t);
    T load(Object id);
    List<T> listAll();
}
