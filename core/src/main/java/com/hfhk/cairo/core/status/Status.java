package com.hfhk.cairo.core.status;


import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * 默认业务结果
 */
@Getter
@Accessors(fluent = true)
public enum Status implements IStatus {
	/**
	 * 业务默认成功结果
	 */
	Success(true, "ok"),

	/**
	 * 业务默认失败结果
	 */
	Failed(false, "操作失败"),

	/**
	 * 未知异常
	 */
	Unknown(false, "未知异常,请联系管理员");

	public final boolean success;
	public final String code = name();
	public final String message;


	Status(boolean success, String message) {
		this.success = success;
		this.message = message;
	}
}
