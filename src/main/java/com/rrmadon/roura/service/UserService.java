package com.rrmadon.roura.service;

import com.rrmadon.roura.model.entity.User;
import com.rrmadon.roura.repository.UserRepository;
import com.rrmadon.roura.util.AuthenticationUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import org.eclipse.microprofile.jwt.Claims;

@ApplicationScoped
public class UserService extends AuthenticationUtil {

	@Inject
	UserRepository userRepository;

	public User getUser () {
		return userRepository.findOptionalUser(getAuth().getClaim(Claims.email)).orElseThrow(NotFoundException::new);
	}
}
