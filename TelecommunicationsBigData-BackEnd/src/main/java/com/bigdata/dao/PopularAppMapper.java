package com.bigdata.dao;

import com.bigdata.dto.PopularApp.*;
import com.bigdata.model.entity.PopularApp.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PopularAppMapper
{
    List<PopularAppDistribution> getDistribution(AppDistributionDTO appDistributionDTO);

    List<PopularAppTrafficDistribution> getTrafficDistribution(AppDistributionDTO appDistributionDTO);

    List<PopularAppTrafficRank> getTrafficRank(TrafficRankDTO trafficRankDTO);

    List<PopularAppTrafficTracking> getTrafficTracking(TrafficTrackingDTO trafficTrackingDTO);

    List<PopularAppUserDIstribution> getUserDIstribution(UserDistributionDTO userDistributionDTO);

    List<TypicalLandmarkAppTrafficRank> getTypicalLandmarkAppTrafficRank(TypeTrafficDTO typeTrafficDTO);
}
