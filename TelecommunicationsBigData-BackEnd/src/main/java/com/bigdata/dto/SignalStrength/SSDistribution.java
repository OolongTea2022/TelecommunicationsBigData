package com.bigdata.dto.SignalStrength;

import lombok.Data;

@Data
public class SSDistribution {
    private String nwOperator;
    private String nwType;
    private long startDate;
    private long endDate;
}
