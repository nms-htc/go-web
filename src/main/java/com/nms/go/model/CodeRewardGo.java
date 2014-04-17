/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nms.go.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Cuong
 */
@Entity
@Table(name = "CODEREWARDGO")
@SuppressWarnings("PersistenceUnitPresent")
public class CodeRewardGo implements Serializable {
    
    // serialVersionUID
    private static final long serialVersionUID = 6419526845538560170L;
    
    private Long id;
    private Long productId;
    private Date createDate;
    private String isdn;
    private String codeReward;
    private boolean bingo;
    private boolean expireCode;
    
    public CodeRewardGo() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getIsdn() {
        return isdn;
    }

    public void setIsdn(String isdn) {
        this.isdn = isdn;
    }

    public String getCodeReward() {
        return codeReward;
    }

    public void setCodeReward(String codeReward) {
        this.codeReward = codeReward;
    }

    public boolean isBingo() {
        return bingo;
    }

    public void setBingo(boolean bingo) {
        this.bingo = bingo;
    }

    public boolean isExpireCode() {
        return expireCode;
    }

    public void setExpireCode(boolean expireCode) {
        this.expireCode = expireCode;
    }
}
