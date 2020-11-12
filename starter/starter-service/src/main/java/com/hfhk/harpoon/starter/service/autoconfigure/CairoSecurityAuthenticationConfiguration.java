package com.hfhk.harpoon.starter.service.autoconfigure;

import com.hfhk.harpoon.client.auth.AuthenticationBasicClient;
import com.hfhk.harpoon.starter.service.security.oauth2.server.resource.authentication.CairoJwtAuthenticationConverter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class CairoSecurityAuthenticationConfiguration {

	@Bean
	@ConditionalOnClass(AuthenticationBasicClient.class)
	public CairoJwtAuthenticationConverter harpoonJwtAuthenticationConverter(AuthenticationBasicClient authenticationBasicClient) {
		return new CairoJwtAuthenticationConverter(authenticationBasicClient);
	}

}
