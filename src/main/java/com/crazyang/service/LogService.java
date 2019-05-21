package com.crazyang.service;

import com.crazyang.entity.OperationLog;

import java.util.List;

/**
 * @ClassName LogService
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/5/21 下午3:34.
 */

public interface LogService {

    /**
     * 插入日志
     * @param log
     * @return
     */
    int insertLog(OperationLog log);

    List<OperationLog> getList();
}
