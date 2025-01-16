package com.bigdata.model.entity;

import lombok.Data;

@Data
public class AppTraffic {
    private Long id;
    private String userLon;
    private String userLat;
    private Double uploadTraffic;
    private Double downloadTraffic;
    private String packageName;
    private String networkName;
    private String appName;
    private String os;
    private String osVersion;
    private String company;
    private String startTime;
    private String endTime;
    private String networkType;
    private String allMobileTraffic;
    private Long date;
    private String landmark;
    private String companyModel;
    private String osAndVersion;
}