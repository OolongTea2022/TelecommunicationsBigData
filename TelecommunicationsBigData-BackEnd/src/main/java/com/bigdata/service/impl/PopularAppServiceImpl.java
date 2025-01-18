package com.bigdata.service.impl;


import com.bigdata.model.dto.PopularApp.*;
import com.bigdata.model.vo.PopularApp.*;
import com.bigdata.dao.PopularAppMapper;
import com.bigdata.model.entity.PopularApp.*;
import com.bigdata.service.PopularAppService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PopularAppServiceImpl implements PopularAppService {
    @Autowired
    private PopularAppMapper PopularAppMapper;

    public long checkTime(long times){
        if(times >= 1000000000){
            return times / 100;
        }
        return times;
    }

    @Override
    public List<AppDistributionVo> getDistribution(AppDistributionDTO appDistributionDTO) {
        appDistributionDTO.setStartDate(checkTime(appDistributionDTO.getStartDate()));
        appDistributionDTO.setEndDate(checkTime(appDistributionDTO.getEndDate()));
        List<PopularAppDistribution> popularAppDistribution =  PopularAppMapper.getDistribution(appDistributionDTO);
        log.info(String.valueOf(popularAppDistribution.size()));
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
        appDistributionDTO.setStartDate(checkTime(appDistributionDTO.getStartDate()));
        appDistributionDTO.setEndDate(checkTime(appDistributionDTO.getEndDate()));
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
        trafficRankDTO.setStartDate(checkTime(trafficRankDTO.getStartDate()));
        trafficRankDTO.setEndDate(checkTime(trafficRankDTO.getEndDate()));
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
        trafficTrackingDTO.setStartDate(checkTime(trafficTrackingDTO.getStartDate()));
        trafficTrackingDTO.setEndDate(checkTime(trafficTrackingDTO.getEndDate()));
        log.info(String.valueOf(trafficTrackingDTO.getStartDate()));
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
    public List<TypeTrafficVo> getTypicalLandmarkAppTrafficRank(TypeTrafficDTO typicalLandmarkAppTrafficRankDTO) {
        typicalLandmarkAppTrafficRankDTO.setStartDate(checkTime(typicalLandmarkAppTrafficRankDTO.getStartDate()));
        typicalLandmarkAppTrafficRankDTO.setEndDate(checkTime(typicalLandmarkAppTrafficRankDTO.getEndDate()));
        List<TypicalLandmarkAppTrafficRank> typicalLandmarkAppTrafficRank = PopularAppMapper.getTypicalLandmarkAppTrafficRank(typicalLandmarkAppTrafficRankDTO);
        List<TypeTrafficVo> result = typicalLandmarkAppTrafficRank.parallelStream()
                .map(item -> {
                    TypeTrafficVo vo = new TypeTrafficVo();
                    BeanUtils.copyProperties(item, vo);
                    return vo;
                }).collect(Collectors.toList());
        return result;
    }
    @Override
    public List<UserDistributionVo> getUserDIstribution(UserDistributionDTO userDistributionDTO) {

        List<PopularAppUserDistribution> popularAppUserDIstribution = PopularAppMapper.getUserDIstribution(userDistributionDTO);
        List<UserDistributionVo> result = popularAppUserDIstribution.parallelStream()
                .map(item -> {
                    UserDistributionVo vo = new UserDistributionVo();
                    BeanUtils.copyProperties(item, vo);
                    return vo;
                }).collect(Collectors.toList());
        return result;
    }
}
