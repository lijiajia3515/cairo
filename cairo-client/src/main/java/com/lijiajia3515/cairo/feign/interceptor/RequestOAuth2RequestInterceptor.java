package com.lijiajia3515.cairo.feign.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

@Slf4j
public class RequestOAuth2RequestInterceptor implements RequestInterceptor {

	@Override
	public void apply(RequestTemplate template) {
		final Collection<String> authorizations = template.headers().get(HttpHeaders.AUTHORIZATION);
		if (authorizations == null || authorizations.isEmpty()) {
			ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
			Optional.ofNullable(request.getHeader(HttpHeaders.AUTHORIZATION))
				.ifPresent(authorization -> {
					log.debug("request authorization: [{}]", authorization);
					template.header(HttpHeaders.AUTHORIZATION, authorization);
				});
		}
	}

}
