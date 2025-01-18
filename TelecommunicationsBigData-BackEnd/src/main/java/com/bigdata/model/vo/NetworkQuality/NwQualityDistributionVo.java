package com.bigdata.model.vo.NetworkQuality;

import lombok.Data;

@Data
public class NwQualityDistributionVo {
    private double speed;
    private long userLat;
    private long userLon;
}
