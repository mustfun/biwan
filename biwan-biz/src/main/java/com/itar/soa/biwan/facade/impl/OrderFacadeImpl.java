package com.itar.soa.biwan.facade.impl;

import com.itar.soa.biwan.facade.CityFacade;
import com.itar.soa.biwan.facade.OrderFacade;
import com.itar.soa.biwan.model.City;
import com.itar.soa.biwan.model.Order;
import com.itar.soa.biwan.service.CityService;
import com.itar.soa.biwan.service.OrderService;
import com.itar.soa.biwan.support.result.BaseResult;
import com.sun.tools.corba.se.idl.constExpr.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by dengzhiyuan on 2017/4/6.
 */
@Component("orderFacade")
@Path("order")
public class OrderFacadeImpl implements OrderFacade {

    @Autowired
    private OrderService orderService;

    @Override
    @Path("/get/{id}")
    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    public BaseResult<Order> getOrder (@PathParam("id") Integer id) {
        Order one = orderService.getOne(id);
        BaseResult<Order> baseResult=new BaseResult<>();
        baseResult.setData(one);
        return baseResult;
    }

    @Path("/getList")
    @Override
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public BaseResult<List<Order>> getOrderListByIds(@RequestBody List<Integer> ids) {

        BaseResult<List<Order>> baseResult=new BaseResult<>();
        List<Order> orders = orderService.selectByIdList(ids);
        baseResult.setData(orders);
        return baseResult;
    }
}
