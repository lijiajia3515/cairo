package com.hfhk.harpoon.starter.service.autoconfigure;

import com.hfhk.cairo.security.oauth2.expression.CairoMethodSecurityExpressionHandler;
import com.hfhk.cairo.security.oauth2.expression.CairoWebSecurityExpressionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.web.FilterInvocation;

@Configuration
public class CairoSecurityConfiguration {

	//@Bean
	//@ConditionalOnClass(AuthenticationClient.class)
	//public HarpoonJwtAuthenticationConverter harpoonJwtAuthenticationConverter(AuthenticationClient authenticationClient) {
	//	return new HarpoonJwtAuthenticationConverter(authenticationClient);
	//}

	@Bean
	public SecurityExpressionHandler<FilterInvocation> harpoonWebSecurityExpressionHandler() {
		return new CairoWebSecurityExpressionHandler();
	}

	@Bean
	public MethodSecurityExpressionHandler harpoonMethodSecurityExpressionHandler() {
		return new CairoMethodSecurityExpressionHandler();
	}

}
