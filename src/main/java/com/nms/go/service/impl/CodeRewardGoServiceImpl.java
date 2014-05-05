/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.service.impl;

import com.nms.go.dao.CodeRewardGoDao;
import com.nms.go.dao.Dao;
import com.nms.go.model.CodeRewardGo;
import com.nms.go.service.CodeRewardGoService;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author CuongNT
 */
@Service("codeRewardGoService")
public class CodeRewardGoServiceImpl extends BaseServiceImpl<CodeRewardGo, Long, CodeRewardGoDao> implements CodeRewardGoService {

    @Override
    @Autowired
    public void setDao(CodeRewardGoDao codeRewardGoDao) {
        this.dao = codeRewardGoDao;
    }

    @Override
    @Transactional
    public List<CodeRewardGo> findByIsdn(String isdn) {
        return dao.findByIsdn(isdn);
    }

}
