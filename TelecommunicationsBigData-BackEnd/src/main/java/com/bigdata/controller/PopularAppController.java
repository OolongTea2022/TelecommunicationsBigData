package com.bigdata.controller;

import com.bigdata.model.dto.PopularApp.*;
import com.bigdata.model.vo.PopularApp.*;
import com.bigdata.result.Result;
import com.bigdata.service.PopularAppService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequestMapping("/popularapp")
@RestController
@Slf4j
public class PopularAppController {

    @Autowired
    private PopularAppService popularAppService;


    @PostMapping("/getPopularAppTrafficDistribution")
    public Result<List<AppDistributionVo>> getPopularAppTrafficDistributionList(@RequestBody AppDistributionDTO appDistributionDTO) {
        log.info("getPopularAppTrafficDistributionList");
        return Result.success(popularAppService.getTrafficDistribution(appDistributionDTO));
    }//流量分布

    @PostMapping ("/getPopularAppDistribution")
    public Result<List<AppDistributionVo>> getPopularAppDistributionList(@RequestBody AppDistributionDTO appDistributionDTO) {
        log.info("getPopularAppDistributionList");
        return Result.success(popularAppService.getDistribution(appDistributionDTO));
    }
    //19
    @PostMapping("/getTrafficRank")
    public Result<List<TrafficRankVo>> getTrafficRank(@RequestBody TrafficRankDTO trafficRankDTO) {
        log.info("getTrafficRank");
        return Result.success(popularAppService.getTrafficRank(trafficRankDTO));
    }

    //20
    @PostMapping("/getTrafficTracking")
    public Result<List<TrafficTrackingVo>> getTrafficTracking(@RequestBody TrafficTrackingDTO trafficTrackingDTO) {
        log.info("getTrafficTracking");
        return Result.success(popularAppService.getTrafficTracking(trafficTrackingDTO));
    }
    //21
    @PostMapping("/getTypicalLandmarkAppTrafficRank")
    public Result<List<TypeTrafficVo>> getTypicalLandmarkAppTrafficRank(@RequestBody TypeTrafficDTO typeTrafficDTO) {
        log.info("getTypicalLandmarkAppTrafficRank");
        return Result.success(popularAppService.getTypicalLandmarkAppTrafficRank(typeTrafficDTO));
    }

    //热力图，返回经纬度热力
    @PostMapping("/getAppUserDistribution")
    public Result<List<UserDistributionVo>> getAppUserDistribution(@RequestBody UserDistributionDTO userDistributionDTO) {
        log.info("getAppUserDistribution");
        return Result.success(popularAppService.getUserDIstribution(userDistributionDTO));
    }
}