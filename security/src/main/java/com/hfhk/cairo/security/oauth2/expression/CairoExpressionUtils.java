package com.hfhk.cairo.security.oauth2.expression;

import com.hfhk.cairo.security.oauth2.server.resource.authentication.CairoAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;
import java.util.Set;

/**
 *
 */
public abstract class CairoExpressionUtils {
	private static final String SPACE_PREFIX = "SPACE_";

	public static boolean clientHasAnyRole(Authentication authentication, String... roles) {
		if (authentication instanceof CairoAuthenticationToken) {
			Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
			if (authorities != null) {
				Set<String> roleSet = AuthorityUtils.authorityListToSet(authorities);
				for (String role : roles) {
					if (roleSet.contains(role)) {
						return true;
					}
				}
			}
		}

		return false;
	}

	public static boolean isOAuth(Authentication authentication) {
		return authentication instanceof CairoAuthenticationToken;
	}

	public static boolean isOAuthClientAuth(Authentication authentication) {
		if (authentication instanceof CairoAuthenticationToken) {
			return authentication.isAuthenticated() && ((CairoAuthenticationToken) authentication).getUser() == null;
		}

		return false;
	}

	public static boolean isOAuthUserAuth(Authentication authentication) {

		if (authentication instanceof CairoAuthenticationToken) {
			return authentication.isAuthenticated() && ((CairoAuthenticationToken) authentication).getUser() != null;
		}

		return false;
	}

	public static boolean hasAnyScope(Authentication authentication, String[] scopes) {
		if (authentication instanceof CairoAuthenticationToken) {
			Collection<String> assigned = ((CairoAuthenticationToken) authentication).getClient().getScopes();
			for (String scope : scopes) {
				if (assigned.contains(scope)) {
					return true;
				}
			}
		}

		return false;
	}

	public static boolean hasAnyScopeMatching(Authentication authentication, String[] scopesRegex) {
		if (authentication instanceof CairoAuthenticationToken) {
			Collection<String> spaces = ((CairoAuthenticationToken) authentication).getClient().getScopes();
			for (String scope : spaces) {
				for (String regex : scopesRegex) {
					if (scope.matches(regex)) {
						return true;
					}
				}
			}
		}

		return false;
	}

}
