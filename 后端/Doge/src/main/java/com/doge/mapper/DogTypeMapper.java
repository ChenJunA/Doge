package com.doge.mapper;

import com.doge.entity.DogType;
import com.doge.entity.DogTypeExample;

import java.util.List;

public interface DogTypeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DogType record);

    int insertSelective(DogType record);

    List<DogType> selectByExample(DogTypeExample example);

    DogType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DogType record);

    int updateByPrimaryKey(DogType record);
}