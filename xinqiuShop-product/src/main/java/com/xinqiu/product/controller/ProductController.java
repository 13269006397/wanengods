package com.xinqiu.product.controller;

import com.xinqiu.entity.Product;
import com.xinqiu.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    @RequestMapping("/get/{pid}")
    public Product get(@PathVariable("pid") Integer pid){
        log.info("调用根据id获取商品详情方法--->");
        Product resultProduct = productService.getProductById(pid);
        log.info("调用根据id获取商品详情方法结束，返回值为："+resultProduct);
        return resultProduct;
    }
}
