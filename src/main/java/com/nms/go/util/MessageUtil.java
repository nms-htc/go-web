/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.util;

import java.text.MessageFormat;

/**
 *
 * @author cuongnt
 */
public class MessageUtil {

    public static String getMessage(String key, String resourceName) {
        return JsfUtils.getResourceBundle(resourceName).getString(key);
    }

    public static String getMessage(String key) {
        return getMessage(key, "msg");
    }

    public static String format(String key, String resouceName, Object[] args) {
        MessageFormat format = new MessageFormat(getMessage(key, resouceName));
        return format.format(args);
    }

    public static String format(String key, Object[] args) {
        return format(key, "msg", args);
    }
}
