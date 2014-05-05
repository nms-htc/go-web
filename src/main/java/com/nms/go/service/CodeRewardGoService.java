/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.service;

import com.nms.go.model.CodeRewardGo;
import java.util.List;

/**
 *
 * @author CuongNT
 */
public interface CodeRewardGoService extends BaseService<CodeRewardGo, Long> {
    public List<CodeRewardGo> findByIsdn(String isdn);
}
