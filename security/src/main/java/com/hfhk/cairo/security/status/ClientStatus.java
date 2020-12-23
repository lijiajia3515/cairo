package com.hfhk.cairo.security.status;

import com.hfhk.cairo.core.status.IStatus;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(chain = true, fluent = true)
public enum ClientStatus implements IStatus {
	Required(false, "client 不能为空");

	private final String code = "Client".concat(name());
	private final boolean success;
	private final String message;

	ClientStatus(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

}
