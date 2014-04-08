/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.service.impl;

import com.nms.go.dao.PageDao;
import com.nms.go.service.PageService;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class PageServiceImpl implements PageService {

    private PageDao pageDao;

    @Inject
    public void setPageDao(PageDao pageDao) {
        this.pageDao = pageDao;
    }
}
