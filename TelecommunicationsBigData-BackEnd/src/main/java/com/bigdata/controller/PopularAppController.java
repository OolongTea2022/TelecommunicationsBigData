package com.bigdata.controller;

import com.bigdata.VO.PopularApp.*;
import com.bigdata.dto.PopularApp.*;
import com.bigdata.model.entity.PopularApp.*;
import com.bigdata.result.Result;
import com.bigdata.service.PopularAppService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@RequestMapping("/popularapp")
@Controller
@Slf4j
public class PopularAppController {

    @Autowired
    private PopularAppService popularAppService;

    @PostMapping("/getPopularAppTrafficDistribution")
    public Result<List<AppDistributionVo>> getPopularAppTrafficDistributionList(@RequestBody AppDistributionDTO appDistributionDTO) {
        log.info("getPopularAppTrafficDistributionList");
        return Result.success(popularAppService.getTrafficDistribution(appDistributionDTO));
    }//流量分布


    @GetMapping ("/getPopularAppDistribution")
    public Result<List<AppDistributionVo>> getPopularAppDistributionList(@RequestBody AppDistributionDTO appDistributionDTO) {
        log.info("getPopularAppDistributionList");
        return Result.success(popularAppService.getDistribution(appDistributionDTO));
    }


    @PostMapping("/getTrafficRank")
    public Result<List<TrafficRankVo>> getTrafficRank(@RequestBody TrafficRankDTO trafficRankDTO) {
        log.info("getTrafficRank");
        return Result.success(popularAppService.getTrafficRank(trafficRankDTO));
    }


    @PostMapping("/getTrafficTracking")
    public Result<List<TrafficTrackingVo>> getTrafficTracking(@RequestBody TrafficTrackingDTO trafficTrackingDTO) {
        log.info("getTrafficTracking");
        return Result.success(popularAppService.getTrafficTracking(trafficTrackingDTO));
    }


    @PostMapping("/getAppUserDistribution")
    public Result<List<UserDistributionVo>> getAppUserDistribution(@RequestBody UserDistributionDTO userDistributionDTO) {
        log.info("getAppUserDistribution");
        return Result.success(popularAppService.getUserDIstribution(userDistributionDTO));
    }


    @PostMapping("/getTypicalLandmarkAppTrafficRank")
    public Result<List<TypeTrafficVo>> getTypicalLandmarkAppTrafficRank(@RequestBody TypeTrafficDTO typeTrafficDTO) {
        log.info("getTypicalLandmarkAppTrafficRank");
        return Result.success(popularAppService.getTypicalLandmarkAppTrafficRank(typeTrafficDTO));
    }
}