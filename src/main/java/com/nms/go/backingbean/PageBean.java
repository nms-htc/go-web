/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.backingbean;

import com.nms.go.model.Category;
import com.nms.go.model.Document;
import com.nms.go.model.Page;
import com.nms.go.model.type.PageType;
import com.nms.go.service.CategoryService;
import com.nms.go.service.DocumentService;
import com.nms.go.service.PageService;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.event.ValueChangeEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author cuongnt
 */
@Component
@Scope("request")
public class PageBean extends BaseBackingBean<Page, PageService> implements Serializable {

    // serialVersionUID
    private static final long serialVersionUID = 3398545141618828344L;
    // Logger
    private static final Logger logger = Logger.getLogger(PageBean.class.getName());

    private List<PageType> pageTypes;
    private List<Category> categories;
    private List<Document> documents;
    
    private Long documentId;

    @Autowired
    private PageService service;
    @Autowired
    private CategoryService categorySevice;
    @Autowired
    private DocumentService documentService;

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
    
    public void categoryChange(ValueChangeEvent event) {
        Category category = (Category) event.getNewValue();
        if (category != null) {
            documents = documentService.findByCategory(category);
        }
    }

    public List<PageType> getPageTypes() {
        if (pageTypes == null || pageTypes.isEmpty()) {
            pageTypes = Arrays.asList(PageType.values());
        }
        return pageTypes;
    }

    public void setPageTypes(List<PageType> pageTypes) {
        this.pageTypes = pageTypes;
    }

    public List<Category> getCategories() {
        if (categories == null || categories.isEmpty()) {
            categories = categorySevice.list();
        }
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public void setCategorySevice(CategoryService categorySevice) {
        this.categorySevice = categorySevice;
    }

    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    @Override
    public void setId(Long id) {
        super.setId(id);
        if (instance != null) {
            if (instance.getCategory() != null) {
                documents = documentService.findByCategory(instance.getCategory());
            }
        }
    }
    
    
}
