package com.excilys.rest;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.excilys.bean.ComputerService;

@Component(value = "computerWS")
@Path("/computer")
public class ComputerServiceRS {

	@Autowired
	@Qualifier("computerS")
	ComputerService computerService;

	@GET
	@Path("/getAll")
	@Produces("application/xml")
	public Response getAll() {
		return Response.status(200).entity(computerService.getAll()).build();
	}

}
