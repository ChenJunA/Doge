package com.doge.controller;

import com.doge.entity.Dog;
import com.doge.util.RespUtil;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        dog.setFoster(new Long(1));
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
    public RespUtil<Dog> deleteDog(@PathVariable Long dogId) throws Exception{
        dogService.deleteDog(dogId);
        return RespUtil.success();
    }

    /**
     * 查询所有动物信息
     *
     * @return 状态信息
     */
    @ApiOperation("查询所有动物信息")
    @GetMapping("/listAll")
    public RespUtil<Dog> listAll() throws Exception{
        List<Dog> dogs = dogService.listAll();
        return RespUtil.success(dogs);
    }

    /**
     * 根据分类ID查询动物信息
     *
     * @return 状态信息
     */
    @ApiOperation("根据分类ID查询动物信息")
    @GetMapping("/listByType/{typeId}")
    public RespUtil<Dog> listByType(@PathVariable Long typeId) throws Exception{
        List<Dog> dogs = dogService.listByType(typeId);
        return RespUtil.success(dogs);
    }
}
