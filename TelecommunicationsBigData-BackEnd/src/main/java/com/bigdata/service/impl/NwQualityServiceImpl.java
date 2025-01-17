package com.bigdata.service.impl;

import com.bigdata.VO.NetworkQuality.NwQualityStatisticsVo;
import com.bigdata.VO.NetworkQuality.NwSpeedRankVo;
import com.bigdata.VO.NetworkQuality.TypicalNWQualityStatisticsVo;
import com.bigdata.VO.NetworkQuality.TypicalNWQualityTrackingVo;
import com.bigdata.dao.NwQualityMapper;
import com.bigdata.dto.nwQuality.LandmarkQualityStatisticsDTO;
import com.bigdata.dto.nwQuality.NwTrackingDTO;
import com.bigdata.dto.nwQuality.QualityStatisticsDTO;
import com.bigdata.dto.nwQuality.SpeedRankDTO;
import com.bigdata.model.entity.NetworkQuality.NwQualityStatistics;
import com.bigdata.model.entity.NetworkQuality.NwSpeedRank;
import com.bigdata.model.entity.NetworkQuality.TypicalNWQualityStatistics;
import com.bigdata.model.entity.NetworkQuality.TypicalNWQualityTracking;
import com.bigdata.service.NwQualityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NwQualityServiceImpl implements NwQualityService {

    @Autowired
    private NwQualityMapper nwQualityMapper;

    @Override
    public List<NwQualityStatisticsVo> getQualityStatistics(QualityStatisticsDTO statisticsDTO) {

        List<NwQualityStatistics> nwQualityStatistics =  nwQualityMapper.getStatistics(statisticsDTO);
        List<NwQualityStatisticsVo> result = nwQualityStatistics.parallelStream()
                .map(item ->{
                    NwQualityStatisticsVo vo = new NwQualityStatisticsVo();
                    BeanUtils.copyProperties(item, vo);
                    return vo;
                }).collect(Collectors.toList());
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
        return result;
    }
}
