package com.bigdata.service;

import com.bigdata.model.dto.PopularApp.*;
import com.bigdata.model.vo.PopularApp.*;

import java.util.List;

public interface PopularAppService {

    List<AppDistributionVo> getDistribution(AppDistributionDTO appDistributionDTO);
    List<AppDistributionVo> getTrafficDistribution(AppDistributionDTO appDistributionDTO);
    List<TrafficRankVo> getTrafficRank(TrafficRankDTO trafficRankDTO);
    List<TrafficTrackingVo> getTrafficTracking(TrafficTrackingDTO trafficTrackingDTO);
    List<UserDistributionVo> getUserDIstribution(UserDistributionDTO userDistributionDTO);
    List<TypeTrafficVo> getTypicalLandmarkAppTrafficRank(TypeTrafficDTO typeTrafficDTO);
}