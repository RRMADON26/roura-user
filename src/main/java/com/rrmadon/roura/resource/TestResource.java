package com.rrmadon.roura.resource;

import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@RequestScoped
@Path("/v1/test")
public class TestResource {

	@GET
	@RolesAllowed("CUSTOMER")
	public String testAuthorization() {
		return "You're authenticated";
	}
}
