/*
package com.lijiajia3515.cairo.security.oauth2.expression;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;
import org.springframework.security.oauth2.provider.expression.OAuth2SecurityExpressionMethods;

public class CairoMethodSecurityExpressionHandler extends OAuth2MethodSecurityExpressionHandler {

	@Override
	public StandardEvaluationContext createEvaluationContextInternal(Authentication authentication, MethodInvocation mi) {
		StandardEvaluationContext ec = super.createEvaluationContextInternal(authentication, mi);
		ec.setVariable("oauth2", new OAuth2SecurityExpressionMethods(authentication));
		ec.setVariable("cairo", new CairoSecurityExpressionMethods(authentication));
		//ec.setVariable("oauth2", new CairoSecurityExpressionMethods(authentication));
		return ec;
	}
}

*/
