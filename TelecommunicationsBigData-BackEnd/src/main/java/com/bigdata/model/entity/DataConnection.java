package com.bigdata.model.entity;

import lombok.Data;

@Data
public class DataConnection {
    private Long id;
    private Double userLat;
    private Double userLon;
    private String networkName;
    private String networkType;
    private String pingValue;
    private String mobileNetworkType;
    private Long timeIndexClient;
}