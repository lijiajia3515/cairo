package com.hfhk.cairo.security.status;

import com.hfhk.cairo.core.status.IStatus;
import lombok.Getter;

@Getter
public enum AuthStatus implements IStatus {
	NO(false, "未登录哦"),

	BAD(false, "用户名密码错误"),

	ACCESS_TOKEN_EXPIRE(false, "access_token已过期"),
	ACCESS_TOKEN_ILLEGAL(false, "access_token不合法"),

	REFRESH_TOKEN_EXPIRE(false, "refresh_token已过期"),
	REFRESH_TOKEN_ILLEGAL(false, "refresh_token不合法"),

	USER_NOT_EXISTS(false, "用户不存在"),
	USER_DISABLE(false, "用户被禁止登录"),

	ACCESS_DENE(false, "权限不足");


	private final boolean success;
	private final String message;

	AuthStatus(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	@Override
	public String getCode() {
		return ("AUTH" + name()).toLowerCase();
	}
}
