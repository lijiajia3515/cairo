package com.hfhk.cairo.security.exception;

import com.hfhk.cairo.security.status.ClientStatus;
import com.hfhk.cairo.core.exception.StatusException;

public class ClientRequiredException extends StatusException {

	public static final String detailMessage = "client 不能为空";

	public ClientRequiredException() {
		super(ClientStatus.REQUIRED, null, "'client' 不能为空");
	}

	public ClientRequiredException(String client) {
		super(ClientStatus.REQUIRED, client, "'client' 错误");
	}

	public ClientRequiredException(Throwable throwable) {
		super(ClientStatus.REQUIRED, null, "client 不能为空", throwable);
	}

	public ClientRequiredException(String client, Throwable throwable) {
		super(ClientStatus.REQUIRED, null, "'client' 错误", throwable);
	}
}
