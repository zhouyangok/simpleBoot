package com.crazyang.service;

import com.crazyang.User.JwtUser;
import com.crazyang.User.User;
import com.crazyang.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserDetailsServiceImpl
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/5/17 上午9:38.
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.findByUsername(s);
        return new JwtUser(user);
    }
}
