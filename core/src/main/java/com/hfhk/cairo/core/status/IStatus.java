package com.hfhk.cairo.core.status;

/**
 * 业务
 */
public interface IStatus {

	/**
	 * 业务执行结果
	 *
	 * @return 业务执行结果
	 */
	boolean isSuccess();

	/**
	 * 状态码
	 *
	 * @return 状态码
	 */
	String getCode();

	/**
	 * 消息
	 *
	 * @return 消息
	 */
	String getMessage();
}
