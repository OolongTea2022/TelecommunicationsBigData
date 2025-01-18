package com.bigdata.service.impl;

import com.bigdata.model.vo.SignalCoverage.SignalStrengthDistributionVo;
import com.bigdata.model.vo.SignalCoverage.TypicalSSStatisticsVo;
import com.bigdata.model.vo.SignalCoverage.TypicalSSTrackingVo;
import com.bigdata.dao.SignalStrengthMapper;
import com.bigdata.model.dto.SignalStrength.SSDistribution;
import com.bigdata.model.dto.SignalStrength.SSStatisticsDTO;
import com.bigdata.model.dto.SignalStrength.SSTrackingDTO;
import com.bigdata.model.entity.SignalCoverage.SignalStrengthDistribution;
import com.bigdata.model.entity.SignalCoverage.TypicalSignalStrengthStatistics;
import com.bigdata.model.entity.SignalCoverage.TypicalSignalStrengthTracking;
import com.bigdata.service.SignalStrengthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SignalStrengthServiceImpl implements SignalStrengthService {
    @Autowired
    private SignalStrengthMapper signalStrengthMapper;

    @Override
    public List<SignalStrengthDistributionVo> getSignalStrengthDistribution(SSDistribution distribution) {

        List<SignalStrengthDistribution> appDistribution = signalStrengthMapper.getDistribution(distribution);
        List<SignalStrengthDistributionVo> result = appDistribution.parallelStream()
                .map(item -> {
                    SignalStrengthDistributionVo vo = new SignalStrengthDistributionVo();
                    BeanUtils.copyProperties(item, vo);
                    return vo;
                })
                .collect(Collectors.toList());
        log.info(String.valueOf(appDistribution.size()));
        return result;
    }

    @Override
    public List<TypicalSSTrackingVo> getTypicalSignalStrengthTracking(SSTrackingDTO ssTrackingDTO) {

        List<TypicalSignalStrengthTracking> Tracking = signalStrengthMapper.getTracking(ssTrackingDTO);
        List<TypicalSSTrackingVo> result = Tracking.parallelStream()
                .map(item->{
                    TypicalSSTrackingVo vo = new TypicalSSTrackingVo();
                    BeanUtils.copyProperties(item, vo);
                    return vo;
                }).collect(Collectors.toList());
        log.info(String.valueOf(result.size()));
        return result;
    }

    @Override
    public List<TypicalSSStatisticsVo> getTypicalSignalStrengthStatistics(SSStatisticsDTO statisticsDTO) {

        List<TypicalSignalStrengthStatistics> TypicalStatics = signalStrengthMapper.getStatistics(statisticsDTO);
        List<TypicalSSStatisticsVo> result = TypicalStatics.parallelStream()
                .map(item->{
                    TypicalSSStatisticsVo vo = new TypicalSSStatisticsVo();
                    BeanUtils.copyProperties(item, vo);
                    return vo;
                        }).collect(Collectors.toList());
        log.info(String.valueOf(result.size()));
        return result;
    }
}
