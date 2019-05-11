package com.doge.service;

import com.doge.dto.DogDTO;
import com.doge.entity.Dog;
import com.doge.entity.DogCollection;
import com.doge.entity.DogComment;
import com.doge.entity.User;

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
    List<Dog> deleteDog(Long dogId) throws Exception;

    /**
     * 恢复动物信息
     *
     * @param dogId
     */
    List<Dog> reCover(Long dogId) throws Exception;


    /**
     * 根据ID获取动物信息
     *
     * @param dogId
     */
    DogDTO getDogById(Long dogId) throws Exception;

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

    /**
     * 根据送养人ID获取动物信息
     *
     * @param fosterId
     */
    List<Dog> listDogsByFosterId(Long fosterId) throws Exception;

    /**
     * 根据领养人ID获取动物信息
     *
     * @param adoptId
     */
    List<Dog> listDogsByAdoptId(Long adoptId) throws Exception;

    /**
     * 根据收藏人ID获取动物信息
     *
     * @param collectionId
     */
    List<Dog> listDogsByCollectionId(Long collectionId) throws Exception;

    /**
     * 获取最新动物ID
     */
    Long latestDogId() throws Exception;

    /**
     * 发起领养
     *
     * @param dogId
     * @param adoptId
     */
    DogDTO toAdopt(Long dogId, Long adoptId) throws Exception;

    /**
     * 收藏动物
     *
     * @param dogCollection
     */
    void toCollect(DogCollection dogCollection) throws Exception;

    /**
     * 判断用户是否收藏该动物
     *
     * @param userId
     * @param dogId
     */
    List<DogCollection> isCollect(Long userId, Long dogId) throws Exception;

    /**
     * 确认领养
     *
     * @param dogId
     */
    DogDTO confirmAdopt(Long dogId) throws Exception;
}
