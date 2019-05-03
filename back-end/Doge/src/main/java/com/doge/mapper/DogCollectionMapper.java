package com.doge.mapper;

import com.doge.entity.DogCollection;
import com.doge.entity.DogCollectionExample;

import java.util.List;

public interface DogCollectionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DogCollection record);

    int insertSelective(DogCollection record);

    List<DogCollection> selectByExample(DogCollectionExample example);

    DogCollection selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DogCollection record);

    int updateByPrimaryKey(DogCollection record);
}