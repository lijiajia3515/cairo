package com.lijiajia3515.cairo.security;

import com.lijiajia3515.cairo.core.business.Business;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@Accessors(chain = true, fluent = true)
public enum ClientBusiness implements Business {
	Required(false, "client 不能为空");

	private final String code = "Client".concat(name());
	private final boolean success;
	private final String message;

	ClientBusiness(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

}
