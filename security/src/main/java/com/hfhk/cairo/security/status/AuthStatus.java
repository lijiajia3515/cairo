package com.hfhk.cairo.security.status;

import com.hfhk.cairo.core.status.IStatus;
import lombok.Getter;

@Getter
public enum AuthStatus implements IStatus {
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

	private final boolean success;
	private final String message;

	AuthStatus(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	@Override
	public String getCode() {
		return ("Auth" + name()).toLowerCase();
	}
}
