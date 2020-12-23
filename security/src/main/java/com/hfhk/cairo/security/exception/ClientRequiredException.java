package com.hfhk.cairo.security.exception;

import com.hfhk.cairo.core.exception.BusinessException;
import com.hfhk.cairo.security.status.ClientBusiness;

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
