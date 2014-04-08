/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.service.impl;

import com.nms.go.dao.DocumentDao;
import com.nms.go.service.DocumentService;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class DocumentServiceImpl implements DocumentService {
    
    @Inject
    private DocumentDao documentDao;

    public void setDocumentDao(DocumentDao documentDao) {
        this.documentDao = documentDao;
    }
}
