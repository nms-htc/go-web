/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.backingbean;

import com.nms.go.model.Category;
import com.nms.go.service.CategoryService;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.faces.bean.RequestScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author cuongnt
 */
@Component
@RequestScoped
public class CategoryBean extends BaseBackingBean<Category, CategoryService> implements Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 3100207253767301921L;
    // Logger
    private static final Logger logger = Logger.getLogger(CategoryBean.class.getName());

    @Autowired
    private CategoryService service;

    public void setService(CategoryService service) {
        this.service = service;
    }

    @Override
    protected CategoryService getService() {
        return service;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }
}
