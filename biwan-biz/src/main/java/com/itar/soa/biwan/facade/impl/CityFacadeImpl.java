package com.itar.soa.biwan.facade.impl;

import com.itar.soa.biwan.facade.CityFacade;
import com.itar.soa.biwan.model.City;
import com.itar.soa.biwan.service.CityService;
import com.itar.soa.biwan.support.result.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by dengzhiyuan on 2017/4/6.
 */
@Component("cityFacade")
@Path("city")
public class CityFacadeImpl implements CityFacade {

    @Autowired
    private CityService cityService;

    @Override
    @Path("/get/{id}")
    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public BaseResult<City> getCity(@PathParam("id") Integer id) {
        City one = cityService.getOne(id);
        BaseResult<City> baseResult=new BaseResult<>();
        baseResult.setData(one);
        return baseResult;
    }
}
