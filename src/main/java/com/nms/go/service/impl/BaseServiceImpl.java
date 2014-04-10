/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.service.impl;

import com.nms.go.dao.Dao;
import com.nms.go.service.BaseService;
import java.io.Serializable;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author cuongnt
 * @param <T>
 * @param <ID>
 * @param <E>
 */
public abstract class BaseServiceImpl<T, ID extends Serializable, E extends Dao<T, ID>> implements BaseService<T, ID> {

    protected E dao;

    public abstract void setDao(E dao);

    @Override
    @Transactional
    public T load(ID id) {
        return dao.findById(id);
    }

    @Override
    @Transactional
    public T add(T entity) {
        return dao.makePersistent(entity);
    }

    @Override
    @Transactional
    public T update(T entity) {
        return dao.update(entity);
    }

    @Override
    @Transactional
    public void delete(T entity) {
        dao.makeTransient(entity);
    }

    @Override
    @Transactional
    public void delete(ID id) {
        T entity = load(id);
        delete(entity);
    }

    @Override
    @Transactional
    public List<T> list() {
        return dao.findAll();
    }

    @Override
    public List<T> getAll() {
        return list();
    }
}
