package com.rrmadon.roura.resource;

import com.google.firebase.auth.FirebaseAuthException;
import com.rrmadon.roura.service.AuthorizationService;
import io.quarkus.security.Authenticated;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

@RequestScoped
@Path("/v1/auth")
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {


	@Inject
	AuthorizationService authorizationService;

	@GET()
	@Path("/validate")
	@Authenticated
	/**
	 * This function will decide whether the client needs to refresh the ID token or not.
	 */
	public boolean auth() throws FirebaseAuthException {
		return authorizationService.authorize();
	}
}
