package com.bigdata.dao;

import com.bigdata.model.entity.Order;
import java.util.List;

public interface OrderMapper {
    List<Order> getOrders();
}