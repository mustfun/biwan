package com.itar.soa.biz.facade.impl;

import com.itar.soa.biz.facade.CityFacade;
import com.itar.soa.biz.support.result.BaseResult;
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


    @Override
    @Path("/get/{id}")
    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public BaseResult<String> getCity(@PathParam("id") Integer id) {
        return new BaseResult<>();
    }
}
