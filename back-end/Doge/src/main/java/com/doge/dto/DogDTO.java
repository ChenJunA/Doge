package com.doge.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * @Description: DogDTO
 * @Author: chenjun
 * @Date: 2019/4/27 20:54
 */
public class DogDTO {
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date gmtCreate;

    private Date gmtModified;

    private String type;

    private Long foster;

    private Long adopt;

    private Date adoptTime;

    private Long state;

    private String dogName;

    private String sex;

    private Integer age;

    private String address;

    private String vaccine;

    private String dogDescribe;

    private List<String> pictures;

    private Boolean delete;

    public DogDTO(Long id, Date gmtCreate, Date gmtModified, String type, Long foster, Long adopt, Date adoptTime, Long state, String dogName, String sex, Integer age, String address, String vaccine, String dogDescribe, List<String> pictures, Boolean delete) {
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
        this.pictures = pictures;
        this.delete = delete;
    }

    public DogDTO() {

    }

    public Long getId() {
        return id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public String getType() {
        return type;
    }

    public Long getFoster() {
        return foster;
    }

    public Long getAdopt() {
        return adopt;
    }

    public Date getAdoptTime() {
        return adoptTime;
    }

    public Long getState() {
        return state;
    }

    public String getDogName() {
        return dogName;
    }

    public String getSex() {
        return sex;
    }

    public Integer getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getVaccine() {
        return vaccine;
    }

    public String getDogDescribe() {
        return dogDescribe;
    }

    public List<String> getPictures() {
        return pictures;
    }

    public Boolean getDelete() {
        return delete;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFoster(Long foster) {
        this.foster = foster;
    }

    public void setAdopt(Long adopt) {
        this.adopt = adopt;
    }

    public void setAdoptTime(Date adoptTime) {
        this.adoptTime = adoptTime;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public void setDogDescribe(String dogDescribe) {
        this.dogDescribe = dogDescribe;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }
}
