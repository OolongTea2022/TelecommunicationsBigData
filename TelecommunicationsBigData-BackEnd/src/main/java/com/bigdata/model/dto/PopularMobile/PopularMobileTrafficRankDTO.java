package com.bigdata.model.dto.PopularMobile;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 用于热门手机流量排名的DTO
 */
@Data
@Schema(description = "用于热门手机流量排名的DTO")
public class PopularMobileTrafficRankDTO {
    @Schema(description = "网络运营商", example = "CUCC")
    private String networkName;

    @Schema(description = "手机流量(上行 upload  下行 download  总流量 total)", example = "total")
    private String trafficType;

    @Schema(description = "开始时间", example = "2011050400")
    private String startTime;

    @Schema(description = "结束时间", example = "2024090100")
    private String endTime;

}