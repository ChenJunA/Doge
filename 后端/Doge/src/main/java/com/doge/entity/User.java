package com.doge.entity;

import java.util.Date;

public class User {
    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private String username;

    private String password;

    private String picture;

    private String avatar;

    private String sex;

    private String address;

    private String phoneNumber;

    private String biography;

    private Long followersNumber;

    private Long followingNumber;

    private Integer stars;

    private Boolean isBan;

    private String email;

    private Boolean isAcitve;

    public User(Long id, Date gmtCreate, Date gmtModified, String username, String password, String picture, String avatar, String sex, String address, String phoneNumber, String biography, Long followersNumber, Long followingNumber, Integer stars, Boolean isBan, String email, Boolean isAcitve) {
        this.id = id;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.username = username;
        this.password = password;
        this.picture = picture;
        this.avatar = avatar;
        this.sex = sex;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.biography = biography;
        this.followersNumber = followersNumber;
        this.followingNumber = followingNumber;
        this.stars = stars;
        this.isBan = isBan;
        this.email = email;
        this.isAcitve = isAcitve;
    }

    public User() {
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography == null ? null : biography.trim();
    }

    public Long getFollowersNumber() {
        return followersNumber;
    }

    public void setFollowersNumber(Long followersNumber) {
        this.followersNumber = followersNumber;
    }

    public Long getFollowingNumber() {
        return followingNumber;
    }

    public void setFollowingNumber(Long followingNumber) {
        this.followingNumber = followingNumber;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public Boolean getIsBan() {
        return isBan;
    }

    public void setIsBan(Boolean isBan) {
        this.isBan = isBan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Boolean getIsAcitve() {
        return isAcitve;
    }

    public void setIsAcitve(Boolean isAcitve) {
        this.isAcitve = isAcitve;
    }
}