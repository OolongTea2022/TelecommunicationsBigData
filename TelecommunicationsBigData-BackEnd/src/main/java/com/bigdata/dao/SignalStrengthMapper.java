package com.bigdata.dao;

import com.bigdata.dto.SignalStrength.SSDistribution;
import com.bigdata.dto.SignalStrength.SSStatisticsDTO;
import com.bigdata.dto.SignalStrength.SSTrackingDTO;
import com.bigdata.model.entity.SignalCoverage.SignalStrengthDistribution;
import com.bigdata.model.entity.SignalCoverage.TypicalSignalStrengthStatistics;
import com.bigdata.model.entity.SignalCoverage.TypicalSignalStrengthTracking;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SignalStrengthMapper {

    List<SignalStrengthDistribution> getDistribution(SSDistribution distribution);

    List<TypicalSignalStrengthTracking> getTracking(SSTrackingDTO ssTrackingDTO);

    List<TypicalSignalStrengthStatistics> getStatistics(SSStatisticsDTO ssStatisticsDTO);
}
