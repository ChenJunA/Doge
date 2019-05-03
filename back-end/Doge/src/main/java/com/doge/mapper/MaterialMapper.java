package com.doge.mapper;

import com.doge.entity.Material;
import com.doge.entity.MaterialExample;

import java.util.List;

public interface MaterialMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Material record);

    int insertSelective(Material record);

    List<Material> selectByExample(MaterialExample example);

    Material selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Material record);

    int updateByPrimaryKey(Material record);
}