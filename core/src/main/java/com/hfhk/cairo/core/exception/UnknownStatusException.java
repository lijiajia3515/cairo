package com.hfhk.cairo.core.exception;


import com.hfhk.cairo.core.status.Status;

/**
 * 运行时 未知/无法描述 业务异常
 */
public class UnknownStatusException extends StatusException {
	public UnknownStatusException(String message) {
		super(Status.Unknown, message);
	}
}
