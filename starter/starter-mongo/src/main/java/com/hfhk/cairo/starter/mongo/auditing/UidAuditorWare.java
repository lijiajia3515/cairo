package com.hfhk.cairo.starter.mongo.auditing;


import com.hfhk.cairo.security.authentication.User;
import com.hfhk.cairo.security.oauth2.server.resource.authentication.CairoAuthenticationToken;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class UidAuditorWare implements AuditorAware<String> {

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
			.map(authentication -> (CairoAuthenticationToken) authentication)
			.map(CairoAuthenticationToken::getUser)
			.map(User::getUid);
	}
}
