/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.service.impl;

import com.nms.go.dao.CategoryDao;
import com.nms.go.service.CategoryService;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CategoryServiceImpl implements CategoryService {

    @Inject
    private CategoryDao categoryDao;

    
    public void setCategoryDao(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }
}
