package com.bigdata.model.entity.SignalCoverage;

import lombok.Data;

@Data
public class TypicalSignalStrengthStatistics {
    private double rssi;
    private String landmark;
    private String networkType;
    private String networkName;
}
