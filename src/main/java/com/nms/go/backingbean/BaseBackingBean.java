/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.backingbean;

import com.nms.go.service.BaseService;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cuongnt
 * @param <T>
 * @param <S>
 */
public abstract class BaseBackingBean<T, S extends BaseService<T, Long>> {

    protected Long id;
    protected T instance;
    protected List<T> instances;

    protected abstract S getService();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public T getInstance() {
        if (instance == null) {
            if (id != null) {
                instance = loadInstance();
            } else {
                instance = createInstance();
            }
        }
        return instance;
    }

    public void setInstance(T instance) {
        this.instance = instance;
    }

    public List<T> getInstances() {

        if (instances == null || instances.isEmpty()) {
            instances = getService().list();
        }

        return instances;
    }

    public void setInstances(List<T> instances) {
        this.instances = instances;
    }

    public T loadInstance() {
        return getService().load(id);
    }

    public T createInstance() {
        try {
            return getClassType().newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            getLogger().log(Level.SEVERE, "error web create persistance object", e);
        }
        return null;
    }

    public String save() {
        if (id != null) {
            getService().update(instance);
        } else {
            getService().add(instance);
        }

        if (instances != null && !instances.isEmpty()) {
            instances.clear();
        }

        return "list?faces-redirect=true";
    }

    public String delete(T entity) {
        getService().delete(entity);
        if (instances != null && !instances.isEmpty()) {
            instances.clear();
        }
        return "list?faces-redirect=true";
    }

    public String cancel() {
        return "list?faces-redirect=true";
    }

    private Class<T> getClassType() {
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        return (Class<T>) parameterizedType.getActualTypeArguments()[0];
    }

    //protected
    protected abstract Logger getLogger();
}
