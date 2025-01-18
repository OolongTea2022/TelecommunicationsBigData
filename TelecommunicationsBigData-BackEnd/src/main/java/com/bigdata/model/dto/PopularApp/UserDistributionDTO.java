package com.bigdata.model.dto.PopularApp;
import lombok.Data;
@Data
public class UserDistributionDTO {
    private String userLat;
    private String userLon;
    private String nwOperator;
    private String nwType;
    private long startDate;
    private long endDate;
}
