package com.doge.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Dog {
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date gmtCreate;

    private Date gmtModified;

    private Long type;

    private Long foster;

    private Long adopt;

    private Date adoptTime;

    private Long state;

    private String dogName;

    private String sex;

    private Integer age;

    private String address;

    private Boolean vaccine;

    private String dogDescribe;

    private String picture;

    private Boolean delete;

    public Dog(Long id, Date gmtCreate, Date gmtModified, Long type, Long foster, Long adopt, Date adoptTime, Long state, String dogName, String sex, Integer age, String address, Boolean vaccine, String dogDescribe, String picture, Boolean delete) {
        this.id = id;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.type = type;
        this.foster = foster;
        this.adopt = adopt;
        this.adoptTime = adoptTime;
        this.state = state;
        this.dogName = dogName;
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.vaccine = vaccine;
        this.dogDescribe = dogDescribe;
        this.picture = picture;
        this.delete = delete;
    }

    public Dog() {
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

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Long getFoster() {
        return foster;
    }

    public void setFoster(Long foster) {
        this.foster = foster;
    }

    public Long getAdopt() {
        return adopt;
    }

    public void setAdopt(Long adopt) {
        this.adopt = adopt;
    }

    public Date getAdoptTime() {
        return adoptTime;
    }

    public void setAdoptTime(Date adoptTime) {
        this.adoptTime = adoptTime;
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName == null ? null : dogName.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Boolean getIsVaccine() {
        return vaccine;
    }

    public void setIsVaccine(Boolean vaccine) {
        this.vaccine = vaccine;
    }

    public String getDogDescribe() {
        return dogDescribe;
    }

    public void setDogDescribe(String dogDescribe) {
        this.dogDescribe = dogDescribe == null ? null : dogDescribe.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Boolean getIsDelete() {
        return delete;
    }

    public void setIsDelete(Boolean delete) {
        this.delete = delete;
    }
}