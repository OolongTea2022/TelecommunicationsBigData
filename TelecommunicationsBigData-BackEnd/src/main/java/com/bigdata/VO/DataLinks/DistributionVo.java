package com.bigdata.VO.DataLinks;

import lombok.Data;

@Data
public class DistributionVo {
    private double userLat;
    private double userLon;
    private String networkName;
    private String mobileNetworkType;
}
