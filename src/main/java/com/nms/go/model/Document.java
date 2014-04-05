/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nms.go.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author cuongnt
 */
@Entity
@Table(name = "GO_DOCUMENT")
@SuppressWarnings("PersistenceUnitPresent")
public class Document implements Serializable {
    
    // serialVersionUID
    private static final long serialVersionUID = 1080711331905991750L;
    
    private Long documentId;
    private Date createdDate;
    private User user;
    private String title;
    private String imageUrl;
    private String content;
    private Category category;
    
    public Document() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getDocumentId() {
        return documentId;
    }

    
    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    @Temporal(TemporalType.DATE)
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @ManyToOne
    @JoinColumn(name = "userId")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(length = 250, nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(length = 250)
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Lob
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @ManyToOne
    @JoinColumn(name = "categoryId")
    public Category getCategory() {
        return category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }
}