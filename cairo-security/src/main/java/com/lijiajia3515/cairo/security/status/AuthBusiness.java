package com.lijiajia3515.cairo.security.status;

import com.lijiajia3515.cairo.core.business.Business;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(chain = true, fluent = true)
public enum AuthBusiness implements Business {
	/**
	 * 凭证错误
	 */
	Bad("凭证错误"),

	/**
	 * 凭证必须
	 */
	AccessRequired("访问凭证-缺失"),

	/**
	 * 访问凭证错误
	 */
	AccessBad("访问凭证-错误"),
	/**
	 * 访问
	 */
	AccessExpired("访问凭证-已过期"),

	/**
	 * 权限不足
	 */
	AccessDenied("权限不足");


	private final String code = "Auth".concat(name());
	private final boolean success;
	private final String message;

	AuthBusiness(String message) {

		this.success = false;
		this.message = message;
	}

	AuthBusiness(boolean success, String message) {

		this.success = success;
		this.message = message;
	}
}
