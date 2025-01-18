package com.bigdata.vo.SignalCoverage;

import lombok.Data;

@Data
public class SignalStrengthDistributionVo {
    private long rssi;
    private String userLon;
    private String userLat;
    private String networkType;
}
