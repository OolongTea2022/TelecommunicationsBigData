package com.bigdata.model.entity;

import lombok.Data;

@Data
public class SignalStrength {
    private Long id;
    private String userLon;
    private String userLat;
    private String networkName;
    private Long rssi;
    private String networkType;
    private Long timeIndex;
    private String landmark;
}