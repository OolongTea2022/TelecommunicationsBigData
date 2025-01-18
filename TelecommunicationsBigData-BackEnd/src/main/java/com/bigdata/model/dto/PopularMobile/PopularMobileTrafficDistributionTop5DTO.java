package com.bigdata.model.dto.PopularMobile;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 用于热门手机流量Top5的DTO
 */
@Data
@Schema(description = "用于热门手机流量Top5的DTO")
public class PopularMobileTrafficDistributionTop5DTO {
    @Schema(description = "网络运营商", example = "CUCC")
    private String networkName;

    @Schema(description = "开始时间", example = "20180504")
    private String startTime;

    @Schema(description = "结束时间", example = "20180901")
    private String endTime;
}