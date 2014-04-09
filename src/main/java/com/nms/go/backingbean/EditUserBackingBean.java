/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.backingbean;

import com.nms.go.model.User;
import com.nms.go.service.UserService;
import com.nms.go.util.JsfUtils;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author cuongnt
 */
@Component
@ViewScoped
public class EditUserBackingBean implements Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -1187602343747395494L;

    private boolean isNew = false;

    private User user;

    @Autowired
    private UserService userService;
    
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public EditUserBackingBean() {
    }

    @PostConstruct
    public void init() {
        String userId = (String) JsfUtils.getRequestParam("userId");
        if (userId == null || userId.trim().isEmpty()) {
            isNew = true;
            user = new User();
        } else {
            user = userService.load(Long.valueOf(userId));
        }
    }

    public String save() {
        if (isNew) {
            userService.add(user);
        } else {
            userService.update(user);
        }

        return "users?faces-redirect=true";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // Logger
    private static final Logger _logger = Logger.getLogger(EditUserBackingBean.class.getName());
}
