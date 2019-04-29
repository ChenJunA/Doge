package com.doge.entity;

import java.util.Date;

public class PictureCategory {
    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private String pictureCategoryName;

    private Integer pictureCategoryNumber;

    private Boolean delete;

    public PictureCategory(Long id, Date gmtCreate, Date gmtModified, String pictureCategoryName, Integer pictureCategoryNumber, Boolean delete) {
        this.id = id;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.pictureCategoryName = pictureCategoryName;
        this.pictureCategoryNumber = pictureCategoryNumber;
        this.delete = delete;
    }

    public PictureCategory() {
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

    public String getPictureCategoryName() {
        return pictureCategoryName;
    }

    public void setPictureCategoryName(String pictureCategoryName) {
        this.pictureCategoryName = pictureCategoryName == null ? null : pictureCategoryName.trim();
    }

    public Integer getPictureCategoryNumber() {
        return pictureCategoryNumber;
    }

    public void setPictureCategoryNumber(Integer pictureCategoryNumber) {
        this.pictureCategoryNumber = pictureCategoryNumber;
    }

    public Boolean getIsDelete() {
        return delete;
    }

    public void setIsDelete(Boolean delete) {
        this.delete = delete;
    }
}