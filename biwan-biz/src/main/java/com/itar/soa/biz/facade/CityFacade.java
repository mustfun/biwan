package com.itar.soa.biz.facade;

import com.itar.soa.biz.support.result.BaseResult;

/**
 * Created by dengzhiyuan on 2017/4/6.
 */
public interface CityFacade {

    BaseResult<String> getCity(Integer id);
}
