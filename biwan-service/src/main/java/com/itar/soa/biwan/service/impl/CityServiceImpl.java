package com.itar.soa.biwan.service.impl;

import com.dangdang.ddframe.rdb.sharding.api.HintManager;
import com.itar.soa.biwan.dao.mapper.CityMapper;
import com.itar.soa.biwan.model.City;
import com.itar.soa.biwan.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dengzhiyuan on 2017/4/6.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public City getOne(Integer id) {
        //强制切换路由为主库
//        HintManager hintManager = HintManager.getInstance();
//        hintManager.setMasterRouteOnly();

        /**
         * 没有上面这句话时候会去读从库，加了之后会去读主库
         */

        return cityMapper.selectByPrimaryKey(id);
    }
}
