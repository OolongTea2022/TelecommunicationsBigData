package com.bigdata.dto.nwQuality;

import lombok.Data;

@Data
public class QualityStatisticsDTO {
    private String nwType;
    private String nwOperator;
    private long startDate;
    private long endDate;
}
