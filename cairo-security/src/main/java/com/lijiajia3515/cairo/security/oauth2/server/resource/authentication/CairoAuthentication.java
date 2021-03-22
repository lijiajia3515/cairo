package com.lijiajia3515.cairo.security.oauth2.server.resource.authentication;


import com.lijiajia3515.cairo.security.oauth2.user.AuthPrincipal;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Collection;
import java.util.Map;

/**
 * Cairo Authentication
 */
public class CairoAuthentication extends JwtAuthenticationToken {

	/**
	 * @param principal principal
	 */
	public CairoAuthentication(AuthPrincipal principal) {
		super(principal);
	}

	/**
	 * @param principal   principal
	 * @param authorities authorities
	 */
	public CairoAuthentication(Jwt principal, Collection<? extends GrantedAuthority> authorities) {
		super(principal, authorities);
	}

	/**
	 * @param principal   principal
	 * @param authorities authorities
	 */
	public CairoAuthentication(AuthPrincipal principal, Collection<? extends GrantedAuthority> authorities) {
		super(principal, authorities);
	}

	@Override
	public Map<String, Object> getTokenAttributes() {
		return this.getToken().getClaims();
	}

	@Override
	public AuthPrincipal getPrincipal() {
		return (AuthPrincipal) super.getPrincipal();
	}

	@Override
	public AuthPrincipal getCredentials() {
		return (AuthPrincipal) super.getCredentials();
	}

}
