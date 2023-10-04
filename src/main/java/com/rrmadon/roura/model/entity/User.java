package com.rrmadon.roura.model.entity;

import com.rrmadon.roura.enumiration.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "user", uniqueConstraints =
		{@UniqueConstraint(name = "UniqueEmailAndFirebaseId", columnNames = {"email", "firebaseId"})})
public class User extends BaseEntity {
	@Id
	@GeneratedValue
	private Long id;
	private String code;

	private String email;

	private String fullname;

	private String username;

	private boolean completed;

	private String firebaseId;

	private UserRole role = UserRole.CUSTOMER;

}
