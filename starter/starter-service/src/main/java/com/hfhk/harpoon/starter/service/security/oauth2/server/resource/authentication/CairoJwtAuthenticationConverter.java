package com.hfhk.harpoon.starter.service.security.oauth2.server.resource.authentication;

import cn.hutool.core.util.IdUtil;
import com.hfhk.harpoon.client.auth.AuthenticationBasicClient;
import com.hfhk.cairo.security.authentication.Client;
import com.hfhk.cairo.security.authentication.RemoteUser;
import com.hfhk.cairo.security.oauth2.server.resource.authentication.CairoAuthenticationToken;
import com.hfhk.cairo.security.oauth2.spec.ClientSpec;
import com.hfhk.cairo.security.oauth2.spec.UserSpec;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CairoJwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {
	private final AuthenticationBasicClient authenticationBasicClient;

	public CairoJwtAuthenticationConverter(AuthenticationBasicClient authenticationBasicClient) {
		this.authenticationBasicClient = authenticationBasicClient;
	}

	@Override
	public CairoAuthenticationToken convert(Jwt source) {
		RemoteUser remoteUser = authenticationBasicClient.authentication("Bearer " + source.getTokenValue());
		return new CairoAuthenticationToken(source,
			convertClient(source),
			remoteUser.getUser(),
			Optional.ofNullable(remoteUser.getAuthorities())
				.stream()
				.flatMap(Collection::stream)
				.map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList()));
	}

	private Client convertClient(Jwt jwt) {
		Map<String, Object> claims = Optional.ofNullable(jwt.getClaims()).orElse(Collections.emptyMap());
		return Client.builder()
			.id(claims.getOrDefault(ClientSpec.ID, "default").toString())
			.scopes((Collection<String>) claims.getOrDefault(ClientSpec.SCOPE, Collections.emptyList()))
			.build();
	}

	private String convertUid(Jwt jwt) {
		return Optional.ofNullable(jwt.getClaims())
			.map(claims -> claims.get(UserSpec.UID))
			.map(x -> (String) x)
			.orElse(IdUtil.objectId());
	}
}
