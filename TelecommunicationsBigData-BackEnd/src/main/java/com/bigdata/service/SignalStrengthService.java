package com.bigdata.service;

import com.bigdata.model.vo.SignalCoverage.SignalStrengthDistributionVo;
import com.bigdata.model.vo.SignalCoverage.TypicalSSStatisticsVo;
import com.bigdata.model.vo.SignalCoverage.TypicalSSTrackingVo;
import com.bigdata.model.dto.SignalStrength.SSDistribution;
import com.bigdata.model.dto.SignalStrength.SSStatisticsDTO;
import com.bigdata.model.dto.SignalStrength.SSTrackingDTO;

import java.util.List;

public interface SignalStrengthService {
    List<SignalStrengthDistributionVo> getSignalStrengthDistribution(SSDistribution distribution);
    List<TypicalSSTrackingVo> getTypicalSignalStrengthTracking(SSTrackingDTO ssTrackingDTO);
    List<TypicalSSStatisticsVo> getTypicalSignalStrengthStatistics(SSStatisticsDTO ssStatisticsDTO);
}
