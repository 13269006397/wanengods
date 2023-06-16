package com.xinqiu.order.controller;

import com.xinqiu.entity.Order;
import com.xinqiu.entity.Product;
import com.xinqiu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/get/{uid}/{pid}")
    public Order get(@PathVariable("uid") Integer uid,
                     @PathVariable("pid")  Integer pid){
        /*
        要在订单微服务中调用 用户微服务、商品微服务。 也就意味这跨项目调用
         */
        //通过restTemplate调用用户/商品微服务
        User u = restTemplate.getForObject("http://localhost:8081/user/get/" + uid, User.class);
        Product p = restTemplate.getForObject("http://localhost:8082/product/get/" + pid, Product.class);
        Order order = new Order();
        order.setUsername(u.getUsername());
        order.setUid(u.getUid());
        order.setPprice(p.getPprice());
        order.setPname(p.getPname());
        order.setPid(p.getPid());
        order.setOid(System.currentTimeMillis());//订单号随机生成
        order.setNumber(p.getStock());//数量，全包了
        return order;
    }
}
