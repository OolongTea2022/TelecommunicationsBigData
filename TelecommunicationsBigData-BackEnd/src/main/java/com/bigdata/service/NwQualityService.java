package com.bigdata.service;

import com.bigdata.VO.NetworkQuality.NwQualityStatisticsVo;
import com.bigdata.VO.NetworkQuality.NwSpeedRankVo;
import com.bigdata.VO.NetworkQuality.TypicalNWQualityTrackingVo;
import com.bigdata.dto.nwQuality.NwTrackingDTO;
import com.bigdata.dto.nwQuality.QualityStatisticsDTO;
import com.bigdata.dto.nwQuality.SpeedRankDTO;

import java.util.List;

public interface NwQualityService {
    List<NwQualityStatisticsVo> getQualityStatistics(QualityStatisticsDTO nwQualityStatisticsVo);

    List<NwSpeedRankVo> getRank(SpeedRankDTO speedRankDTO);

    List<TypicalNWQualityTrackingVo> getTypicalTracking(NwTrackingDTO trackingDTO);
}
