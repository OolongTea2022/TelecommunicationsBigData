package com.bigdata.controller;

import com.bigdata.VO.DataLinks.DistributionVo;
import com.bigdata.VO.DataLinks.StatisticsVo;
import com.bigdata.dto.DataLinks.DistributionDTO;
import com.bigdata.dto.DataLinks.StatisticsDTO;
import com.bigdata.result.Result;
import com.bigdata.service.DataLinksService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/datalinks")
@Slf4j
public class DataLinksController {

    @Autowired
    private DataLinksService dataLinksService;

    //11
    @PostMapping("/Distribution")
    public Result<List<DistributionVo>> getDistribution(@RequestBody DistributionDTO distributionDTO) {
        log.info("getdatalinksDistribution");
        return Result.success(dataLinksService.getDataLinksDistribution(distributionDTO));
    }

    @PostMapping("/statistics")
    public Result<List<StatisticsVo>> getStatistics(@RequestBody StatisticsDTO statisticsDTO) {
        log.info("getstatistics");
        return Result.success(dataLinksService.getDataLinkStatistics(statisticsDTO));
    }


}
