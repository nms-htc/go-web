/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.service.impl;

import com.nms.go.dao.DocumentDao;
import com.nms.go.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("documentService")
public class DocumentServiceImpl implements DocumentService {

    private DocumentDao documentDao;

    @Autowired
    public void setDocumentDao(DocumentDao documentDao) {
        this.documentDao = documentDao;
    }
}
