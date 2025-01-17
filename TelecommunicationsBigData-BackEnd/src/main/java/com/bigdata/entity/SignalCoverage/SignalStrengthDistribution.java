package com.bigdata.entity.SignalCoverage;

import lombok.Data;

@Data
public class SignalStrengthDistribution {
    private long rssi;
    private String userLon;
    private String userLat;
    private String networkType;
}
