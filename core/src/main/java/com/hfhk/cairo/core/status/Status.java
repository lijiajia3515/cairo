package com.hfhk.cairo.core.status;

/**
 * 业务
 */
public interface Status {

	/**
	 * 业务执行结果
	 *
	 * @return 业务执行结果
	 */
	boolean success();

	/**
	 * 状态码
	 *
	 * @return 状态码
	 */
	String code();

	/**
	 * 消息
	 *
	 * @return 消息
	 */
	String message();
}
