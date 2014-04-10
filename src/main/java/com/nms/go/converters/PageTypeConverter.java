/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.converters;

import com.nms.go.model.type.PageType;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author cuongnt
 */
@Component("pageTypeConverter")
@Scope("request")
public class PageTypeConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        int pageTypeValue = Integer.valueOf(value);
        PageType pageType = PageType.fromIntValue(pageTypeValue);
        return pageType;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        PageType pageType = (PageType) value;
        return String.valueOf(pageType.getValue());
    }

}
