package com.bigdata.dto.PopularApp;
import lombok.Data;
@Data
public class TrafficRankDTO {
    private double heat;
    private String nwOperator;
    private long startDate;
    private long endDate;
}
