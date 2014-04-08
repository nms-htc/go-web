/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.dao.impl;

import com.nms.go.dao.Dao;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.inject.Inject;
import org.hibernate.Criteria;
import org.hibernate.LockOptions;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;

/**
 *
 * @author cuongnt
 * @param <T>
 * @param <ID>
 */
public abstract class DaoImpl<T, ID extends Serializable> implements Dao<T, ID> {

    @Inject
    protected SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

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
        return (T) sessionFactory.getCurrentSession().get(getPersistentClass(), id);
    }

    @Override
    public T findById(ID id, boolean lock) {
        T entity;

        if (lock) {
            entity = (T) sessionFactory.getCurrentSession().get(getPersistentClass(), id, LockOptions.UPGRADE);
        } else {
            entity = (T) sessionFactory.getCurrentSession().get(getPersistentClass(), id);
        }

        return entity;
    }

    @Override
    public T fetchById(ID id) {
        return (T) sessionFactory.getCurrentSession().load(getPersistentClass(), id);
    }

    @Override
    public T fetchById(ID id, boolean lock) {
        T entity;

        if (lock) {
            entity = (T) sessionFactory.getCurrentSession().load(getPersistentClass(), id, LockOptions.UPGRADE);
        } else {
            entity = (T) sessionFactory.getCurrentSession().load(getPersistentClass(), id);
        }

        return entity;
    }

    @Override
    public List<T> findAll() {
        return findByCriteria();
    }

    @Override
    public List<T> findByExample(T exampleInstance, String[] excludeProperties) {
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(getPersistentClass());
        Example example = Example.create(exampleInstance);
        for (String exclude : excludeProperties) {
            example.excludeProperty(exclude);
        }
        crit.add(example);
        return crit.list();
    }

    @Override
    public T makePersistent(T entity) {
        sessionFactory.getCurrentSession().saveOrUpdate(entity);
        return entity;
    }

    @Override
    public void makeTransient(T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    public void flush() {
        sessionFactory.getCurrentSession().flush();
    }

    public void clear() {
        sessionFactory.getCurrentSession().clear();
    }

    /**
     * Use this method inside subclassess as a convenience method.
     *
     * @param criterions
     * @return
     */
    protected List<T> findByCriteria(Criterion... criterions) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(getPersistentClass());

        for (Criterion criterion : criterions) {
            criteria.add(criterion);

        }

        return criteria.list();
    }

    @Override
    public T update(T entity) {
        sessionFactory.getCurrentSession().update(entity);
        return entity;
    }
}
