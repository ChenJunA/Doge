package com.doge.mapper;

import com.doge.entity.DogComment;
import com.doge.entity.DogCommentExample;

import java.util.List;

public interface DogCommentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DogComment record);

    int insertSelective(DogComment record);

    List<DogComment> selectByExample(DogCommentExample example);

    DogComment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DogComment record);

    int updateByPrimaryKey(DogComment record);
}