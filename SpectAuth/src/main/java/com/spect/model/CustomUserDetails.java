package com.spect.model;

import java.util.Collection;

import org.springframework.security.core.userdetails.User;

public class CustomUserDetails extends User {
	private static final long serialVersionUID = -3531439484732724601L;
	private int userId;

	public CustomUserDetails(int userId, String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked, Collection authorities) {
		
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.userId = userId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
