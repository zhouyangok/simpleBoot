package com.crazyang.service.impl;

import com.crazyang.dao.LogMapper;
import com.crazyang.entity.OperationLog;
import com.crazyang.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName LogServiceImpl
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/5/21 下午3:35.
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    public int insertLog(OperationLog log) {
        return logMapper.insertLog(log);
    }

    @Override
    public List<OperationLog> getList() {
        return logMapper.getList();
    }
}
