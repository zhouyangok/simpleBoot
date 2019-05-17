package com.crazyang.dao;

import com.crazyang.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @ClassName UserDao
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/5/17 上午9:31.
 */


public interface UserDao extends CrudRepository <User, Integer>  {
    User findByUsername(String name);
}
