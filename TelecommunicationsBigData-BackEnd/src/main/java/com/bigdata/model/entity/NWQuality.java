package com.bigdata.model.entity;

import lombok.Data;

@Data
public class NWQuality {
    private Long id;
    private String gpsLat;
    private String gpsLon;
    private String nwOperator;
    private Double ulSpeed;
    private Double dlSpeed;
    private Double latency;
    private String province;
    private Long dayTime;
    private String nwType;
    private String landmark;
    private String companyModel;
}