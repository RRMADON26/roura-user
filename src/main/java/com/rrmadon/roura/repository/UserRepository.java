package com.rrmadon.roura.repository;

import com.rrmadon.roura.model.entity.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;


@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {
	public Optional<User> findOptionalUser(String email) {
		return find("email", email).firstResultOptional();
	}
}
