package com.itar.soa.biwan.service.impl;

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
        return cityMapper.selectByPrimaryKey(id);
    }
}
