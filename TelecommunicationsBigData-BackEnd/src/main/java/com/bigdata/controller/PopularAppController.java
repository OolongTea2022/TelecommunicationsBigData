package com.bigdata.controller;

import com.bigdata.model.entity.PopularApp.*;
import com.bigdata.service.PopularAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PopularAppController {

    @Autowired
    private PopularAppService PopularAppService;

    @RequestMapping("/getPopularAppTrafficDistribution")
    @ResponseBody
    public List<PopularAppTrafficDistribution> getPopularAppTrafficDistributionList() {
        return PopularAppService.getTrafficDistribution();
    }//流量分布


    @RequestMapping("/getPopularAppDistribution")
    @ResponseBody
    public List<PopularAppDistribution> getPopularAppDistributionList() {
        return PopularAppService.getDistribution();
    }//热门app分布


    @RequestMapping("/getTrafficRank")
    @ResponseBody
    public List<PopularAppTrafficRank> getTrafficRank() {
        return PopularAppService.getTrafficRank();
    }//前10流量的热门app

    @RequestMapping("/getTrafficTracking")
    @ResponseBody
    public List<PopularAppTrafficTracking> getTrafficTracking() {
        return PopularAppService.getTrafficTracking();
    }//流量记录

    @RequestMapping("/getAppUserDistribution")
    @ResponseBody
    public List<PopularAppUserDIstribution> getAppUserDIstribution() {
        return PopularAppService.getUserDIstribution();
    }//热门app用户分布

    @RequestMapping("/getTypicalLandmarkAppTrafficRank")
    @ResponseBody
    public List<TypicalLandmarkAppTrafficRank> getTypicalLandmarkAppTrafficRank() {
        return PopularAppService.getTypicalLandmarkAppTrafficRank();
    }//热门app用户分布
}