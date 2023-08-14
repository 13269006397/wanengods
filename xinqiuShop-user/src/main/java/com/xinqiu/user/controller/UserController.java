package com.xinqiu.user.controller;

import com.xinqiu.entity.User;
import com.xinqiu.user.service.UserService;
import com.xinqiu.user.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/get/{id}")
    public User get(@PathVariable("id") Integer id){
        log.info("获取用户方法被调用了");
        User resultUser = userService.getUserById(id);
        log.info("获取用户方法调用结束,返回参数为："+resultUser);
        return resultUser;
    }

    @RequestMapping("/add/order/{id}")
    public User add(@PathVariable("id") Integer id){
        log.info("用户新增订单和商品方法被调用");
        User user = userService.addOrderAndProduct(id);
        log.info("获取用户方法调用结束,返回参数为："+user);
        return user;
    }




}