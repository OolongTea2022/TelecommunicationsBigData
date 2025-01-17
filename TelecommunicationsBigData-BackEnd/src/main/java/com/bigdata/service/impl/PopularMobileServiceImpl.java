package com.bigdata.service.impl;

import com.bigdata.dao.PopularMobileMapper;
import com.bigdata.model.dto.*;
import com.bigdata.model.entity.PopularMobile.*;
import com.bigdata.service.PopularMobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class PopularMobileServiceImpl implements PopularMobileService {
    @Autowired
    private PopularMobileMapper popularMobileMapper;

    @Override
    public List<PopularMobileTrafficDistribution> getPopularMobileTrafficDistribution(PopularMobileTrafficDistributionDTO dto) {
        return popularMobileMapper.getPopularMobileTrafficDistribution(dto);
    }


    @Override
    public List<PopularMobileQualityRank> getPopularMobileQualityRankRank(PopularMobileQualityRankDTO popularMobileQualityRankDTO) {
        return popularMobileMapper.getPopularMobileQualityRankRank(popularMobileQualityRankDTO);
    }

    @Override
    public List<PopularMobileTrafficRank> getPopularMobileTrafficRank(PopularMobileTrafficRankDTO dto) {
        return popularMobileMapper.getPopularMobileTrafficRank(dto);
    }

    @Override
    public List<PopularMobileOSTrafficRank> getPopularMobileOSTrafficRank(PopularMobileOSTrafficRankDTO dto) {
        return popularMobileMapper.getPopularMobileOSTrafficRank(dto);
    }

    @Override
    public List<PopularMobileDistribution> getPopularMobileDistribution(PopularMobileDistributionDTO dto) {
        return popularMobileMapper.getPopularMobileDistribution(dto);
    }

    @Override
    public List<MobileOSDistribution> getMobileOSDistribution(MobileOSDistributionDTO dto) {
        return popularMobileMapper.getMobileOSDistribution(dto);
    }
}
