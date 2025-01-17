package com.bigdata.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 用于热门手机网络质量排名的DTO
 */
@Data
@Schema(description = "用于查询热门移动流量排名的DTO")
public class PopularMobileQualityRankDTO {
    @Schema(description = "网络运营商", example = "CUCC")
    private String networkName;

    @Schema(description = "网络质量(上行 ULSPEED  下行 DLSPEED  延迟  LATENCY)", example = "DLSPEED")
    private String nwQuality;

    @Schema(description = "开始时间", example = "2011050400")
    private Long startTime;

    @Schema(description = "结束时间", example = "2024090100")
    private Long endTime;

    // TODO 网络制式  表格无该字段
}