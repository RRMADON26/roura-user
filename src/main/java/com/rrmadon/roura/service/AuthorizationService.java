package com.rrmadon.roura.service;

import com.rrmadon.roura.model.dto.TokenResponse;
import com.rrmadon.roura.model.entity.User;
import com.rrmadon.roura.repository.UserRepository;
import com.rrmadon.roura.util.AuthenticationUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.jwt.Claims;

import java.util.Optional;

import static com.rrmadon.roura.util.CodeUtil.generate;

@ApplicationScoped
public class AuthorizationService extends AuthenticationUtil {

	@Inject
	UserRepository userRepository;

	@Transactional
	public TokenResponse authorize() {
		Optional<User> userOptional = userRepository.findOptionalUser(getAuth().getClaim(Claims.email));

		if (userOptional.isPresent()) {
			return assignRole(getAuth().getRawToken());

		} else {
			persist();
			// TODO : Publish to Notification
			return assignRole(getAuth().getRawToken());
		}
	}

	public void persist() {
		User user = new User();

		user.setCode(generate());
		user.setEmail(getAuth().getClaim(Claims.email));
		user.setFirebaseId(getAuth().getSubject());

		userRepository.persist(user);
	}

	private TokenResponse assignRole(String rawToken) {

		TokenResponse tokenResponse = new TokenResponse();

		tokenResponse.setToken(rawToken); // TODO : Add new role
		tokenResponse.setExpirationTime(getAuth().getExpirationTime());

		return tokenResponse;
	}

}
