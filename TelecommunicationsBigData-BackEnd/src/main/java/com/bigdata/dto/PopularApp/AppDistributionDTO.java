package com.bigdata.dto.PopularApp;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
@Data
public class AppDistributionDTO {
    @Schema(description = "网络类型",example = "3G")
    private String nwType;
    @Schema(description = "网络运营商",example = "CUCC")
    private String nwOperator;
    @Schema(description = "热门app,流量分布中使用")
    private String appName;
    @Schema(description = "找大于某一流量的app")
    private double heat;
    private long startDate;
    private long endDate;
}
