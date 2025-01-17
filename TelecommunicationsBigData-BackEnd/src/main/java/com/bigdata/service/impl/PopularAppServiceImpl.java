package com.bigdata.service.impl;


import com.bigdata.dao.PopularAppMapper;
import com.bigdata.model.entity.PopularApp.*;
import com.bigdata.service.PopularAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PopularAppServiceImpl implements PopularAppService {
    @Autowired
    private PopularAppMapper PopularAppMapper;

    @Override
    public List<PopularAppDistribution> getDistribution() {
        return PopularAppMapper.getDistribution();
    }

    @Override
    public List<PopularAppTrafficDistribution> getTrafficDistribution() {
        return this.PopularAppMapper.getTrafficDistribution();
    }

    @Override
    public List<PopularAppTrafficRank> getTrafficRank() {
        return this.PopularAppMapper.getTrafficRank();
    }

    @Override
    public List<PopularAppTrafficTracking> getTrafficTracking() {
        return this.PopularAppMapper.getTrafficTracking();
    }

    @Override
    public List<PopularAppUserDIstribution> getUserDIstribution() {
        return this.PopularAppMapper.getUserDIstribution();
    }

    @Override
    public List<TypicalLandmarkAppTrafficRank> getTypicalLandmarkAppTrafficRank() {
        return this.PopularAppMapper.getTypicalLandmarkAppTrafficRank();
    }

}
