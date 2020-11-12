package com.hfhk.cairo.security.status;

import com.hfhk.cairo.core.status.IStatus;
import lombok.Getter;

@Getter
public enum ClientStatus implements IStatus {
	REQUIRED(false, "client 不能为空");


	private final boolean success;
	private final String message;

	ClientStatus(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	@Override
	public String getCode() {
		return ("client_".concat(name())).toLowerCase();
	}
}
