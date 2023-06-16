package com.xinqiu.user.controller;

import com.xinqiu.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/get/{id}")
    public User get(@PathVariable("id") Integer id){

        User user = new User();
        user.setUid(id);
        user.setUsername("颜文博");
        user.setTelephone("13269006397");
        user.setPassword("123456");
        return user;
    }
}