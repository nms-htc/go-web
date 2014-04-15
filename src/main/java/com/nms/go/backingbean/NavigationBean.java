/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nms.go.backingbean;

import com.nms.go.model.Page;
import com.nms.go.service.PageService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author cuongnt
 */
@Component
@Scope("session")
public class NavigationBean implements Serializable {
    
    // serialVersionUID
    private static final long serialVersionUID = -3214164612255990490L;
    @Autowired
    private PageService pageService;
    private List<Page> pages;
    
    @PostConstruct
    public void init() {
        pages = pageService.list();
    }
    
    public List<Page> getPages() {
        return pages;
    }
    
    public void setPages(List<Page> pages) {
        this.pages = pages;
    }
    
    public void setPageService(PageService pageService) {
        this.pageService = pageService;
    }
    
}
