package com.rrmadon.roura.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenResponse {

	private String token;
	private long expirationTime;
}
