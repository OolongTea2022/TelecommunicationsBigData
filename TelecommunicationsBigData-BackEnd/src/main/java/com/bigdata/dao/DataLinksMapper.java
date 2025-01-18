package com.bigdata.dao;

import com.bigdata.model.dto.DataLinks.DistributionDTO;
import com.bigdata.model.dto.DataLinks.StatisticsDTO;
import com.bigdata.model.entity.DataLinks.DataLinkStatistics;
import com.bigdata.model.entity.DataLinks.DataLinksDistribution;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DataLinksMapper {
    List<DataLinksDistribution> getDataLinksDistribution(DistributionDTO distributionDTO);
    List<DataLinkStatistics> getDataLinkStatistics(StatisticsDTO statisticsDTO);
}