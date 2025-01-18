package com.bigdata.controller;

import com.bigdata.model.dto.nwQuality.*;
import com.bigdata.model.vo.NetworkQuality.*;
import com.bigdata.result.Result;
import com.bigdata.service.NwQualityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/nwQuality")
@Slf4j
public class NwQualityController {

    @Autowired
    private NwQualityService nwQualityService;

    @PostMapping("/Distribution")
    public Result<List<NwQualityDistributionVo>> getDistribution(@RequestBody DistributionDTO distributionDTO) {
        log.info("getDistribution start");
        return Result.success(nwQualityService.getDistribution(distributionDTO));
    }
    //11
    @PostMapping("/Statistics")
    public Result<List<NwQualityStatisticsVo>> getQualityStatistics(@RequestBody QualityStatisticsDTO qualityStatisticsDTO) {
        log.info("getQualityStatistics");
        return Result.success(nwQualityService.getQualityStatistics(qualityStatisticsDTO));
    }

    @PostMapping("/rank")
    public Result<List<NwSpeedRankVo>> getRank(@RequestBody SpeedRankDTO speedRankDTO) {
        log.info("getRank");
        return Result.success(nwQualityService.getRank(speedRankDTO));
    }

    @PostMapping("/TypicalTracking")
    public Result<List<TypicalNWQualityTrackingVo>> getTypicalTracking(@RequestBody NwTrackingDTO trackingDTO) {
        log.info("getTypicalTracking");
        return Result.success(nwQualityService.getTypicalTracking(trackingDTO));
    }

    @PostMapping("/TypicalStatistics")
    public Result<List<TypicalNWQualityStatisticsVo>> getTypicalStatistics(@RequestBody LandmarkQualityStatisticsDTO statisticsDTO) {
        log.info("getTypicalStatistics");
        return Result.success(nwQualityService.getLandmarkStatistics(statisticsDTO));
    }
}
