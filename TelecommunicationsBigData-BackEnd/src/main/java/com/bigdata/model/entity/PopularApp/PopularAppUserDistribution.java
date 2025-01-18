package com.bigdata.model.entity.PopularApp;

import lombok.Data;

@Data
public class PopularAppUserDistribution {
    private String userLat;
    private String userLon;
    private double heat;
}
