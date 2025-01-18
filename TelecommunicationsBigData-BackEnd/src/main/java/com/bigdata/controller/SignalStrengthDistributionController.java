package com.bigdata.controller;

import com.bigdata.model.vo.SignalCoverage.SignalStrengthDistributionVo;
import com.bigdata.model.vo.SignalCoverage.TypicalSSStatisticsVo;
import com.bigdata.model.vo.SignalCoverage.TypicalSSTrackingVo;
import com.bigdata.model.dto.SignalStrength.SSDistribution;
import com.bigdata.model.dto.SignalStrength.SSStatisticsDTO;
import com.bigdata.model.dto.SignalStrength.SSTrackingDTO;
import com.bigdata.result.Result;
import com.bigdata.service.SignalStrengthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/SignalStrength")
@Slf4j
public class SignalStrengthDistributionController {

    @Autowired
    private SignalStrengthService signalStrengthService;

    //需求7
    @PostMapping("/Distribution")
    public Result<List<SignalStrengthDistributionVo>> getDistribution(@RequestBody SSDistribution distribution) {
        log.info("getDistribution");
        return Result.success(signalStrengthService.getSignalStrengthDistribution(distribution));
    }

    //8
    @PostMapping("/TypicalSignalStrengthTracking")
    public Result<List<TypicalSSTrackingVo>> getTypicalSignalStrengthTracking(@RequestBody SSTrackingDTO ssTrackingDTO) {
        log.info("getTypicalSignalStrengthTracking");
        log.info("ssTrackingDTO: {}", ssTrackingDTO.getLandmark());
        return Result.success(signalStrengthService.getTypicalSignalStrengthTracking(ssTrackingDTO));
    }

    //9
    @PostMapping("/TypicalSignalStrengthStatistics")
    public Result<List<TypicalSSStatisticsVo>> getTypicalSignalStrengthTrackingByLandmark(@RequestBody SSStatisticsDTO statisticsDTO) {
        log.info("getTypicalSignalStrengthTrackingByLandmark");
        return Result.success(signalStrengthService.getTypicalSignalStrengthStatistics(statisticsDTO));
    }


}
