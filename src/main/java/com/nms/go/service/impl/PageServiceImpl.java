/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.service.impl;

import com.nms.go.dao.PageDao;
import com.nms.go.model.Page;
import com.nms.go.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pageService")
public class PageServiceImpl extends BaseServiceImpl<Page, Long, PageDao> implements PageService {

    @Override
    @Autowired
    public void setDao(PageDao pageDao) {
        this.dao = pageDao;
    }

}
