package com.bigdata.dto.nwQuality;

import lombok.Data;

@Data
public class NwTrackingDTO {
    private String nwOperator;
    private String nwType;
    private String landmark;
    private long startDate;
    private long endDate;
    private String speedType;
    private String timeGranularity;

}
