package com.bigdata.service;

import com.bigdata.VO.SignalCoverage.SignalStrengthDistributionVo;
import com.bigdata.VO.SignalCoverage.TypicalSSTrackingVo;
import com.bigdata.VO.SignalCoverage.TypicalSSStatisticsVo;
import com.bigdata.dto.SignalStrength.SSStatisticsDTO;
import com.bigdata.dto.SignalStrength.SSTrackingDTO;

import java.util.List;

public interface SignalStrengthService {
    List<SignalStrengthDistributionVo> getSignalStrengthDistribution();
    List<TypicalSSTrackingVo> getTypicalSignalStrengthTracking(SSTrackingDTO ssTrackingDTO);

    List<TypicalSSStatisticsVo> getTypicalSignalStrengthStatistics(SSStatisticsDTO ssStatisticsDTO);
}
