package com.xinqiu.product.service;

import com.xinqiu.entity.Product;

public interface ProductService {

    Product getProductById(int id);

    Product add(Product product);

}
