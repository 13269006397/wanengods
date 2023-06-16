package com.xinqiu.order.service;

import com.xinqiu.entity.Order;

public interface OrderService {

    Order getOrderById(int id);

    int insertOrder(Order order);

}
