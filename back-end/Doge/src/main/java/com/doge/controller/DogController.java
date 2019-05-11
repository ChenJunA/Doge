package com.doge.controller;

import com.doge.dto.DogDTO;
import com.doge.entity.Dog;
import com.doge.entity.DogCollection;
import com.doge.entity.DogComment;
import com.doge.util.RespUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: chenjun
 * @Date: 2019/4/19 9:40
 */
@RestController
public class DogController extends BaseController {
    /**
     * 发布动物信息
     *
     * @param dog 动物信息
     * @return 状态信息
     */
    @ApiOperation("发布动物信息")
    @ApiImplicitParam(name = "dog", value = "动物信息", required = true, dataType = "Dog")
    @PostMapping("/dog")
    public RespUtil<Dog> insertDog(@RequestBody Dog dog) throws Exception{
        dogService.insertDog(dog);
        return RespUtil.success();
    }

    /**
     * 更新动物信息
     *
     * @param dog 动物信息
     * @return 状态信息
     */
    @ApiOperation("更新动物信息")
    @ApiImplicitParam(name = "dog", value = "动物信息", required = true, dataType = "Dog")
    @PutMapping("/updateDog")
    public RespUtil<Dog> updateDog(@RequestBody Dog dog) throws Exception{
        dogService.updateDog(dog);
        return RespUtil.success();
    }

    /**
     * 删除动物信息
     *
     * @param dogId 动物ID
     * @return 状态信息
     */
    @ApiOperation("删除动物信息")
    @ApiImplicitParam(name = "dogId", value = "动物ID", required = true, dataType = "Long")
    @DeleteMapping("/deleteDog/{dogId}")
    public RespUtil<List<Dog>> deleteDog(@PathVariable Long dogId) throws Exception{
        List<Dog> dogs = dogService.deleteDog(dogId);
        return RespUtil.success(dogs);
    }

    /**
     * 恢复动物信息
     *
     * @param dogId 动物ID
     * @return 状态信息
     */
    @ApiOperation("恢复动物信息")
    @ApiImplicitParam(name = "dogId", value = "动物ID", required = true, dataType = "Long")
    @DeleteMapping("/reCover/{dogId}")
    public RespUtil<List<Dog>> reCover(@PathVariable Long dogId) throws Exception{
        List<Dog> dogs = dogService.reCover(dogId);
        return RespUtil.success(dogs);
    }

    /**
     * 查询动物详细信息
     *
     * @param dogId 动物ID
     * @return 状态信息
     */
    @ApiOperation("查询动物详细信息")
    @ApiImplicitParam(name = "dogId", value = "动物ID", required = true, dataType = "Long")
    @GetMapping("/getDogById/{dogId}")
    public RespUtil<DogDTO> getDogById(@PathVariable Long dogId) throws Exception{
        DogDTO dogDTO = dogService.getDogById(dogId);
        return RespUtil.success(dogDTO);
    }

    /**
     * 查询所有动物信息
     *
     * @return 状态信息
     */
    @ApiOperation("查询所有动物信息")
    @GetMapping("/listAll")
    public RespUtil<List<Dog>> listAll() throws Exception{
        List<Dog> dogs = dogService.listAll();
        return RespUtil.success(dogs);
    }

    /**
     * 根据分类ID查询动物信息
     *
     * @param typeId 分类ID
     * @return 状态信息
     */
    @ApiOperation("根据分类ID查询动物信息")
    @ApiImplicitParam(name = "typeId", value = "分类ID", required = true, dataType = "Long")
    @GetMapping("/listByType/{typeId}")
    public RespUtil<List<Dog>> listByType(@PathVariable Long typeId) throws Exception{
        List<Dog> dogs = dogService.listByType(typeId);
        return RespUtil.success(dogs);
    }

    /**
     * 查询自己发布的动物信息
     *
     * @param fosterId 送养人ID
     * @return 状态信息
     */
    @ApiOperation("查询自己发布的动物信息")
    @ApiImplicitParam(name = "fosterId", value = "送养人ID", required = true, dataType = "Long")
    @GetMapping("/listDogsByFosterId")
    public RespUtil<List<Dog>> listDogsByFosterId(Long fosterId) throws Exception{
        List<Dog> dogs = dogService.listDogsByFosterId(fosterId);
        return RespUtil.success(dogs);
    }

    /**
     * 查询自己领养的动物信息
     *
     * @param adoptId 领养人ID
     * @return 状态信息
     */
    @ApiOperation("查询自己领养的动物信息")
    @ApiImplicitParam(name = "fosterId", value = "领养人ID", required = true, dataType = "Long")
    @GetMapping("/listDogsByAdoptId")
    public RespUtil<List<Dog>> listDogsByAdoptId(Long adoptId) throws Exception{
        List<Dog> dogs = dogService.listDogsByAdoptId(adoptId);
        return RespUtil.success(dogs);
    }

    /**
     * 查询自己收藏的动物信息
     *
     * @param collectionId 收藏人ID
     * @return 状态信息
     */
    @ApiOperation("查询自己收藏的动物信息")
    @ApiImplicitParam(name = "collectionId", value = "收藏人ID", required = true, dataType = "Long")
    @GetMapping("/listDogsByCollectionId")
    public RespUtil<List<Dog>> listDogsByCollectionId(Long collectionId) throws Exception{
        List<Dog> dogs = dogService.listDogsByCollectionId(collectionId);
        return RespUtil.success(dogs);
    }

    /**
     * 查询最新的动物ID
     *
     * @return 状态信息
     */
    @ApiOperation("查询最新的动物ID")
    @GetMapping("/latestDogId")
    public RespUtil<Long> latestDogId() throws Exception{
        Long dogId = dogService.latestDogId();
        return RespUtil.success(dogId);
    }

    /**
     * 发起领养
     *
     * @param map 请求参数
     * @return 状态信息
     */
    @ApiOperation("查询最新的动物ID")
    @ApiImplicitParam(name = "map", value = "请求参数", required = true, dataType = "Map")
    @PutMapping("/toAdopt")
    public RespUtil<DogDTO> toAdopt(@RequestBody Map<String,String> map) throws Exception{
        Long adoptId =Long.valueOf(map.get("adoptId"));
        Long dogId = Long.valueOf(map.get("dogId"));
        DogDTO dogDTO = dogService.toAdopt(dogId, adoptId);
        return RespUtil.success(dogDTO);
    }

    /**
     * 收藏动物
     *
     * @param dogCollection 收藏信息
     * @return 状态信息
     */
    @ApiOperation("收藏动物")
    @ApiImplicitParam(name = "dogCollection", value = "收藏信息", required = true, dataType = "DogCollection")
    @PostMapping("/toCollect")
    public RespUtil<Dog> toCollect(@RequestBody DogCollection dogCollection) throws Exception{
        dogService.toCollect(dogCollection);
        return RespUtil.success();
    }

    /**
     * 判断用户是否收藏该动物
     *
     * @param userId 用户ID
     * @param dogId 动物ID
     * @return 状态信息
     */
    @ApiOperation("判断用户是否收藏该动物")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "dogId", value = "动物ID", required = true, dataType = "Long")
    })
    @GetMapping("/isCollect")
    public RespUtil<List<DogCollection>> isCollect(Long userId, Long dogId) throws Exception{
         List<DogCollection> respDogCollections = dogService.isCollect(userId,dogId);
        return RespUtil.success(respDogCollections);
    }

    /**
     * 确认领养
     *
     * @param map 请求参数
     * @return 状态信息
     */
    @ApiOperation("确认领养")
    @ApiImplicitParam(name = "map", value = "请求参数", required = true, dataType = "Long")
    @PutMapping("/confirmAdopt")
    public RespUtil<DogDTO> confirmAdopt(@RequestBody Map<String,String> map) throws Exception{
        Long dogId = Long.valueOf(map.get("dogId"));
        DogDTO dogDTO = dogService.confirmAdopt(dogId);
        return RespUtil.success(dogDTO);
    }
}
