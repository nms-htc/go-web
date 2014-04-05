/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.util;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author cuongnt
 */
public class CustomHibernateDaoSupport extends HibernateDaoSupport {

    /**
     * Inject Session factory from spring context.
     *
     * @param sessionFactory
     */
    @Autowired
    public void injectSessionFactory(SessionFactory sessionFactory) {
        setSessionFactory(sessionFactory);
    }
}
