package com.bigdata.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 用于查询连接点排名的DTO
 */
@Data
@Schema(description = "用于查询连接点排名的DTO")
public class ConnectPointRankDTO {
    @Schema(description = "开始时间", example = "2017010100")
    private Long startTime;

    @Schema(description = "结束时间", example = "2018020200")
    private Long endTime;

    @Schema(description = "网络运营商", example = "CMCC")
    private String nwOperator;
}