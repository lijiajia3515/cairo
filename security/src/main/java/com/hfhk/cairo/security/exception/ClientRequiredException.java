package com.hfhk.cairo.security.exception;

import com.hfhk.cairo.core.exception.StatusException;
import com.hfhk.cairo.security.status.ClientStatus;

public class ClientRequiredException extends StatusException {

	public static final String detailMessage = "Client 不能为空";

	public ClientRequiredException() {
		super(ClientStatus.Required, null, "'Client' 不能为空");
	}

	public ClientRequiredException(String client) {
		super(ClientStatus.Required, client, "'Client' 错误");
	}

	public ClientRequiredException(Throwable throwable) {
		super(ClientStatus.Required, null, "Client 不能为空", throwable);
	}

	public ClientRequiredException(String client, Throwable throwable) {
		super(ClientStatus.Required, null, "'Client' 错误", throwable);
	}
}
