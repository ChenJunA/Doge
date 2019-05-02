package com.doge.mapper;

import com.doge.entity.Dog;
import com.doge.entity.DogExample;

import java.util.List;

public interface DogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Dog record);

    int insertSelective(Dog record);

    List<Dog> selectByExample(DogExample example);

    Dog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Dog record);

    int updateByPrimaryKey(Dog record);
}