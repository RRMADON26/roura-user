package com.rrmadon.roura.service;

import com.google.firebase.auth.FirebaseAuthException;
import com.rrmadon.roura.model.dto.TokenResponse;
import com.rrmadon.roura.model.entity.User;
import com.rrmadon.roura.repository.UserRepository;
import com.rrmadon.roura.util.AuthenticationUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.extern.jbosslog.JBossLog;
import org.eclipse.microprofile.jwt.Claims;

import java.util.Optional;
import java.util.StringTokenizer;

import static com.rrmadon.roura.util.CodeUtil.generate;

@ApplicationScoped
@JBossLog
public class AuthorizationService extends AuthenticationUtil {

	@Inject
	UserRepository userRepository;

	@Inject
	FirebaseService firebaseService;

	@Transactional
	public boolean authorize() throws FirebaseAuthException {
		Optional<User> userOptional = userRepository.findOptionalUser(getAuth().getClaim(Claims.email));

		if (userOptional.isEmpty()) {
			log.info("Authenticating .. " + getAuth().getClaim(Claims.email));

			persist();
			return firebaseService.customizeToken();
		} else {
			return false;
		}
	}

	public void persist() {
		User user = new User();

		StringTokenizer stringTokenizer = new StringTokenizer(getAuth().getClaim(Claims.email), "@");

		user.setUsername(stringTokenizer.nextToken());
		user.setCode(generate());
		user.setEmail(getAuth().getClaim(Claims.email));
		user.setFirebaseId(getAuth().getSubject());

		userRepository.persist(user);
	}

}
