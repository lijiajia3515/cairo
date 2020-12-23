package com.hfhk.cairo.security.status;

import com.hfhk.cairo.core.business.Business;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(chain = true, fluent = true)
public enum AuthBusiness implements Business {
	/**
	 * 凭证错误
	 */
	Bad(false, "凭证错误"),

	/**
	 * 凭证必须
	 */
	AccessRequired(false, "访问凭证-缺失"),

	/**
	 * 访问凭证错误
	 */
	AccessBad(false, "访问凭证-错误"),
	/**
	 * 访问
	 */
	AccessExpired(false, "访问凭证-已过期"),

	/**
	 * 权限不足
	 */
	AccessDenied(false, "权限不足");


	private final String code = "Auth".concat(name());
	private final boolean success;
	private final String message;

	AuthBusiness(boolean success, String message) {
		this.success = success;

		this.message = message;
	}
}
