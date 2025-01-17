package com.bigdata.service;

import com.bigdata.model.entity.DataLinks.DataLinksDistribution;
import com.bigdata.model.entity.DataLinks.DataLinkStatistics;
import java.util.List;

public interface DataLinksService {
    // 使用部分 DataLinksDistribution 属性作为查询参数，以实现动态查询
    List<DataLinksDistribution> getDataLinksDistribution(
            String networkType, String networkName, String userLat, String userLon, String mobileNetworkType);
    // 使用部分 DataLinkStatistics 属性作为查询参数，以实现动态查询
    List<DataLinkStatistics> getDataLinkStatistics(
            String networkType, String networkName, Long tcount);
}