package com.bigdata.dao;

import com.bigdata.model.entity.DataLinks.DataLinksDistribution;
import com.bigdata.model.entity.DataLinks.DataLinkStatistics;
import java.util.List;

public interface DataLinksMapper {
    List<DataLinksDistribution> getDataLinksDistribution(
            String networkType, String networkName, String userLat, String userLon, String mobileNetworkType);
    List<DataLinkStatistics> getDataLinkStatistics(
            String networkType, String networkName, Long tcount);
}