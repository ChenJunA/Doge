package com.doge.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Description: 动物评论DTO
 * @Author: chenjun
 * @Date: 2019/5/3 20:42
 */
public class DogCommentDTO {
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date gmtCreate;

    private Date gmtModified;

    private String username;

    private Long dogId;

    private String content;

    private Boolean isDelete;

    public DogCommentDTO() {
    }

    public DogCommentDTO(Long id, Date gmtCreate, Date gmtModified, String username, Long dogId, String content, Boolean isDelete) {
        this.id = id;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.username = username;
        this.dogId = dogId;
        this.content = content;
        this.isDelete = isDelete;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDogId(Long dogId) {
        this.dogId = dogId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
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

    public String getUsername() {
        return username;
    }

    public Long getDogId() {
        return dogId;
    }

    public String getContent() {
        return content;
    }

    public Boolean getDelete() {
        return isDelete;
    }
}
