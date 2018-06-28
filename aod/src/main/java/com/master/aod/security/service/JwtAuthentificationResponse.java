package com.master.aod.security.service;

import java.io.Serializable;

public class JwtAuthentificationResponse implements Serializable {

	private static final long serialVersionUID = 1250166508152483573L;

	private final String token;

	public JwtAuthentificationResponse(String token) {
		this.token = token;
	}

	public String getToken() {
		return this.token;
	}

}
