package com.bigdata.dto.DataLinks;

import lombok.Data;

@Data
public class DistributionDTO {
    private double userLat;
    private double userLon;
    private String networkName;
    private String mobileNetworkType;
    private long startDate;
    private long endDate;
}
