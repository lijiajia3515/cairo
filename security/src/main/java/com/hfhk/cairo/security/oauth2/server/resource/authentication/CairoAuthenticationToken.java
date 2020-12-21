package com.hfhk.cairo.security.oauth2.server.resource.authentication;


import com.hfhk.cairo.security.authentication.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.oidc.IdTokenClaimNames;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Collection;
import java.util.Map;

/**
 * Cairo Token(Jwt OAuth2 Token)
 */
public class CairoAuthenticationToken extends JwtAuthenticationToken {
	private User user;

	/**
	 * @param jwt jwt
	 */
	public CairoAuthenticationToken(Jwt jwt) {
		super(jwt);
	}

	/**
	 * @param jwt         jwt
	 * @param authorities authorities
	 */
	public CairoAuthenticationToken(Jwt jwt, Collection<? extends GrantedAuthority> authorities) {
		super(jwt, authorities);
	}

	/**
	 * @param jwt         jwt
	 * @param authorities authorities
	 */
	public CairoAuthenticationToken(Jwt jwt, Collection<? extends GrantedAuthority> authorities, User user) {
		super(jwt, authorities);
		this.user = user;
	}

	@Override
	public Map<String, Object> getTokenAttributes() {
		return this.getToken().getClaims();
	}

	@Override
	public String getPrincipal() {
		return (String) super.getPrincipal();
	}

	@Override
	public String getCredentials() {
		return (String) super.getCredentials();
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return super.getAuthorities();
	}

	public String getClient() {
		return super.getToken().getClaimAsString(IdTokenClaimNames.AZP);
	}
}
