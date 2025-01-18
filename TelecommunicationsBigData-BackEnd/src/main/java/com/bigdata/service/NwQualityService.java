package com.bigdata.service;

import com.bigdata.vo.NetworkQuality.*;
import com.bigdata.dto.nwQuality.*;

import java.util.List;

public interface NwQualityService {
    List<NwQualityStatisticsVo> getQualityStatistics(QualityStatisticsDTO nwQualityStatisticsVo);

    List<NwSpeedRankVo> getRank(SpeedRankDTO speedRankDTO);

    List<TypicalNWQualityTrackingVo> getTypicalTracking(NwTrackingDTO trackingDTO);

    List<TypicalNWQualityStatisticsVo> getLandmarkStatistics(LandmarkQualityStatisticsDTO statisticsDTO);

    List<NwQualityDistributionVo> getDistribution(DistributionDTO distributionDTO);
}
