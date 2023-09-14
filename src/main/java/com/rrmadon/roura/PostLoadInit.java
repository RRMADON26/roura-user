package com.rrmadon.roura;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.persistence.PostLoad;
import jakarta.ws.rs.WebApplicationException;
import lombok.extern.jbosslog.JBossLog;

import java.io.IOException;

import static java.util.Objects.requireNonNull;

@JBossLog
@ApplicationScoped
public class PostLoadInit {


	public void onStart(@Observes StartupEvent ev) throws IOException {
		if (FirebaseApp.getApps().isEmpty()) {
			setupFirebase();
		}
	}

	private void setupFirebase() throws IOException {
		log.info("Setting up Firebase");

		var inputStream = requireNonNull(getClass().getResourceAsStream("/firebase-key-dev.json"));

		try {
			FirebaseOptions options = FirebaseOptions.builder()
					.setCredentials(GoogleCredentials.fromStream(inputStream)).build();

			FirebaseApp.initializeApp(options);

			log.info("Firebase application has been initialized");
		} catch (WebApplicationException e) {
			log.warn("Unable to setup firebase");
		}
	}
}
