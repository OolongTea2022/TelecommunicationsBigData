package com.bigdata.service.impl;


import com.bigdata.VO.NetworkQuality.NwQualityStatisticsVo;
import com.bigdata.VO.PopularApp.*;
import com.bigdata.dao.PopularAppMapper;
import com.bigdata.dto.PopularApp.*;
import com.bigdata.model.entity.NetworkQuality.NwQualityStatistics;
import com.bigdata.model.entity.PopularApp.*;
import com.bigdata.service.PopularAppService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PopularAppServiceImpl implements PopularAppService {
    @Autowired
    private PopularAppMapper PopularAppMapper;

    @Override
    public List<AppDistributionVo> getDistribution(AppDistributionDTO appDistributionDTO) {
        List<PopularAppDistribution> popularAppDistribution =  PopularAppMapper.getDistribution(appDistributionDTO);
        List<AppDistributionVo> result = popularAppDistribution.parallelStream()
                .map(item ->{
                    AppDistributionVo vo = new AppDistributionVo();
                    BeanUtils.copyProperties(item, vo);
                    return vo;
                }).collect(Collectors.toList());
        return result;
    }

    @Override
    public List<AppDistributionVo> getTrafficDistribution(AppDistributionDTO appDistributionDTO) {
        List<PopularAppTrafficDistribution> popularAppDistribution = PopularAppMapper.getTrafficDistribution(appDistributionDTO);
        List<AppDistributionVo> result = popularAppDistribution.parallelStream()
                .map(item -> {
                    AppDistributionVo vo = new AppDistributionVo();
                    BeanUtils.copyProperties(item, vo);
                    return vo;
                }).collect(Collectors.toList());
        return result;
    }

    @Override
    public List<TrafficRankVo> getTrafficRank(TrafficRankDTO trafficRankDTO) {
        List<PopularAppTrafficRank> popularAppTrafficRank = PopularAppMapper.getTrafficRank(trafficRankDTO);
        List<TrafficRankVo> result = popularAppTrafficRank.parallelStream()
                .map(item -> {
                    TrafficRankVo vo = new TrafficRankVo();
                    BeanUtils.copyProperties(item, vo);
                    return vo;
                }).collect(Collectors.toList());
        return result;
    }

    @Override
    public List<TrafficTrackingVo> getTrafficTracking(TrafficTrackingDTO trafficTrackingDTO) {
        List<PopularAppTrafficTracking> popularAppTrafficTracking = PopularAppMapper.getTrafficTracking(trafficTrackingDTO);
        List<TrafficTrackingVo> result = popularAppTrafficTracking.parallelStream()
                .map(item -> {
                    TrafficTrackingVo vo = new TrafficTrackingVo();
                    BeanUtils.copyProperties(item, vo);
                    return vo;
                }).collect(Collectors.toList());
        return result;
    }

    @Override
    public List<UserDistributionVo> getUserDIstribution(UserDistributionDTO userDistributionDTO) {
        List<PopularAppUserDIstribution> popularAppUserDIstribution = PopularAppMapper.getUserDIstribution(userDistributionDTO);
        List<UserDistributionVo> result = popularAppUserDIstribution.parallelStream()
                .map(item -> {
                    UserDistributionVo vo = new UserDistributionVo();
                    BeanUtils.copyProperties(item, vo);
                    return vo;
                }).collect(Collectors.toList());
        return result;
    }

    @Override
    public List<TypeTrafficVo> getTypicalLandmarkAppTrafficRank(TypeTrafficDTO typicalLandmarkAppTrafficRankDTO) {
        List<TypicalLandmarkAppTrafficRank> typicalLandmarkAppTrafficRank = PopularAppMapper.getTypicalLandmarkAppTrafficRank(typicalLandmarkAppTrafficRankDTO);
        List<TypeTrafficVo> result = typicalLandmarkAppTrafficRank.parallelStream()
                .map(item -> {
                    TypeTrafficVo vo = new TypeTrafficVo();
                    BeanUtils.copyProperties(item, vo);
                    return vo;
                }).collect(Collectors.toList());
        return result;
    }

}
