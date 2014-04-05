/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.util;

/**
 *
 * @author cuongnt
 */
public class AppException extends RuntimeException {

    // serialVersionUID
    private static final long serialVersionUID = 7917124882867402474L;

    public AppException() {
        super();
    }

    public AppException(String messsage) {
        super(messsage);
    }

    public AppException(Throwable cause) {
        super(cause);
    }

    public AppException(Throwable cause, String message) {
        super(message, cause);
    }
}
