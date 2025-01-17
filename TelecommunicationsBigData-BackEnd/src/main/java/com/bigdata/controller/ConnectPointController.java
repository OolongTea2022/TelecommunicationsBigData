package com.bigdata.controller;

import com.bigdata.model.dto.ConnectPointDistributionDTO;
import com.bigdata.model.dto.ConnectPointRankDTO;
import com.bigdata.model.entity.ConnectPoint.ConnectPointDistribution;
import com.bigdata.model.entity.ConnectPoint.ConnectPointRank;
import com.bigdata.result.Result;
import com.bigdata.service.ConnectPointService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 连接点 controller
 */
@RestController
@RequestMapping("/connectPoint")
public class ConnectPointController {
    @Autowired
    private ConnectPointService connectPointService;

    @Operation(summary = "获取连接点排名")
    @PostMapping("/rank")
    public Result<List<ConnectPointRank>> getConnectPointRank(
            @Parameter(description = "查询参数", required = true) @RequestBody ConnectPointRankDTO connectPointRankDTO
    ) {
        List<ConnectPointRank> connectPointRank = connectPointService.getConnectPointRank(connectPointRankDTO);
        return Result.success(connectPointRank);
    }

    @Operation(summary = "获取连接点地理分布")
    @PostMapping("/distribution")
    public Result<List<ConnectPointDistribution>> getConnectPointDistribution(
            @Parameter(description = "查询参数", required = true) @RequestBody ConnectPointDistributionDTO connectPointDistributionDTO
    ) {
        List<ConnectPointDistribution> connectPointDistribution = connectPointService.getConnectPointDistribution(connectPointDistributionDTO);
        return Result.success(connectPointDistribution);
    }


}
