package com.doge.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2019/5/4 23:50
 */
public class ArticleDTO {
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date gmtCreate;

    private Date gmtModified;

    private Long userId;

    private String username;

    private String title;

    private String content;

    private Long replyNum;

    private Long viewNum;

    private String picture;

    private Boolean delete;

    public Long getId() {
        return id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Long getReplyNum() {
        return replyNum;
    }

    public Long getViewNum() {
        return viewNum;
    }

    public String getPicture() {
        return picture;
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

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setReplyNum(Long replyNum) {
        this.replyNum = replyNum;
    }

    public void setViewNum(Long viewNum) {
        this.viewNum = viewNum;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }
}
