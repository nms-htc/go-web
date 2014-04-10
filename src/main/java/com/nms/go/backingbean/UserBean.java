/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.backingbean;

import com.nms.go.model.User;
import com.nms.go.service.UserService;
import java.io.Serializable;
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
public class UserBean extends BaseBackingBean<User, UserService> implements Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 9197229137125950192L;

    // Logger
    private static final Logger logger = Logger.getLogger(UserBean.class.getName());

    @Autowired
    private UserService service;
    
    public void setService(UserService service) {
        this.service = service;
    }

    @Override
    protected UserService getService() {
        return service;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }
}
