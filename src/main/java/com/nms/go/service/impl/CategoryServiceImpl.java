/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.service.impl;

import com.nms.go.dao.CategoryDao;
import com.nms.go.model.Category;
import com.nms.go.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("categoryService")
public class CategoryServiceImpl extends BaseServiceImpl<Category, Long, CategoryDao> implements CategoryService {

    @Override
    @Autowired
    public void setDao(CategoryDao categoryDao) {
        this.dao = categoryDao;
    }
}
