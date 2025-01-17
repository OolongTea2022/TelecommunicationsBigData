package com.bigdata.entity.PopularApp;

import lombok.Data;

@Data
public class PopularAppTrafficDistribution {
    private double heat;
    private String packageName;
    private String appName;
}
