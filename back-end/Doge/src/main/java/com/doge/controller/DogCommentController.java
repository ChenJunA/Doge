package com.doge.controller;

import com.doge.dto.DogCommentDTO;
import com.doge.entity.DogComment;
import com.doge.util.RespUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2019/5/3 20:04
 */
@RestController
public class DogCommentController extends BaseController{

    /**
     * 新增评论
     *
     * @param dogComment 评论信息
     * @return 状态信息
     */
    @ApiOperation("获取评论列表")
    @ApiImplicitParam(name = "dogComment", value = "评论信息", required = true, dataType = "DogComment")
    @PostMapping("/insertDogComment")
    public RespUtil<DogComment> insertDogComment(@RequestBody DogComment dogComment) throws Exception{
        dogCommentService.insertDogComment(dogComment);
        return RespUtil.success();
    }



    /**
     * 获取该动物评论列表
     *
     * @param dogId 动物ID
     * @return 状态信息
     */
    @ApiOperation("获取该动物评论列表")
    @ApiImplicitParam(name = "dogId", value = "动物ID", required = true, dataType = "Long")
    @GetMapping("/listDogComment")
    public RespUtil<List<DogCommentDTO>> listDogComment(Long dogId) throws Exception{
        List<DogCommentDTO> dogComments = dogCommentService.listDogComment(dogId);
        return RespUtil.success(dogComments);
    }

    /**
     * 获取所有评论列表
     *
     * @return 状态信息
     */
    @ApiOperation("获取所有评论列表")
    @GetMapping("/listAllDogComment")
    public RespUtil<List<DogCommentDTO>> listAllDogComment() throws Exception{
        List<DogCommentDTO> dogComments = dogCommentService.listAllDogComment();
        return RespUtil.success(dogComments);
    }

    /**
     * 删除动物评论
     *
     * @return 状态信息
     */
    @ApiOperation("删除动物评论")
    @DeleteMapping("/deleteDogComment/{dogCommentId}")
    public RespUtil<DogComment> deleteDogComment(@PathVariable Long dogCommentId) throws Exception{
        dogCommentService.deleteDogComment(dogCommentId);
        return RespUtil.success();
    }

    /**
     * 恢复动物评论
     *
     * @return 状态信息
     */
    @ApiOperation("恢复动物评论")
    @DeleteMapping("/reCoverDogComment/{dogCommentId}")
    public RespUtil<DogComment> reCoverDogComment(@PathVariable Long dogCommentId) throws Exception{
        dogCommentService.reCoverDogComment(dogCommentId);
        return RespUtil.success();
    }
}
