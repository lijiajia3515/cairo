package com.hfhk.cairo.security.oauth2.server.resource.authentication;

import com.hfhk.cairo.security.authentication.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public interface AuthenticationHolder {

	User findUser(String client, String id);

	Collection<GrantedAuthority> findUserAuthority(String client, String user);
}
