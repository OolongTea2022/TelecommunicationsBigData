package com.bigdata.model.dto.PopularApp;
import lombok.Data;
@Data
public class TypeTrafficDTO {
    private double heat;
    private String landmark;
    private String nwType;
    private String nwOperator;
    private long startDate;
    private long endDate;
}
