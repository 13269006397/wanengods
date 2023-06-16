package com.xinqiu.order.service.impl;

import com.xinqiu.entity.Order;
import com.xinqiu.order.mapper.OrderMapper;
import com.xinqiu.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order getOrderById(int id) {
        return orderMapper.selectById(id);

    }

    @Override
    public int insertOrder(Order order) {
        return orderMapper.insert(order);
    }
}
