package com.hfhk.cairo.core.exception;


import com.hfhk.cairo.core.business.Business;

/**
 * 业务 异常包装类
 * 1 一种正确 结果
 * N: N种错误结果
 */
public class BusinessException extends RuntimeException {
	private final Business business;
	private final Object data;

	/**
	 * 携带固定消息
	 *
	 * @param business 业务
	 */
	public BusinessException(Business business) {
		super(business.message());
		this.business = business;
		this.data = null;
	}

	public BusinessException(Business business, Object data) {
		super(business.message());
		this.business = business;
		this.data = data;
	}

	/**
	 * 携带自定义异常消息
	 *
	 * @param business        业务
	 * @param detailMessage 异常消息
	 */
	public BusinessException(Business business, Object data, String detailMessage) {
		super(detailMessage);
		this.business = business;
		this.data = null;
	}

	/**
	 * 携带自定义异常消息
	 *
	 * @param business        业务
	 * @param detailMessage 异常消息
	 */
	public BusinessException(Business business, Object data, String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
		this.business = business;
		this.data = data;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		if (business != null) {
			str.append("Metadata==> Code:").append(business.code())
				.append(" Message: ").append(business.message())
				.append("\n");
		}
		str.append(super.toString());

		return str.toString();
	}

	/**
	 * 获取业务
	 *
	 * @return 业务编码
	 */
	public Business getStatus() {
		return business;
	}

	/**
	 * 获取 异常数据
	 *
	 * @return 业务data
	 */
	public Object getData() {
		return data;
	}
}
