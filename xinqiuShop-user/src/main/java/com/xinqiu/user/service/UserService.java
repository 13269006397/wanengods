package com.xinqiu.user.service;

import com.xinqiu.entity.User;

public interface UserService {

    User getUserById(int id);

    User addOrderAndProduct(int id);


}
