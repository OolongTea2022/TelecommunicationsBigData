package com.bigdata.service.impl;

import com.bigdata.dao.DataLinksMapper;
import com.bigdata.model.entity.DataLinks.DataLinksDistribution;
import com.bigdata.model.entity.DataLinks.DataLinkStatistics;
import com.bigdata.service.DataLinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DataLinksServiceImpl implements DataLinksService {

    @Autowired
    private DataLinksMapper dataLinksMapper;

    @Override
    public List<DataLinksDistribution> getDataLinksDistribution(
            String networkType, String networkName, String userLat, String userLon, String mobileNetworkType) {
        return dataLinksMapper.getDataLinksDistribution(networkType, networkName, userLat, userLon, mobileNetworkType);
    }

    @Override
    public List<DataLinkStatistics> getDataLinkStatistics(
            String networkType, String networkName, Long tcount) {
        return dataLinksMapper.getDataLinkStatistics(networkType, networkName, tcount);
    }
}