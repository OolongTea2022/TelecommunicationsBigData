package com.bigdata.controller;

import com.bigdata.Result.Result;
import com.bigdata.VO.OrderVo;
import com.bigdata.entity.Order;
import com.bigdata.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;


    @GetMapping(value = "/getOrders",produces = MediaType.APPLICATION_JSON_VALUE)
    public Result<OrderVo> getOrdersList(){
        List<Order> orders = orderService.getOrders();
        List<Long> ids=new ArrayList<>();
        List<Long> totalAmounts=new ArrayList<>();

        for(Order o:orders){
            ids.add(o.getId());
            totalAmounts.add(o.getTotalAmount());
        }
        System.out.println(totalAmounts);
        OrderVo orderVo=new OrderVo();
        orderVo.setIds(ids);
        orderVo.setTotalAmounts(totalAmounts);
        System.out.println(orderVo);
        return Result.success(orderVo);
    }
}
