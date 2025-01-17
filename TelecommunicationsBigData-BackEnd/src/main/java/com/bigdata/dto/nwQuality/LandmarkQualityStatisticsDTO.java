package com.bigdata.dto.nwQuality;

import lombok.Data;

@Data
public class LandmarkQualityStatisticsDTO {
    private String speedType;
    private String nwType;
    private String nwOperator;
    private long startDate;
    private long endDate;
}
