package com.lijiajia3515.cairo.core.exception;


import com.lijiajia3515.cairo.core.business.DefaultBusiness;

/**
 * 运行时 未知/无法描述 业务异常
 */
public class UnknownBusinessException extends BusinessException {
	public UnknownBusinessException(String message) {
		super(DefaultBusiness.Unknown, message);
	}
}
