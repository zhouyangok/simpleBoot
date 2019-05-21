package com.crazyang.dao;

import com.crazyang.entity.OperationLog;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ClassName LogMapper
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/5/21 下午3:36.
 */

@Mapper
public interface LogMapper {

    @Insert("insert into operation_log (user_id,user_ip,user_action,create_time) values (#{userId},#{userIp},#{userAction},#{createTime})")
    int insertLog(OperationLog log);

    @Select("select * from operation_log")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "userIp", column = "user_ip"),
            @Result(property = "userAction", column = "user_action"),
            @Result(property = "createTime", column = "create_time"),
    })
    List<OperationLog> getList();
}
