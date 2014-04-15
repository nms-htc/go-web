/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.converters;

import com.nms.go.model.Document;
import com.nms.go.service.DocumentService;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author cuongnt
 */
@Component("documentConverter")
@Scope("request")
public class DocumentConverter implements Converter {

    @Autowired
    private DocumentService documentService;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return  documentService.load(Long.valueOf(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            Document document = (Document) value;
            String documentId = String.valueOf(document.getDocumentId());
            return documentId;
        }
        return "";
    }

    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }
}
