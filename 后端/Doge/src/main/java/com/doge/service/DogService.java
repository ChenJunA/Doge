package com.doge.service;

import com.doge.entity.Dog;

import java.util.List;

/**
 * @Description: 动物相关操作接口
 * @Author: chenjun
 * @Date: 2019/4/19 9:41
 */
public interface DogService {
    /**
     * 发布动物
     *
     * @param dog
     */
    void insertDog(Dog dog) throws Exception;

    /**
     * 更新动物信息
     *
     * @param dog
     */
    void updateDog(Dog dog) throws Exception;

    /**
     * 删除动物信息
     *
     * @param dogId
     */
    void deleteDog(Long dogId) throws Exception;

    /**
     * 根据ID获取动物信息
     *
     * @param dogId
     */
    Dog findById(Long dogId) throws Exception;

    /**
     * 获取所有动物信息
     */
    List<Dog> listAll() throws Exception;

    /**
     * 根据分类ID获取动物信息
     *
     * @param typeId
     */
    List<Dog> listByType(Long typeId) throws Exception;
}
