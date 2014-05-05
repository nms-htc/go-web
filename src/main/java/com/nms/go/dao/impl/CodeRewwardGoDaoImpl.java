/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.dao.impl;

import com.nms.go.dao.CodeRewardGoDao;
import com.nms.go.model.CodeRewardGo;
import java.util.List;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Cuong
 */
@Repository("codeRewardGoDao")
public class CodeRewwardGoDaoImpl extends DaoImpl<CodeRewardGo, Long> implements CodeRewardGoDao {
    
    @Override
    public List<CodeRewardGo> findByIsdn(String isdn) {
        return sessionFactory.getCurrentSession().createCriteria(CodeRewardGo.class)
                .add(Restrictions.eq("isdn", isdn))
                .add(Restrictions.eq("expireCode", false))
                .addOrder(Order.asc("createDate"))
                .list();
    }
    
}
