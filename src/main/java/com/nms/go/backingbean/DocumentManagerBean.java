/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.backingbean;

import com.nms.go.model.User;
import com.nms.go.service.UserService;
import java.io.Serializable;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;

/**
 *
 * @author cuongnt
 */
@Named
@Scope("request")
public class DocumentManagerBean implements Serializable {

    private static final long serialVersionUID = -6714315427287644904L;

    private String name = "Nguyen Trong CUong";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DocumentManagerBean() {

    }

    @Inject
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public UserService getUserService() {
        return userService;
    }

    public String testPhat() {
        User user = new User();
        user.setCreatedDate(new Date());
        user.setUserName("cuongnt1987");
        user.setFirstName("Cuong");
        user.setLastName("Nguyen");
        user.setMiddleName("Trong");
        user.setPassword("Thanhlong");
        user.setDisabled(false);

        if (userService != null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Da tim thay nhe", "Co roi nhe"));
        }

        //userService.addUser(user);
        return "";
    }
}
