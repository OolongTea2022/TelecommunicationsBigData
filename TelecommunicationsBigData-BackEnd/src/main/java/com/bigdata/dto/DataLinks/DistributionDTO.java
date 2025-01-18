package com.bigdata.dto.DataLinks;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Data
public class DistributionDTO {
    private double userLat;
    private double userLon;
    private String nwOperator;
    private String nwType;
    private long startDate;
    private long endDate;
}
