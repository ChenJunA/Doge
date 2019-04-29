package com.doge.mapper;

import com.doge.entity.PictureCategory;
import com.doge.entity.PictureCategoryExample;

import java.util.List;

public interface PictureCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(PictureCategory record);

    int insertSelective(PictureCategory record);

    List<PictureCategory> selectByExample(PictureCategoryExample example);

    PictureCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PictureCategory record);

    int updateByPrimaryKey(PictureCategory record);
}