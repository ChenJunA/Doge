package com.doge.mapper;

import com.doge.entity.Picture;
import com.doge.entity.PictureExample;

import java.util.List;

public interface PictureMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Picture record);

    int insertSelective(Picture record);

    List<Picture> selectByExample(PictureExample example);

    Picture selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Picture record);

    int updateByPrimaryKey(Picture record);
}