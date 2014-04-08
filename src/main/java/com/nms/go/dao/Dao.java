/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author cuongnt
 * @param <T>
 * @param <ID>
 */
public interface Dao<T, ID extends Serializable> {

    T findById(ID id);

    T findById(ID id, boolean lock);

    T fetchById(ID id);
    
    T fetchById(ID id, boolean lock);

    List<T> findAll();
    
    List<T> findByExample(T t, String[] excludeProperties);

    T makePersistent(T entity);
    
    T update(T entity);

    void makeTransient(T entity);
}
