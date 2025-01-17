package com.bigdata.controller;

import com.bigdata.model.entity.DataLinks.DataLinksDistribution;
import com.bigdata.model.entity.DataLinks.DataLinkStatistics;
import com.bigdata.service.DataLinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dataLinks")
public class DataLinksController {

    @Autowired
    private DataLinksService dataLinksService;

    @GetMapping("/getDataLinksDistribution")
    @ResponseBody
    public List<DataLinksDistribution> getDataLinksDistribution(
            @RequestParam(required = false) String networkType,
            @RequestParam(required = false) String networkName,
            @RequestParam(required = false) String userLat,
            @RequestParam(required = false) String userLon,
            @RequestParam(required = false) String mobileNetworkType) {
        return dataLinksService.getDataLinksDistribution(networkType, networkName, userLat, userLon, mobileNetworkType);
    }

    @GetMapping("/getDataLinkStatistics")
    @ResponseBody
    public List<DataLinkStatistics> getDataLinkStatistics(
            @RequestParam(required = false) String networkName,
            @RequestParam(required = false) String networkType,
            @RequestParam(required = false) Long tcount) {
        return dataLinksService.getDataLinkStatistics(networkType, networkName, tcount);
    }
}