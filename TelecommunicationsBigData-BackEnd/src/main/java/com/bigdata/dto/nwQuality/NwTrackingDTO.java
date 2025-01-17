package com.bigdata.dto.nwQuality;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class NwTrackingDTO {
    @Schema(description = "网络类型",example = "2G")
    private String nwType;
    @Schema(description = "网络发行商",example = "CUCC")
    private String nwOperator;
    @Schema(description = "地标",example = "commercial")
    private String landmark;
    @Schema(description = "开始日期",example = "2019090517")
    private long startDate;
    @Schema(description = "截止日期",example = "2019090517")
    private long endDate;
    @Schema(description = "网络速度类型",example = "ulspeed")
    private String speedType;
    @Schema(description = "时间粒度",example = "day,hour,month")
    private String timeGranularity;

}
