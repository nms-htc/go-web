/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.dao;

import com.nms.go.model.CodeRewardGo;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Cuong
 */
public interface CodeRewardGoDao extends Dao<CodeRewardGo, Long> {
    public List<CodeRewardGo> findByIsdn(String isdn);
}
