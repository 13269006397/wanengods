package com.xinqiu.order.controller;

import com.xinqiu.entity.Order;
import com.xinqiu.entity.Product;
import com.xinqiu.entity.User;
import com.xinqiu.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@RestController
@RequestMapping("/order")
public class OrderController {
    private static final Logger log = LoggerFactory.getLogger(OrderController.class);
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private OrderService orderService;

    @RequestMapping("/get/{uid}/{pid}")
    public Order get(@PathVariable("uid") Integer uid,
                     @PathVariable("pid")  Integer pid){
        log.info("<--- 调用订单生成方法 --->");
        // 要在订单微服务中调用 用户微服务、商品微服务。 也就意味这跨项目调用
        // 通过restTemplate调用用户/商品微服务
        log.info("准备调用根据id查询用户方法 --->");
        User u = restTemplate.getForObject("http://localhost:8081/user/get/" + uid, User.class);
        log.info("调用用户查询结束，查询用户id:"+uid + "返回结果为"+u);
        log.info("准备调用根据id查询商品方法 --->");
        Product p = restTemplate.getForObject("http://localhost:8082/product/get/" + pid, Product.class);
        log.info("调用商品查询结束，查询商品id:"+pid + "返回结果为"+p);

        // 组装订单
        Order order = new Order();
        order.setUname(u.getUsername());
        order.setUid(u.getUid());
        order.setPprice(p.getPprice());
        order.setPname(p.getPname());
        order.setPid(p.getPid());
        order.setOid(new Random().nextInt(1000000000));//订单号随机生成
        order.setPnumber(p.getStock());
        log.info("准备插入订单库，数据为："+order);

        // 保存订单
        int i = orderService.insertOrder(order);
        log.info("插入订单库完成，返回值为："+i);

        log.info("<--- 调用订单生成方法结束 --->");
        return order;
    }
}
