package com.bigdata.model.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
public class Order {
    private Long id;
    private Long totalAmount;
    private Date createTime;

}