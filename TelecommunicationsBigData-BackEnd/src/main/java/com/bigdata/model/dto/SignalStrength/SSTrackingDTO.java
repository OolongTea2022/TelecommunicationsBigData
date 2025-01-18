package com.bigdata.model.dto.SignalStrength;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class SSTrackingDTO {
    @Schema(description = "地标",example = "commercial")
    private String landmark;
    @Schema(description = "网络类型",example = "2G")
    private String nwType;
    @Schema(description = "开始日期",example = "2019090517")
    private long startDate;
    @Schema(description = "截止日期",example = "2019090517")
    private long endDate;
    @Schema(description = "时间粒度",example = "day,hour,month")
    private String timeGranularity;
}
