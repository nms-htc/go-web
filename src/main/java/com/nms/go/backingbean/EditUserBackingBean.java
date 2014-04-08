/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.backingbean;

import com.nms.go.model.User;
import com.nms.go.service.UserService;
import com.nms.go.util.JsfUtils;
import com.nms.go.util.MessageUtil;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author cuongnt
 */
@Named
@Scope("request")
public class EditUserBackingBean implements Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -1187602343747395494L;

    private boolean isNew = false;

    private User user;

    @Inject
    private UserService userService;

    public EditUserBackingBean() {
    }

    @PostConstruct
    public void init() {
        String userId = (String) JsfUtils.getRequestParam("userId");
        if (userId == null || userId.trim().isEmpty()) {
            isNew = true;
            user = new User();
        } else {
            user = userService.fetchUser(Long.valueOf(userId));
        }
    }

    public String save() {
        if (isNew) {
            userService.addUser(user);
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
