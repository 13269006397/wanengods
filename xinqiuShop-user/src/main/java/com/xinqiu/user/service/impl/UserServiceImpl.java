package com.xinqiu.user.service.impl;

import com.xinqiu.entity.Product;
import com.xinqiu.entity.User;
import com.xinqiu.user.controller.UserController;
import com.xinqiu.user.mapper.UserMapper;
import com.xinqiu.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User getUserById(int id) {
        return userMapper.selectById(id);
    }


    @Override
    public User addOrderAndProduct(int id) {
        // 查询user信息
        User user = userMapper.selectById(id);
        // 插入商品信息
        Product product = new Product();
        product.setPid(new Random().nextInt(100000));
        product.setPname("美人鱼");
        product.setPprice(28.5);
        product.setStock(5);

        Product resultProduct = restTemplate.postForObject("http://localhost:8082/product/add", product, Product.class);
        log.info("新增成功了一个商品：" +  resultProduct.getPname());

        return user;
    }
}
