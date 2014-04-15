/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.backingbean;

import com.nms.go.model.Document;
import com.nms.go.service.DocumentService;
import javax.faces.event.ComponentSystemEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author cuongnt
 */
@Component
@Scope("request")
public class SingleDocumentBean {

    private Long documentId;
    private Document document;

    @Autowired
    private DocumentService documentService;

    public SingleDocumentBean() {
    }

    public void loadDocument(ComponentSystemEvent event) {
         if (document == null) {
            if (documentId != null) {
                document = documentService.load(documentId);
            }
        }
    }

    public void setDocumentId(Long documentId) {
       
        this.documentId = documentId;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
