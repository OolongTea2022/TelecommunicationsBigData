package com.bigdata.dao;

import com.bigdata.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

@Mapper
public interface OrderMapper {

    List<Order> getOrders();
}
