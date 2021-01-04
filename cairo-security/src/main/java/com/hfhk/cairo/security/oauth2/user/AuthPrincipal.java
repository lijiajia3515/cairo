package com.hfhk.cairo.security.oauth2.user;

import com.hfhk.cairo.domain.auth.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.oauth2.jwt.Jwt;

public class AuthPrincipal extends Jwt {
	@Getter
	@Setter
	private User user;

	/**
	 * @param jwt jwt
	 */
	public AuthPrincipal(Jwt jwt) {
		super(jwt.getTokenValue(), jwt.getIssuedAt(), jwt.getExpiresAt(), jwt.getHeaders(), jwt.getClaims());
		this.user = null;
	}

	/**
	 * @param jwt jwt
	 * @param user user
	 */
	public AuthPrincipal(Jwt jwt, User user) {
		super(jwt.getTokenValue(), jwt.getIssuedAt(), jwt.getExpiresAt(), jwt.getHeaders(), jwt.getClaims());
		this.user = user;
	}

	public String getClient() {
		return getAudience().stream().findFirst().orElse("default");
	}
}
