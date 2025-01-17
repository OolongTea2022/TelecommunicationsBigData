package com.bigdata.dao;

import com.bigdata.model.entity.PopularApp.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PopularAppMapper
{
    List<PopularAppDistribution> getDistribution();

    List<PopularAppTrafficDistribution> getTrafficDistribution();

    List<PopularAppTrafficRank> getTrafficRank();

    List<PopularAppTrafficTracking> getTrafficTracking();

    List<PopularAppUserDIstribution> getUserDIstribution();

    List<TypicalLandmarkAppTrafficRank> getTypicalLandmarkAppTrafficRank();
}
