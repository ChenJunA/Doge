package com.doge.service.impl;

import com.doge.entity.Log;
import com.doge.entity.LogExample;
import com.doge.mapper.LogMapper;
import com.doge.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SystemServiceImpl implements SystemService {
    @Autowired
    LogMapper logMapper;

    @Override
    public void insertLog(Log log) throws Exception {
        logMapper.insertSelective(log);
    }

    @Override
    public int countLog() throws Exception {
        LogExample logExample = new LogExample();
        //查询全部，返回集合大小
        return logMapper.selectByExample(logExample).size();
    }

    @Override
    public List<Log> listAllLog() throws Exception {
        LogExample logExample = new LogExample();
        //查询全部，返回集合
        return logMapper.selectByExample(logExample);
    }
}
