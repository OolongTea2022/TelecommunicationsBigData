package com.bigdata.service.impl;

import com.bigdata.model.dto.nwQuality.*;
import com.bigdata.model.vo.NetworkQuality.*;
import com.bigdata.dao.NwQualityMapper;
import com.bigdata.model.entity.NetworkQuality.*;
import com.bigdata.service.NwQualityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class NwQualityServiceImpl implements NwQualityService {

    @Autowired
    private NwQualityMapper nwQualityMapper;


    @Override
    public List<NwQualityDistributionVo> getDistribution(DistributionDTO distributionDTO) {
        log.info(distributionDTO.toString());
        double llat = Double.parseDouble(distributionDTO.getLlat());
        double rlat = Double.parseDouble(distributionDTO.getRlat());
        double ulon = Double.parseDouble(distributionDTO.getUlon());
        double dlon = Double.parseDouble(distributionDTO.getDlon());
        double cellSizeLat = (rlat - llat)/50;
        double cellSizeLon = (ulon - dlon)/50;
        List<NwQualityDistribution> list = nwQualityMapper.getDistribution(distributionDTO);
        log.info(String.valueOf(list.size()));
        double[][] result = new double[51][51];
        double[][] number = new double[51][51];

        list.forEach(item->{
            int lnumber = (int) ((Double.parseDouble(item.getUserLat()) - llat)/cellSizeLat);
            int dnumber = (int) ((Double.parseDouble(item.getUserLon()) - dlon)/cellSizeLon);
            result[lnumber][dnumber] = (result[lnumber][dnumber] * number[lnumber][dnumber] + item.getSpeed())/(number[lnumber][dnumber]+1);
            number[lnumber][dnumber] = number[lnumber][dnumber]+1;
        });
        List<NwQualityDistributionVo> res = new ArrayList<>();
        for(int i = 0; i < 51; i++) {
            for(int j = 0; j < 51; j++) {
                NwQualityDistributionVo vo = new NwQualityDistributionVo();
                vo.setUserLat(i);
                vo.setUserLon(j);
                vo.setSpeed( result[i][j] /50);
                res.add(vo);
            }
        }

        log.info(String.valueOf(res.size()));
        return res;
    }

    @Override
    public List<NwQualityStatisticsVo> getQualityStatistics(QualityStatisticsDTO statisticsDTO) {

        List<NwQualityStatistics> nwQualityStatistics =  nwQualityMapper.getStatistics(statisticsDTO);
        List<NwQualityStatisticsVo> result = nwQualityStatistics.parallelStream()
                .map(item ->{
                    NwQualityStatisticsVo vo = new NwQualityStatisticsVo();
                    BeanUtils.copyProperties(item, vo);
                    return vo;
                }).collect(Collectors.toList());
        log.info(String.valueOf(result.size()));
        return result;
    }

    @Override
    public List<NwSpeedRankVo> getRank(SpeedRankDTO speedRankDTO) {
        List<NwSpeedRank> ranks = nwQualityMapper.getRanks(speedRankDTO);
        List<NwSpeedRankVo> result = ranks.parallelStream()
                .map(item->{
                    NwSpeedRankVo vo = new NwSpeedRankVo();
                    BeanUtils.copyProperties(item, vo);
                    return vo;
                }).collect(Collectors.toList());
        log.info(String.valueOf(result.size()));
        return result;
    }

    @Override
    public List<TypicalNWQualityTrackingVo> getTypicalTracking(NwTrackingDTO trackingDTO) {
        List<TypicalNWQualityTracking> trackings = nwQualityMapper.getTypicalTracking(trackingDTO);
        List<TypicalNWQualityTrackingVo> result = trackings.parallelStream()
                .map(item -> {
                    TypicalNWQualityTrackingVo vo = new TypicalNWQualityTrackingVo();
                    BeanUtils.copyProperties(item, vo);
                    return vo;
                }).collect(Collectors.toList());
        log.info(String.valueOf(result.size()));
        return result;
    }

    @Override
    public List<TypicalNWQualityStatisticsVo> getLandmarkStatistics(LandmarkQualityStatisticsDTO statisticsDTO) {
        List<TypicalNWQualityStatistics> Statistics = nwQualityMapper.getLandmarkStatistics(statisticsDTO);
        List<TypicalNWQualityStatisticsVo> result = Statistics.parallelStream()
                .map(item -> {
                    TypicalNWQualityStatisticsVo vo = new TypicalNWQualityStatisticsVo();
                    BeanUtils.copyProperties(item, vo);
                    return vo;
                }).collect(Collectors.toList());
        log.info(String.valueOf(result.size()));
        return result;
    }
}
