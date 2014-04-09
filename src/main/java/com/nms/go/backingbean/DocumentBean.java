/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.backingbean;

import com.nms.go.model.Document;
import com.nms.go.service.DocumentService;
import com.nms.go.service.UserService;
import com.nms.go.service.impl.DocumentServiceImpl;
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
public class DocumentBean extends BaseBackingBean<Document, DocumentService> implements Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -310090420483951542L;
    // Logger
    private static final Logger logger = Logger.getLogger(DocumentBean.class.getName());
    
    @Autowired
    private DocumentService service;
    
    public void setService(DocumentService service) {
        this.service = service;
    }

    @Override
    protected DocumentService getService() {
        return service;
    }

    @Override
    protected Logger getLogger() {
        return logger;
    }

    
}
