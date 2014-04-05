/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.dao.impl;

import com.nms.go.dao.DocumentDao;
import com.nms.go.model.Document;
import org.springframework.stereotype.Repository;

@Repository
public class DocumentDaoImpl extends DaoImpl<Document, Long> implements DocumentDao {

}
