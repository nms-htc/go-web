/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.backingbean;

import com.nms.go.model.User;
import com.nms.go.service.UserService;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author cuongnt
 */
@Named
@Scope("request")
public class UsersBackingBean implements Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -2423321078167110937L;

    private List<User> users;

    @Inject
    private UserService userService;

    public UsersBackingBean() {
        
    }
    
    @PostConstruct
    public void init() {
        users = userService.getAllUser();
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    // Logger
    private static final Logger _logger = Logger.getLogger(UsersBackingBean.class.getName());
}
