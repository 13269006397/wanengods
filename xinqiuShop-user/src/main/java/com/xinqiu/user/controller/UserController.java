package com.xinqiu.user.controller;

import com.xinqiu.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @RequestMapping("/get/{id}")
    public User get(@PathVariable("id") Integer id){
        log.info("获取用户方法被调用了");
        User user = new User();
        user.setUid(id);
        user.setUsername("颜文博");
        user.setTelephone("13269006397");
        user.setPassword("123456");
        log.info("获取用户方法调用结束,返回参数为："+user);
        return user;
    }
}