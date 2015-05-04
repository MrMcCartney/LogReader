package com.securitycompany.cardswipe.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/read-log")
@Produces(MediaType.APPLICATION_JSON)
public class LogReaderResource {
    private final AtomicLong counter;

    public LogReaderResource() {
        this.counter = new AtomicLong();
    }

    @GET
    public Saying sayHello() {
    	    
    }
}
