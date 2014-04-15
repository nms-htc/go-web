/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.backingbean;

import com.nms.go.model.Category;
import com.nms.go.model.Document;
import com.nms.go.service.CategoryService;
import com.nms.go.service.DocumentService;
import java.util.List;
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
public class ListDocumentBean {

    private Long categoryId;
    private List<Document> documents;

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private DocumentService documentService;

    public ListDocumentBean() {

    }

    public void loadDocuments(ComponentSystemEvent event) {
        Category category = null;

        if (categoryId != null) {
            try {
                category = categoryService.load(categoryId);
            } catch (Exception ex) {

            }
            
            if (category != null) {
                documents = documentService.findByCategory(category);
            }
        }
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public CategoryService getCategoryService() {
        return categoryService;
    }

    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    public DocumentService getDocumentService() {
        return documentService;
    }

    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }
}
