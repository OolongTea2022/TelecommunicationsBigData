package com.bigdata.service.impl;

import com.bigdata.vo.DataLinks.DistributionVo;
import com.bigdata.vo.DataLinks.StatisticsVo;
import com.bigdata.dao.DataLinksMapper;
import com.bigdata.dto.DataLinks.DistributionDTO;
import com.bigdata.dto.DataLinks.StatisticsDTO;
import com.bigdata.model.entity.DataLinks.DataLinkStatistics;
import com.bigdata.model.entity.DataLinks.DataLinksDistribution;
import com.bigdata.service.DataLinksService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DataLinksServiceImpl implements DataLinksService {

    @Autowired
    private DataLinksMapper dataLinksMapper;

    @Override
    public List<DistributionVo> getDataLinksDistribution(DistributionDTO distributionDTO) {
        List<DataLinksDistribution> dataLinksDistribution =  dataLinksMapper.getDataLinksDistribution(distributionDTO);
        List<DistributionVo> result = dataLinksDistribution.parallelStream()
                .map(item ->{
                    DistributionVo vo = new DistributionVo();
                    BeanUtils.copyProperties(item, vo);
                    return vo;
                }).collect(Collectors.toList());
        return result;
    }

    @Override
    public List<StatisticsVo> getDataLinkStatistics(StatisticsDTO statisticsDTO) {
        log.info(String.valueOf(statisticsDTO.getStartDate()));
        log.info(String.valueOf(statisticsDTO.getEndDate()));
        List<DataLinkStatistics> dataLinkStatistics = dataLinksMapper.getDataLinkStatistics(statisticsDTO);
        List<StatisticsVo> result = dataLinkStatistics.parallelStream()
                .map(item->{
                    StatisticsVo vo = new StatisticsVo();
                    BeanUtils.copyProperties(item, vo);
                    return vo;
                }).collect(Collectors.toList());
        return result;
    }
}