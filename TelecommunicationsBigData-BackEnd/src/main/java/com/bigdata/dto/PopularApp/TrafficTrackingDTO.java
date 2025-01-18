package com.bigdata.dto.PopularApp;
import lombok.Data;
@Data
public class TrafficTrackingDTO {
    private double heat;
    private String nwOperator;
    private String nwType;
    private String appName;
    private String timeGranularity;
    private long startDate;
    private long endDate;
}
