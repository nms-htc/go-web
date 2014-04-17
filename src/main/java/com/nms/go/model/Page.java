/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.model;

import com.nms.go.model.type.PageType;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Sort;

/**
 *
 * @author cuongnt
 */
@Entity
@Table(name = "GO_PAGE")
@SuppressWarnings("PersistenceUnitPresent")
public class Page implements Serializable {

    // serialVersionUID
    private static final long serialVersionUID = -8809434512314598077L;

    private Long pageId;
    private Date createDate;
    private User user;
    private String title;
    private int orderNo;
    private boolean disable;
    private PageType type;
    private Document document;
    private Category category;
    private String pageUri;

    public Page() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GO_SEQ")
    @SequenceGenerator(name = "GO_SEQ", sequenceName = "GO_SEQ")
    @Column(length = 10)
    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }
    
    @Temporal(TemporalType.DATE)
    public Date getCreateDate() {
        return createDate;
    }
    
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
    @ManyToOne
    @JoinColumn(name = "userId")
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    @Column(length = 100, nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(length = 2)
    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }
    
    @Enumerated(EnumType.ORDINAL)
    public PageType getType() {
        return type;
    }
    
    public void setType(PageType type) {
        this.type = type;
    }
    
    @ManyToOne
    @JoinColumn(name = "documentId")
    public Document getDocument() {
        return document;
    }
    
    public void setDocument(Document document) {
        this.document = document;
    }
    
    @ManyToOne
    @JoinColumn(name = "categoryId")
    public Category getCategory() {
        return category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }
    
    public String getPageUri() {
        return pageUri;
    }
    
    public void setPageUri(String pageUri) {
        this.pageUri = pageUri;
    }
}
