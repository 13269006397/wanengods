package com.xinqiu.product.controller;

import com.xinqiu.entity.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @RequestMapping("/get/{pid}")
    public Product get(@PathVariable("pid") Integer pid){
        Product product = new Product();
        product.setPid(pid);
        product.setPname("西游记");
        product.setStock(20);
        product.setPprice(35.1);
        return product;
    }
}
