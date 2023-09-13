package com.rrmadon.roura.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rrmadon.roura.model.dto.TokenResponse;
import com.rrmadon.roura.service.AuthorizationService;
import com.rrmadon.roura.util.AuthenticationUtil;
import io.quarkus.security.Authenticated;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.logging.Logger;

@RequestScoped
@Path("/v1/auth")
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {


	@Inject
	AuthorizationService authorizationService;

	@Inject
	ObjectMapper objectMapper;

	private final Logger logger = Logger.getLogger(AuthResource.class);

	@GET
	@Authenticated
	public TokenResponse auth() {
		logger.info("Authenticating : " + authorizationService.getAuth().getClaim(Claims.email));

		TokenResponse response = authorizationService.authorize();

		logger.info("Authenticated : " + authorizationService.getAuth().getClaim(Claims.email));

		return response;
	}
}
