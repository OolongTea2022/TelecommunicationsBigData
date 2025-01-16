package com.bigdata.service.impl;

import com.bigdata.dao.OrderMapper;
import com.bigdata.entity.Order;
import com.bigdata.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> getOrders() {

        return this.orderMapper.getOrders();
    }
}
