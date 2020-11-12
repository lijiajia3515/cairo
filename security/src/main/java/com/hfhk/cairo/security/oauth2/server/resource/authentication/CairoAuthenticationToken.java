package com.hfhk.cairo.security.oauth2.server.resource.authentication;


import com.hfhk.cairo.security.authentication.Client;
import com.hfhk.cairo.security.authentication.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.AbstractOAuth2TokenAuthenticationToken;

import java.util.Collection;
import java.util.Map;

/**
 * Harpoon Token(Jwt OAuth2 Token)
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class CairoAuthenticationToken extends AbstractOAuth2TokenAuthenticationToken<Jwt> {

	private Client client;

	private User user;

	/**
	 * @param jwt         jwt
	 * @param client      client
	 * @param authorities 权限
	 */
	public CairoAuthenticationToken(Jwt jwt, Client client, Collection<? extends GrantedAuthority> authorities) {
		super(jwt, jwt.getTokenValue(), jwt.getTokenValue(), authorities);
		this.client = client;
		this.setAuthenticated(true);
	}

	/**
	 * @param jwt         jwt
	 * @param client      client
	 * @param user        user
	 * @param authorities 权限
	 */
	public CairoAuthenticationToken(Jwt jwt, Client client, User user, Collection<? extends GrantedAuthority> authorities) {
		super(jwt, jwt.getTokenValue(), jwt.getTokenValue(), authorities);
		this.client = client;
		this.user = user;
		this.setAuthenticated(true);
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Collection<GrantedAuthority> getAuthorities(){
		return super.getAuthorities();
	}
}
