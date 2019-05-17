package com.crazyang.controller;

import com.crazyang.User.User;
import com.crazyang.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @ClassName AuthController
 * @Description: TODO
 * @Author zhouyang
 * @Date 2019/5/17 上午9:57.
 */

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/register")
    public String registerUser(@RequestBody Map<String,String> registerUser){
        User user = new User();
        user.setUsername(registerUser.get("username"));
        user.setPassword(bCryptPasswordEncoder.encode(registerUser.get("password")));
        user.setRole("ROLE_USER");
        User save = userDao.save(user);
        return save.toString();
    }

    @GetMapping("/test")
    public String testDemo(){
        return "hello world";
    }
}
