package com.hfhk.cairo.core.exception;


import com.hfhk.cairo.core.status.IStatus;

/**
 * 业务 异常包装类
 * 1 一种正确 结果
 * N: N种错误结果
 */
public class StatusException extends RuntimeException {
	private final IStatus status;
	private final Object data;

	/**
	 * 携带固定消息
	 *
	 * @param status 业务
	 */
	public StatusException(IStatus status) {
		super(status.getMessage());
		this.status = status;
		this.data = null;
	}

	public StatusException(IStatus status, Object data) {
		super(status.getMessage());
		this.status = status;
		this.data = data;
	}

	/**
	 * 携带自定义异常消息
	 *
	 * @param status        业务
	 * @param detailMessage 异常消息
	 */
	public StatusException(IStatus status, Object data, String detailMessage) {
		super(detailMessage);
		this.status = status;
		this.data = null;
	}

	/**
	 * 携带自定义异常消息
	 *
	 * @param status        业务
	 * @param detailMessage 异常消息
	 */
	public StatusException(IStatus status, Object data, String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
		this.status = status;
		this.data = data;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		if (status != null) {
			str.append("Metadata==> Code:").append(status.getCode())
				.append(" Message: ").append(status.getMessage())
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
	public IStatus getStatus() {
		return status;
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
