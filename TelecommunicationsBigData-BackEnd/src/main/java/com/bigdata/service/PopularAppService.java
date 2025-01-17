package com.bigdata.service;

import com.bigdata.model.entity.PopularApp.*;

import java.util.List;

public interface PopularAppService {

    List<PopularAppDistribution> getDistribution();
    List<PopularAppTrafficDistribution> getTrafficDistribution();
    List<PopularAppTrafficRank> getTrafficRank();
    List<PopularAppTrafficTracking> getTrafficTracking();
    List<PopularAppUserDIstribution> getUserDIstribution();
    List<TypicalLandmarkAppTrafficRank> getTypicalLandmarkAppTrafficRank();
}