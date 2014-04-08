/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.util;

import java.util.Map;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;

/**
 *
 * @author cuongnt
 */
public class JsfUtils {

    public static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    public static Map<String, String> getRequestParams() {
        return getFacesContext().getExternalContext().getRequestParameterMap();
    }

    public static String getRequestParam(String paramName) {
        return getRequestParams().get(paramName);
    }

    public static ResourceBundle getResourceBundle(String name) {
        return getFacesContext().getApplication().getResourceBundle(getFacesContext(), name);
    }
}
