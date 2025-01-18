package com.bigdata.model.dto.nwQuality;

import lombok.Data;

@Data
public class DistributionDTO {
    private String nwType;
    private String nwOperator;
    private String speedType;
    private long startDate;
    private long endDate;
    private String llat;
    private String rlat;
    private String ulon;
    private String dlon;
}
