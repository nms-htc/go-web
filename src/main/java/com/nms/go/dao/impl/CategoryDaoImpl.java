/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.dao.impl;

import com.nms.go.dao.CategoryDao;
import com.nms.go.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDaoImpl extends DaoImpl<Category, Long> implements CategoryDao{

}
