package com.bigdata.service;

import com.bigdata.vo.DataLinks.DistributionVo;
import com.bigdata.vo.DataLinks.StatisticsVo;
import com.bigdata.dto.DataLinks.DistributionDTO;
import com.bigdata.dto.DataLinks.StatisticsDTO;

import java.util.List;

public interface DataLinksService {
    // 使用部分 DataLinksDistribution 属性作为查询参数，以实现动态查询
    List<DistributionVo> getDataLinksDistribution(DistributionDTO distributionDTO);
    // 使用部分 DataLinkStatistics 属性作为查询参数，以实现动态查询
    List<StatisticsVo> getDataLinkStatistics(StatisticsDTO statisticsDTO);
}