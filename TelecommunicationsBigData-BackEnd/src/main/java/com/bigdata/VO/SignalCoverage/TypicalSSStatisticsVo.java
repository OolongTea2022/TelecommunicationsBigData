package com.bigdata.VO.SignalCoverage;

import lombok.Data;

@Data
public class TypicalSSStatisticsVo {
    private double rssi;
    private String landmark;
    private String networkType;
    private String networkName;
}
