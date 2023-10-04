package com.rrmadon.roura.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.internal.FirebaseCustomAuthToken;
import com.rrmadon.roura.repository.UserRepository;
import com.rrmadon.roura.util.AuthenticationUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import lombok.extern.jbosslog.JBossLog;
import org.eclipse.microprofile.jwt.Claims;

import java.util.HashMap;

@ApplicationScoped
@JBossLog
public class FirebaseService extends AuthenticationUtil {

	@Inject
	UserRepository userRepository;

	@Inject
	ObjectMapper mapper;

	public boolean customizeToken() throws FirebaseAuthException {
		var decodedToken = FirebaseAuth.getInstance().verifyIdToken(getAuth().getRawToken());

		var user = userRepository.findOptionalUser(getAuth().getClaim(Claims.email)).orElseThrow(() -> new NotFoundException("Failed"));

		var additional = new HashMap<String, Object>();

		additional.put("groups", new String[]{user.getRole().name()});

		FirebaseAuth.getInstance().setCustomUserClaims(decodedToken.getUid(), additional);

		return true;
	}


}
