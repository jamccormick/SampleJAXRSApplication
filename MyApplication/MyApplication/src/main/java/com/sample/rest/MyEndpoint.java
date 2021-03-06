package com.sample.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.sample.dao.HelloDAO;


@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/rest")
public class MyEndpoint {
	
	@Inject
	private HelloDAO dao;
	
	@Path("/sayHello")
	@GET
	public Response sayHello()
	{
		try {
			String greeting = dao.getGreeting();
			return Response.ok(greeting).build();
		} catch (NullPointerException npe) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	@Path("/postHello")
	@POST
	public Response postHello(@QueryParam("message") String message) {
		return Response.ok(dao.postGreeting(message)).build();
	}
	
}
