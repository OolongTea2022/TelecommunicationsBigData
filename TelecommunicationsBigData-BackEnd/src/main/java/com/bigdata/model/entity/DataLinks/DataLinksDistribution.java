package com.bigdata.model.entity.DataLinks;

import lombok.Data;

@Data
public class DataLinksDistribution {
    private double userLat;
    private double userLon;
    private String networkName;
    private String mobileNetworkType;
}
