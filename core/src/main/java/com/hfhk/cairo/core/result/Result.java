package com.hfhk.cairo.core.result;

import java.io.Serializable;

/**
 * 返回结果
 */
public interface Result<T> extends Serializable {
	/**
	 * 结果
	 *
	 * @return 得到结果
	 */
	T getData();
}
