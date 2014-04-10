/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.backingbean;

import com.nms.go.model.Category;
import com.nms.go.model.Document;
import com.nms.go.service.CategoryService;
import com.nms.go.service.DocumentService;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author cuongnt
 */
@Component
@Scope("request")
public class DocumentBean extends BaseBackingBean<Document, DocumentService> implements Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -310090420483951542L;
    // Logger
    private static final Logger logger = Logger.getLogger(DocumentBean.class.getName());

    private List<Category> categories;

    @Autowired
    private DocumentService service;
    
    @Autowired
    private CategoryService categoryService;

    public void setService(DocumentService service) {
        this.service = service;
    }

    @Override
    protected DocumentService getService() {
        return service;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }

    public List<Category> getCategories() {
        if (categories == null || categories.isEmpty()) {
            categories = categoryService.list();
        }
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
}
