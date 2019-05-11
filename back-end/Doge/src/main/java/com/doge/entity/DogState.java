package com.doge.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class DogState {
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date gmtCreate;

    private Date gmtModified;

    private String stateName;

    private Integer stateNumber;

    private Boolean delete;

    public DogState(Long id, Date gmtCreate, Date gmtModified, String stateName, Integer stateNumber, Boolean delete) {
        this.id = id;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.stateName = stateName;
        this.stateNumber = stateNumber;
        this.delete = delete;
    }

    public DogState() {
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

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName == null ? null : stateName.trim();
    }

    public Integer getStateNumber() {
        return stateNumber;
    }

    public void setStateNumber(Integer stateNumber) {
        this.stateNumber = stateNumber;
    }

    public Boolean getIsDelete() {
        return delete;
    }

    public void setIsDelete(Boolean delete) {
        this.delete = delete;
    }
}