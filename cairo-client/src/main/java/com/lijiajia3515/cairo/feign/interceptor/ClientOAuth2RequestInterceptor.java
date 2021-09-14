package com.lijiajia3515.cairo.feign.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;

import java.util.Collection;

public class ClientOAuth2RequestInterceptor implements RequestInterceptor {

	private static final String BEARER_TOKEN_TYPE = "Bearer";

	private final OAuth2RestTemplate oAuth2RestTemplate;

	public ClientOAuth2RequestInterceptor(OAuth2RestTemplate oAuth2RestTemplate) {
		this.oAuth2RestTemplate = oAuth2RestTemplate;
	}

	@Override
	public void apply(RequestTemplate template) {
		final Collection<String> authorizations = template.headers().get(HttpHeaders.AUTHORIZATION);
		if(authorizations == null || authorizations.isEmpty()){
			template.header(HttpHeaders.AUTHORIZATION, String.format("%s %s", BEARER_TOKEN_TYPE, oAuth2RestTemplate.getAccessToken().toString()));
		}
	}
}
