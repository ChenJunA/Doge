package com.doge.entity;

import java.util.Date;

public class Picture {
    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private Long category;

    private String picture;

    private Long xId;

    private Boolean isDelete;

    public Picture(Long id, Date gmtCreate, Date gmtModified, Long category, String picture, Long xId, Boolean isDelete) {
        this.id = id;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.category = category;
        this.picture = picture;
        this.xId = xId;
        this.isDelete = isDelete;
    }

    public Picture() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Long getCategory() {
        return category;
    }

    public void setCategory(Long category) {
        this.category = category;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Long getxId() {
        return xId;
    }

    public void setxId(Long xId) {
        this.xId = xId;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
}