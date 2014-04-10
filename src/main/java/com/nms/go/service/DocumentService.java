/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.service;

import com.nms.go.model.Category;
import com.nms.go.model.Document;
import java.io.Serializable;
import java.util.List;

public interface DocumentService extends BaseService<Document, Long> {
    public List<Document> findByCategory(Category category);
}
