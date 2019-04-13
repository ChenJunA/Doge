package com.doge.mapper;

import com.doge.entity.Log;
import com.doge.entity.LogExample;

import java.util.List;

public interface LogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Log record);

    int insertSelective(Log record);

    List<Log> selectByExample(LogExample example);

    Log selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Log record);

    int updateByPrimaryKey(Log record);
}