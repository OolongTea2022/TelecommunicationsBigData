package com.bigdata.controller;

import com.bigdata.model.dto.PopularMobile.*;
import com.bigdata.model.entity.PopularMobile.*;
import com.bigdata.result.Result;
import com.bigdata.service.PopularMobileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 *
 */
@RestController
@RequestMapping("/popularMobile")
public class PopularMobileController {
    @Autowired
    private PopularMobileService popularMobileService;

    @Operation(summary = "获取热门手机流量Top5")
    @PostMapping("/getTop5PopularMobileTraffic")
    public Result<List<PopularMobileDistribution>> getTop5PopularMobileTraffic(
            @Parameter(description = "查询参数", required = true) @RequestBody PopularMobileTrafficDistributionTop5DTO dto
    ) {
        List<PopularMobileDistribution> top5PopularMobileTraffic = popularMobileService.getTop5PopularMobileTraffic(dto);
        return Result.success(top5PopularMobileTraffic);
    }

    @Operation(summary = "获取热门手机流量分布")
    @PostMapping("/trafficDistribution")
    public Result<List<PopularMobileTrafficDistribution>> getPopularMobileDistribution(
            @Parameter(description = "查询参数", required = true) @RequestBody PopularMobileTrafficDistributionDTO dto
    ) {
        List<PopularMobileTrafficDistribution> popularMobileDistribution = popularMobileService.getPopularMobileTrafficDistribution(dto);
        return Result.success(popularMobileDistribution);
    }


    @Operation(summary = "热门手机网络质量排名")
    @PostMapping("/qualityRank")
    public Result getPopularMobileQualityRank(
            @Parameter(description = "查询参数", required = true) @RequestBody PopularMobileQualityRankDTO popularMobileQualityRankDTO) {
        List<PopularMobileQualityRank> popularMobileTrafficRank = popularMobileService.getPopularMobileQualityRankRank(popularMobileQualityRankDTO);
        return Result.success(popularMobileTrafficRank);
    }

    @Operation(summary = "获取热门移动流量排名")
    @PostMapping("/trafficRank")
    public Result<List<PopularMobileTrafficRank>> getPopularMobileTrafficRank(
            @Parameter(description = "查询参数", required = true) @RequestBody PopularMobileTrafficRankDTO dto
    ) {
        List<PopularMobileTrafficRank> popularMobileTrafficRank = popularMobileService.getPopularMobileTrafficRank(dto);
        return Result.success(popularMobileTrafficRank);
    }

    @Operation(summary = "获取手机OS流量排名")
    @PostMapping("/osTrafficRank")
    public Result<List<PopularMobileOSTrafficRank>> getPopularMobileOSTrafficRank(
            @Parameter(description = "查询参数", required = true) @RequestBody PopularMobileOSTrafficRankDTO dto
    ) {
        List<PopularMobileOSTrafficRank> popularMobileOSTrafficRank = popularMobileService.getPopularMobileOSTrafficRank(dto);
        return Result.success(popularMobileOSTrafficRank);
    }

    @Operation(summary = "热门手机分布图")
    @PostMapping("/distribution")
    public Result<List<PopularMobileDistribution>> getPopularMobileDistribution(
            @Parameter(description = "查询参数", required = true) @RequestBody PopularMobileDistributionDTO dto
    ) {
        List<PopularMobileDistribution> popularMobileDistribution = popularMobileService.getPopularMobileDistribution(dto);
        return Result.success(popularMobileDistribution);
    }

    @Operation(summary = "手机OS分布图")
    @PostMapping("/osDistribution")
    public Result<List<MobileOSDistribution>> getMobileOSDistribution(
            @Parameter(description = "查询参数", required = true) @RequestBody MobileOSDistributionDTO dto
    ) {
        List<MobileOSDistribution> mobileOSDistribution = popularMobileService.getMobileOSDistribution(dto);
        return Result.success(mobileOSDistribution);
    }
}
