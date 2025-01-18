package com.bigdata.dto.nwQuality;

import lombok.Data;

@Data
public class DistributionDTO {
    private String nwType;
    private String nwOperator;
    private String speedType;
    private long startDate;
    private long endDate;
}
