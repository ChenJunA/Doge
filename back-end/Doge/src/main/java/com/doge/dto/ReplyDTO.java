package com.doge.dto;

import java.util.Date;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2019/5/5 21:44
 */
public class ReplyDTO {
    private Long id;

    private Date gmtCreate;

    private Date gmtModified;

    private Long userId;

    private Long articleId;

    private Long parentId;

    private Long replyId;

    private String content;

    private Boolean delete;

    private String username;

    private String biography;

    private String avatar;

    private Integer replyNum;

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

    public Long getArticleId() {
        return articleId;
    }

    public Long getParentId() {
        return parentId;
    }

    public Long getReplyId() {
        return replyId;
    }

    public String getContent() {
        return content;
    }

    public Boolean getDelete() {
        return delete;
    }

    public String getUsername() {
        return username;
    }

    public String getBiography() {
        return biography;
    }

    public String getAvatar() {
        return avatar;
    }

    public Integer getReplyNum() {
        return replyNum;
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

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setReplyNum(Integer replyNum) {
        this.replyNum = replyNum;
    }
}
