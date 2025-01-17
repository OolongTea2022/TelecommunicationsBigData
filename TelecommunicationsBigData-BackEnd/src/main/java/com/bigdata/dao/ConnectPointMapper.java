package com.bigdata.dao;

import com.bigdata.model.dto.ConnectPointDistributionDTO;
import com.bigdata.model.dto.ConnectPointRankDTO;
import com.bigdata.model.entity.ConnectPoint.ConnectPointDistribution;
import com.bigdata.model.entity.ConnectPoint.ConnectPointRank;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 */
public interface ConnectPointMapper {
    List<ConnectPointRank> getConnectPointRank(@Param("dto")ConnectPointRankDTO connectPointRankDTO);


    List<ConnectPointDistribution> getConnectPointDistribution(@Param("dto") ConnectPointDistributionDTO connectPointDistributionDTO);
}
