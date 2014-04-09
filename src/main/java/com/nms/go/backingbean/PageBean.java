/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.backingbean;

import com.nms.go.model.Page;
import com.nms.go.service.PageService;
import com.nms.go.service.UserService;
import com.nms.go.service.impl.PageServiceImpl;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.faces.bean.RequestScoped;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author cuongnt
 */
@Component
@RequestScoped
public class PageBean extends BaseBackingBean<Page, PageService> implements Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 3398545141618828344L;
    // Logger
    private static final Logger logger = Logger.getLogger(PageBean.class.getName());

    @Autowired
    private PageService service;
    
    public void setService(PageService service) {
        this.service = service;
    }

    @Override
    protected PageService getService() {
        return service;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }
}
