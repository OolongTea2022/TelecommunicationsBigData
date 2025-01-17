package com.bigdata.controller;

import com.bigdata.model.entity.Order;
import com.bigdata.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

//@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/getOrders")
    @ResponseBody
    public List<Order> getOrdersList() {
        return orderService.getOrders();
    }
}