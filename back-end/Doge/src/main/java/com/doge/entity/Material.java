package com.doge.entity;

import java.util.Date;

public class Material {
    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private String material;

    private String materialName;

    private String materialDescribe;

    private Integer downloadTimes;

    private Long userId;

    private Boolean isDelete;

    public Material(Long id, Date gmtCreate, Date gmtModified, String material, String materialName, String materialDescribe, Integer downloadTimes, Long userId, Boolean isDelete) {
        this.id = id;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.material = material;
        this.materialName = materialName;
        this.materialDescribe = materialDescribe;
        this.downloadTimes = downloadTimes;
        this.userId = userId;
        this.isDelete = isDelete;
    }

    public Material() {
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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material == null ? null : material.trim();
    }

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName == null ? null : materialName.trim();
    }

    public String getMaterialDescribe() {
        return materialDescribe;
    }

    public void setMaterialDescribe(String materialDescribe) {
        this.materialDescribe = materialDescribe == null ? null : materialDescribe.trim();
    }

    public Integer getDownloadTimes() {
        return downloadTimes;
    }

    public void setDownloadTimes(Integer downloadTimes) {
        this.downloadTimes = downloadTimes;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
}