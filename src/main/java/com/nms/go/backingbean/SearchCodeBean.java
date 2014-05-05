/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nms.go.backingbean;

import com.nms.go.dao.CodeRewardGoDao;
import com.nms.go.model.CodeRewardGo;
import com.nms.go.service.CodeRewardGoService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.event.ActionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author CuongNT
 */
@Component("searchCode")
@Scope("request")
public class SearchCodeBean {
    
    private String isdn;
    private List<CodeRewardGo> list = new ArrayList<>();
    
    @Autowired
    private CodeRewardGoService codeRewardGoService;

    public SearchCodeBean() {
    }
    
    public void search(ActionEvent event) {
        if (isdn != null) {
            try {
                list = codeRewardGoService.findByIsdn(isdn);
                Logger.getLogger(SearchCodeBean.class.getName()).info("" + list.size());
            } catch (Exception e) {
                Logger.getLogger(SearchCodeBean.class.getName()).info(e.getMessage());
            }
        }
    }

    public String getIsdn() {
        return isdn;
    }

    public void setIsdn(String isdn) {
        this.isdn = isdn;
    }

    public List<CodeRewardGo> getList() {
        return list;
    }

    public void setList(List<CodeRewardGo> list) {
        this.list = list;
    }

    public CodeRewardGoService getCodeRewardGoService() {
        return codeRewardGoService;
    }

    public void setCodeRewardGoService(CodeRewardGoService codeRewardGoService) {
        this.codeRewardGoService = codeRewardGoService;
    }
}
