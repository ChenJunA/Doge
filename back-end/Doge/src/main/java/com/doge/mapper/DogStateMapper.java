package com.doge.mapper;

import com.doge.entity.DogState;
import com.doge.entity.DogStateExample;

import java.util.List;

public interface DogStateMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DogState record);

    int insertSelective(DogState record);

    List<DogState> selectByExample(DogStateExample example);

    DogState selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DogState record);

    int updateByPrimaryKey(DogState record);
}