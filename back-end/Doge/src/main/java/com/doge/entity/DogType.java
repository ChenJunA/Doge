package com.doge.entity;

import java.util.Date;

public class DogType {
    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private String typeName;

    private Integer typeNumber;

    private Boolean delete;

    public DogType(Long id, Date gmtCreate, Date gmtModified, String typeName, Integer typeNumber, Boolean delete) {
        this.id = id;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.typeName = typeName;
        this.typeNumber = typeNumber;
        this.delete = delete;
    }

    public DogType() {
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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public Integer getTypeNumber() {
        return typeNumber;
    }

    public void setTypeNumber(Integer typeNumber) {
        this.typeNumber = typeNumber;
    }

    public Boolean getIsDelete() {
        return delete;
    }

    public void setIsDelete(Boolean delete) {
        this.delete = delete;
    }
}