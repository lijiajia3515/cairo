package com.hfhk.cairo.core.result;

import com.hfhk.cairo.core.exception.BusinessException;
import com.hfhk.cairo.core.business.Business;
import com.hfhk.cairo.core.business.DefaultBusiness;
import lombok.Getter;
import lombok.ToString;

import java.util.Optional;

/**
 * REST API 结果实现类
 */
@Getter
@ToString
public class BusinessResult<T> implements Result<T> {
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
	public BusinessResult() {

	}

	/**
	 * 构造函数
	 *
	 * @param success success
	 * @param code    code
	 * @param message message
	 */
	public BusinessResult(boolean success, String code, String message) {
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
	public BusinessResult(boolean success, String code, String message, T data) {
		this.success = success;
		this.code = code;
		this.message = message;
		this.data = data;
	}

	/**
	 * build
	 */
	public BusinessResult(Business business) {
		this.success = business.success();
		this.code = business.code();
		this.message = business.message();
	}

	/**
	 * <p>build.</p>
	 */
	public BusinessResult(Business business, T data) {
		this.success = business.success();
		this.code = business.code();
		this.message = business.message();
		this.data = data;
	}

	/**
	 * <p>build.</p>
	 */
	public static Result<Object> build(Business business) {
		return new BusinessResult<>(business);
	}

	/**
	 * <p>build.</p>
	 */
	public static <D> Result<D> build(Business business, D data) {
		return new BusinessResult<>(business, data);
	}

	/**
	 * <p>build.</p>
	 */
	public static Result<Object> build(boolean success, String code, String msg) {
		return new BusinessResult<>(success, code, msg);
	}

	/**
	 * <p>build.</p>
	 */
	public static <D> Result<D> build(boolean success, String code, String msg, D data) {
		return new BusinessResult<>(success, code, msg, data);
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
		return build(DefaultBusiness.Success, data);
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
		return build(DefaultBusiness.Failed, data);
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
		return build(DefaultBusiness.Unknown, data);
	}

	/**
	 * <p>buildEx.</p>
	 */
	public static Result<Object> buildEx(BusinessException statusEx) {
		return new BusinessResult<>(statusEx.getStatus().success(), statusEx.getStatus().code(), statusEx.getMessage(), statusEx.getData());
	}

	/**
	 * <p>buildEx.</p>
	 */
	public static <D> Result<D> buildError(BusinessException statusEx, D data) {
		return new BusinessResult<>(statusEx.getStatus().success(), statusEx.getStatus().code(), statusEx.getMessage(), data);
	}
}
