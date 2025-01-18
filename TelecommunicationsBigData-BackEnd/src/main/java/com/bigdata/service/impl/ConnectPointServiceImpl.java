package com.bigdata.service.impl;

import com.bigdata.dao.ConnectPointMapper;
import com.bigdata.model.dto.ConnectPointDistributionDTO;
import com.bigdata.model.dto.ConnectPointRankDTO;
import com.bigdata.model.entity.ConnectPoint.ConnectPointDistribution;
import com.bigdata.model.entity.ConnectPoint.ConnectPointRank;
import com.bigdata.service.ConnectPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class ConnectPointServiceImpl implements ConnectPointService {
    @Autowired
    private ConnectPointMapper connectPointMapper;

    @Override
    public List<ConnectPointRank> getConnectPointRank(ConnectPointRankDTO connectPointRankDTO) {
        return connectPointMapper.getConnectPointRank(connectPointRankDTO);
    }

    @Override
    public List<ConnectPointDistribution> getConnectPointDistribution(ConnectPointDistributionDTO connectPointDistributionDTO) {
        return connectPointMapper.getConnectPointDistribution(connectPointDistributionDTO);
    }
}
