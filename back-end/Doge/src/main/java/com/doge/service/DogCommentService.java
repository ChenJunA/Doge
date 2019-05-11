package com.doge.service;

import com.doge.dto.DogCommentDTO;
import com.doge.entity.DogComment;

import java.util.List;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2019/5/3 20:05
 */
public interface DogCommentService {

    /**
     * 新增评论
     *
     * @param dogComment
     */
    void insertDogComment(DogComment dogComment) throws Exception;

    /**
     * 获取评论列表
     *
     * @param dogId
     */
    List<DogCommentDTO> listDogComment(Long dogId) throws Exception;

    /**
     * 获取所有评论列表
     */
    List<DogCommentDTO> listAllDogComment() throws Exception;

    /**
     * 删除动物评论
     */
    void deleteDogComment(Long dogCommentId) throws Exception;

    /**
     * 恢复动物评论
     */
    void reCoverDogComment(Long dogCommentId) throws Exception;

}
