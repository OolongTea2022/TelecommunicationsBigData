package com.bigdata.controller;

import com.bigdata.VO.SignalCoverage.TypicalSSStatisticsVo;
import com.bigdata.VO.SignalCoverage.TypicalSSTrackingVo;
import com.bigdata.dto.SignalStrength.SSStatisticsDTO;
import com.bigdata.dto.SignalStrength.SSTrackingDTO;
import com.bigdata.result.Result;
import com.bigdata.VO.SignalCoverage.SignalStrengthDistributionVo;
import com.bigdata.service.SignalStrengthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/SignalStrength")
@Slf4j
public class SignalStrengthDistributionController {

    @Autowired
    private SignalStrengthService signalStrengthService;

    @GetMapping("/Distribution")
    public Result<List<SignalStrengthDistributionVo>> getDistribution() {
        log.info("getDistribution");
        return Result.success(signalStrengthService.getSignalStrengthDistribution());
    }

    @PostMapping("/TypicalSignalStrengthTracking")
    public Result<List<TypicalSSTrackingVo>> getTypicalSignalStrengthTracking(@RequestBody SSTrackingDTO ssTrackingDTO) {
        log.info("getTypicalSignalStrengthTracking");
        log.info("ssTrackingDTO: {}", ssTrackingDTO.getLandmark());
        return Result.success(signalStrengthService.getTypicalSignalStrengthTracking(ssTrackingDTO));
    }

    @PostMapping("/TypicalSignalStrengthStatistics")
    public Result<List<TypicalSSStatisticsVo>> getTypicalSignalStrengthTrackingByLandmark(@RequestBody SSStatisticsDTO statisticsDTO) {
        log.info("getTypicalSignalStrengthTrackingByLandmark");
        return Result.success(signalStrengthService.getTypicalSignalStrengthStatistics(statisticsDTO));
    }


}
