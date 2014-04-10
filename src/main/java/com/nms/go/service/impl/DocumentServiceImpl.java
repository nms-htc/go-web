/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.service.impl;

import com.nms.go.dao.DocumentDao;
import com.nms.go.model.Category;
import com.nms.go.model.Document;
import com.nms.go.service.DocumentService;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("documentService")
public class DocumentServiceImpl extends BaseServiceImpl<Document, Long, DocumentDao> implements DocumentService {

    @Override
    @Autowired
    public void setDao(DocumentDao documentDao) {
        this.dao = documentDao;
    }

    @Override
    @Transactional
    public List<Document> findByCategory(Category cateogry) {
        return dao.createCriterion().add(Restrictions.eq("category", cateogry)).list();
    }
}
