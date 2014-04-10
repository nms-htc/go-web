/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.converters;

import com.nms.go.model.Category;
import com.nms.go.service.CategoryService;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author cuongnt
 */
@Component("categoryConverter")
@Scope("request")
public class CategoryConverter implements Converter {

    @Autowired
    private CategoryService categoryService;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null) {
            try {
                Long categoryId = Long.valueOf(value);
                Category category = categoryService.load(categoryId);
                return category;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Category id = (Category) value;
            String resutl = id.getCategoryId().toString();
            return resutl;
        } else {
            return null;
        }
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

}
