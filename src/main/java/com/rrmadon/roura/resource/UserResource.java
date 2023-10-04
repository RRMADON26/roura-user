package com.rrmadon.roura.resource;

import com.rrmadon.roura.model.entity.User;
import com.rrmadon.roura.service.UserService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@RequestScoped
@Path("/users")
@RolesAllowed("CUSTOMER")
public class UserResource {

	@Inject
	UserService userService;

	@GET
	public User getUserCode() {
		return userService.getUser();
	}

}
