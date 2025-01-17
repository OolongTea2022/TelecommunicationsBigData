package com.bigdata.model.entity.PopularApp;

import lombok.Data;

@Data
public class PopularAppDistribution {
    private double heat;
    private String packageName;
    private String appName;
}
