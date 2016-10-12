package com.qiu.dmp.service.impl;


import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;
import com.qiu.dmp.model.User;
import com.qiu.dmp.service.RsUserService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Administrator on 2016/8/16.
 */
@Path("users")
public class RsUserServiceImpl implements RsUserService {
    @POST
    @Path("register")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
    @Override
    public User registerUser(@BeanParam User user) {
        user = new User();
        user.setUsername("hello test11111");
        return user;
    }
}
