package com.lijiajia3515.cairo.security.exception;

import com.lijiajia3515.cairo.core.exception.BusinessException;
import com.lijiajia3515.cairo.security.ClientBusiness;

public class ClientRequiredException extends BusinessException {

	public static final String detailMessage = "Client 不能为空";

	public ClientRequiredException() {
		super(ClientBusiness.Required, null, "'Client' 不能为空");
	}

	public ClientRequiredException(String client) {
		super(ClientBusiness.Required, client, "'Client' 错误");
	}

	public ClientRequiredException(Throwable throwable) {
		super(ClientBusiness.Required, null, "Client 不能为空", throwable);
	}

	public ClientRequiredException(String client, Throwable throwable) {
		super(ClientBusiness.Required, null, "'Client' 错误", throwable);
	}
}
