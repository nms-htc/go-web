/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.dao.impl;

import com.nms.go.dao.PageDao;
import com.nms.go.model.Page;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

@Repository("pageDao")
public class PageDaoImpl extends DaoImpl<Page, Long> implements PageDao {

    @Override
    public List<Page> findAll() {
        List<Page> pages;
        Criteria criterion = sessionFactory.getCurrentSession().createCriteria(Page.class);
        criterion.addOrder(Order.asc("orderNo"));
        pages = criterion.list();

        return pages;
    }

}
