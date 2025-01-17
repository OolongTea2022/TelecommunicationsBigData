package com.bigdata.dto.SignalStrength;

import lombok.Data;

import java.util.Date;

@Data
public class SSTrackingDTO {
    private String landmark;
    private String networkType;
    private long startDate;
    private long endDate;
    private String timeGranularity;
}
