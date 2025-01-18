package com.bigdata.dao;

import com.bigdata.model.dto.PopularMobile.*;
import com.bigdata.model.entity.PopularMobile.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *
 */
public interface PopularMobileMapper {
    // 获取热门手机流量Top5
    List<PopularMobileDistribution> getTop5PopularMobileTraffic(@Param("dto") PopularMobileTrafficDistributionTop5DTO dto);

    // 热门手机流量分布
    List<PopularMobileTrafficDistribution> getPopularMobileTrafficDistribution(@Param("dto") PopularMobileTrafficDistributionDTO dto);

    // 热门手机网络质量排名
    List<PopularMobileQualityRank> getPopularMobileQualityRankRank(@Param("dto") PopularMobileQualityRankDTO popularMobileQualityRankDTO);

    // 热门手机流量排名
    List<PopularMobileTrafficRank> getPopularMobileTrafficRank(@Param("dto") PopularMobileTrafficRankDTO popularMobileTrafficRankDTO);

    // 手机OS流量排名
    List<PopularMobileOSTrafficRank> getPopularMobileOSTrafficRank(@Param("dto") PopularMobileOSTrafficRankDTO dto);

    // 热门手机分布图
    List<PopularMobileDistribution> getPopularMobileDistribution(@Param("dto") PopularMobileDistributionDTO dto);

    // 手机OS分布图
    List<MobileOSDistribution> getMobileOSDistribution(@Param("dto") MobileOSDistributionDTO dto);
}
