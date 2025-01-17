package com.bigdata.entity.SignalCoverage;

import lombok.Data;

@Data
public class TypicalSignalStrengthStatistics {
    private long rssi;
    private String landmark;
    private String networkType;
    private String networkName;
}
