/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.dao.impl;

import com.nms.go.dao.Dao;
import com.nms.go.util.CustomHibernateDaoSupport;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;

/**
 *
 * @author cuongnt
 * @param <T>
 * @param <ID>
 */
public abstract class DaoImpl<T, ID extends Serializable> extends CustomHibernateDaoSupport implements Dao<T, ID> {

    protected Class<T> persistentClass;

    public DaoImpl() {
        persistentClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    @Override
    public T findById(ID id) {
        return (T) getSession().get(getPersistentClass(), id);
    }

    @Override
    public T findById(ID id, boolean lock) {
        T entity;

        if (lock) {
            entity = (T) getSession().get(getPersistentClass(), id, LockOptions.UPGRADE);
        } else {
            entity = (T) getSession().get(getPersistentClass(), id);
        }

        return entity;
    }

    @Override
    public T fetchById(ID id) {
        return (T) getSession().load(getPersistentClass(), id);
    }

    @Override
    public T fetchById(ID id, boolean lock) {
        T entity;

        if (lock) {
            entity = (T) getSession().load(getPersistentClass(), id, LockOptions.UPGRADE);
        } else {
            entity = (T) getSession().load(getPersistentClass(), id);
        }

        return entity;
    }

    @Override
    public List<T> findAll() {
        return findByCriteria();
    }

    @Override
    public List<T> findByExample(T exampleInstance, String[] excludeProperties) {
        Criteria crit = getSession().createCriteria(getPersistentClass());
        Example example = Example.create(exampleInstance);
        for (String exclude : excludeProperties) {
            example.excludeProperty(exclude);
        }
        crit.add(example);
        return crit.list();
    }

    @Override
    public T makePersistent(T entity) {
        getSession().saveOrUpdate(entity);
        return entity;
    }

    @Override
    public void makeTransient(T entity) {
        getSession().delete(entity);
    }

    public void flush() {
        getSession().flush();
    }

    public void clear() {
        getSession().clear();
    }

    /**
     * Use this method inside subclassess as a convenience method.
     *
     * @param criterions
     * @return
     */
    protected List<T> findByCriteria(Criterion... criterions) {
        Criteria criteria = getSession().createCriteria(getPersistentClass());

        for (Criterion criterion : criterions) {
            criteria.add(criterion);

        }

        return criteria.list();
    }
}
