package com.bigdata.dao;

import com.bigdata.model.dto.nwQuality.*;
import com.bigdata.model.entity.NetworkQuality.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NwQualityMapper {

    List<NwQualityStatistics> getStatistics(QualityStatisticsDTO statisticsDTO);

    List<NwSpeedRank> getRanks(SpeedRankDTO speedRankDTO);

    List<TypicalNWQualityTracking> getTypicalTracking(NwTrackingDTO trackingDTO);

    List<TypicalNWQualityStatistics> getLandmarkStatistics(LandmarkQualityStatisticsDTO statisticsDTO);

    List<NwQualityDistribution> getDistribution(DistributionDTO distributionDTO);
}
