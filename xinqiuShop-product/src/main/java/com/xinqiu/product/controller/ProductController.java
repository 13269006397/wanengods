package com.xinqiu.product.controller;

import com.xinqiu.entity.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    @RequestMapping("/get/{pid}")
    public Product get(@PathVariable("pid") Integer pid){
        log.info("调用根据id获取商品详情方法--->");
        Product product = new Product();
        product.setPid(pid);
        product.setPname("西游记");
        product.setStock(20);
        product.setPprice(35.1);
        log.info("调用根据id获取商品详情方法结束，返回值为："+product);
        return product;
    }
}
