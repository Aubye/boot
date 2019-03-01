package com.app.index.service;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/user")
public interface UserService {

    @POST
    @Path("/init")
    void init();

}
