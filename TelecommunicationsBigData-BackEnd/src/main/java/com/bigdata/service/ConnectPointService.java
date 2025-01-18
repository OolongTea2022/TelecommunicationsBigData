package com.bigdata.service;

import com.bigdata.model.dto.ConnectPointDistributionDTO;
import com.bigdata.model.dto.ConnectPointRankDTO;
import com.bigdata.model.entity.ConnectPoint.ConnectPointDistribution;
import com.bigdata.model.entity.ConnectPoint.ConnectPointRank;

import java.util.List;

/**
 *
 */
public interface ConnectPointService {
    List<ConnectPointRank> getConnectPointRank(ConnectPointRankDTO connectPointRankDTO);


    List<ConnectPointDistribution> getConnectPointDistribution(ConnectPointDistributionDTO connectPointDistributionDTO);
}
