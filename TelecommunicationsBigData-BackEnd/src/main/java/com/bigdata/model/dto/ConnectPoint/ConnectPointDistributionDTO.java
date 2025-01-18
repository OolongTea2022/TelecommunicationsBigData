package com.bigdata.model.dto.ConnectPoint;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 用于查询连接点地理分布的DTO
 */
@Data
@Schema(description = "用于查询连接点地理分布的DTO")
public class ConnectPointDistributionDTO {
    @Schema(description = "网络运营商", example = "CUCC")
    private String nwOperator;

    @Schema(description = "开始时间", example = "2017010100")
    private Long startTime;

    @Schema(description = "结束时间", example = "2018020200")
    private Long endTime;
}