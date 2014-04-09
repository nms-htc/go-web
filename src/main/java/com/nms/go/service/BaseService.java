/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.service;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author cuongnt
 * @param <T>
 * @param <ID>
 */
public interface BaseService<T, ID extends Serializable> {

    public T load(ID id);

    public T add(T entity);
    
    public T update(T entity);

    public void delete(T entity);
    
    public void delete(ID id);

    public List<T> list();
}
