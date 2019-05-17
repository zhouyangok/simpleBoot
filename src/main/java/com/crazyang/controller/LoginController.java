package com.crazyang.controller;

import com.crazyang.service.UserDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName LoginController
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/5/17 上午11:23.
 */

@Controller
public class LoginController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    private Logger logger = LoggerFactory.getLogger(LoginController.class);


    @RequestMapping("/")
    public String login() {
        logger.info("请求进来");
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String userName, @RequestParam String password) {
        UserDetails jwtUser =  userDetailsService.loadUserByUsername(userName);
        logger.info("userInfo+{}"+jwtUser);
        //登录操作
        return "ok";
    }
}
