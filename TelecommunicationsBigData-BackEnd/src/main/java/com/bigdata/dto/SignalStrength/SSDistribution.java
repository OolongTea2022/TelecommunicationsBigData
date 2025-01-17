package com.bigdata.dto.SignalStrength;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SSDistribution {
    @Schema(description = "网络发行商",example = "CUCC")
    private String nwOperator;
    @Schema(description = "网络类型",example = "2G")
    private String nwType;
    @Schema(description = "开始日期",example = "2019090517")
    private long startDate;
    @Schema(description = "截止日期",example = "2019090517")
    private long endDate;
}
