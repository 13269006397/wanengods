package com.xinqiu.product.service.impl;

import com.xinqiu.entity.Product;
import com.xinqiu.product.mapper.ProductMapper;
import com.xinqiu.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product getProductById(int id) {
        return productMapper.selectById(id);
    }
}
