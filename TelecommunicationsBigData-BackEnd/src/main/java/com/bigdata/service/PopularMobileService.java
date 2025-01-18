package com.bigdata.service;

import com.bigdata.model.dto.*;
import com.bigdata.model.entity.PopularMobile.*;

import java.util.List;

/**
 *
 */
public interface PopularMobileService {

    List<PopularMobileTrafficDistribution> getPopularMobileTrafficDistribution(PopularMobileTrafficDistributionDTO dto);

    List<PopularMobileQualityRank> getPopularMobileQualityRankRank(PopularMobileQualityRankDTO popularMobileQualityRankDTO);


    List<PopularMobileTrafficRank> getPopularMobileTrafficRank(PopularMobileTrafficRankDTO dto);

    // 手机OS流量排名
    List<PopularMobileOSTrafficRank> getPopularMobileOSTrafficRank(PopularMobileOSTrafficRankDTO dto);

    // 热门手机分布图
    List<PopularMobileDistribution> getPopularMobileDistribution(PopularMobileDistributionDTO dto);

    // 手机OS分布图
    List<MobileOSDistribution> getMobileOSDistribution(MobileOSDistributionDTO dto);
}
