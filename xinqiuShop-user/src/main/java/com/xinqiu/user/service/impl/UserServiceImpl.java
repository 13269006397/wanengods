package com.xinqiu.user.service.impl;

import com.xinqiu.entity.User;
import com.xinqiu.user.mapper.UserMapper;
import com.xinqiu.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(int id) {
        return userMapper.selectById(id);
    }
}
