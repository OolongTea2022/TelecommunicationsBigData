package com.bigdata.dao;

import com.bigdata.dto.nwQuality.NwTrackingDTO;
import com.bigdata.dto.nwQuality.QualityStatisticsDTO;
import com.bigdata.dto.nwQuality.SpeedRankDTO;
import com.bigdata.model.entity.NetworkQuality.NwQualityStatistics;
import com.bigdata.model.entity.NetworkQuality.NwSpeedRank;
import com.bigdata.model.entity.NetworkQuality.TypicalNWQualityTracking;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NwQualityMapper {

    List<NwQualityStatistics> getStatistics(QualityStatisticsDTO statisticsDTO);

    List<NwSpeedRank> getRanks(SpeedRankDTO speedRankDTO);

    List<TypicalNWQualityTracking> getTypicalTracking(NwTrackingDTO trackingDTO);
}
