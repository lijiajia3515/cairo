package com.hfhk.cairo.core.result;

import com.hfhk.cairo.core.exception.StatusException;
import com.hfhk.cairo.core.status.Status;
import com.hfhk.cairo.core.status.DefaultStatus;
import lombok.Getter;
import lombok.ToString;

import java.util.Optional;

/**
 * REST API 结果实现类
 */
@Getter
@ToString
public class StatusResult<T> implements Result<T> {
	/**
	 * 成功状态
	 */
	private boolean success;

	/**
	 * 业务状态码
	 */
	private String code;

	/**
	 * 描述
	 */
	private String message;

	/**
	 * 结果
	 */
	private T data;

	/**
	 * 保留默认构造函数
	 */
	public StatusResult() {

	}

	/**
	 * 构造函数
	 *
	 * @param success success
	 * @param code    code
	 * @param message message
	 */
	public StatusResult(boolean success, String code, String message) {
		this.success = success;
		this.code = code;
		this.message = message;
	}

	/**
	 * 构造函数
	 *
	 * @param success success
	 * @param code    code
	 * @param message message
	 * @param data    data
	 */
	public StatusResult(boolean success, String code, String message, T data) {
		this.success = success;
		this.code = code;
		this.message = message;
		this.data = data;
	}

	/**
	 * build
	 */
	public StatusResult(Status status) {
		this.success = status.success();
		this.code = status.code();
		this.message = status.message();
	}

	/**
	 * <p>build.</p>
	 */
	public StatusResult(Status status, T data) {
		this.success = status.success();
		this.code = status.code();
		this.message = status.message();
		this.data = data;
	}

	/**
	 * <p>build.</p>
	 */
	public static Result<Object> build(Status status) {
		return new StatusResult<>(status);
	}

	/**
	 * <p>build.</p>
	 */
	public static <D> Result<D> build(Status status, D data) {
		return new StatusResult<>(status, data);
	}

	/**
	 * <p>build.</p>
	 */
	public static Result<Object> build(boolean success, String code, String msg) {
		return new StatusResult<>(success, code, msg);
	}

	/**
	 * <p>build.</p>
	 */
	public static <D> Result<D> build(boolean success, String code, String msg, D data) {
		return new StatusResult<>(success, code, msg, data);
	}

	/**
	 * <p>buildSuccess.</p>
	 */
	public static Result<Object> buildSuccess() {
		return buildSuccess(Optional.empty().orElse(null));
	}

	/**
	 * <p>buildSuccess.</p>
	 */
	public static <D> Result<D> buildSuccess(D data) {
		return build(DefaultStatus.Success, data);
	}

	/**
	 * <p>buildFailed.</p>
	 */
	public static Result<Object> buildFailed() {
		return buildFailed(Optional.empty().orElse(null));
	}

	/**
	 * <p>buildFailed.</p>
	 */
	public static <D> Result<D> buildFailed(D data) {
		return build(DefaultStatus.Failed, data);
	}

	/**
	 * <p>buildUnknown.</p>
	 */
	public static Result<Object> buildUnknown() {
		return buildFailed(Optional.empty().orElse(null));
	}

	/**
	 * <p>buildUnknown.</p>
	 */
	public static <D> Result<D> buildUnknown(D data) {
		return build(DefaultStatus.Unknown, data);
	}

	/**
	 * <p>buildEx.</p>
	 */
	public static Result<Object> buildEx(StatusException statusEx) {
		return new StatusResult<>(statusEx.getStatus().success(), statusEx.getStatus().code(), statusEx.getMessage(), statusEx.getData());
	}

	/**
	 * <p>buildEx.</p>
	 */
	public static <D> Result<D> buildError(StatusException statusEx, D data) {
		return new StatusResult<>(statusEx.getStatus().success(), statusEx.getStatus().code(), statusEx.getMessage(), data);
	}
}
