package com.lijiajia3515.cairo.mongo.data;

import com.lijiajia3515.cairo.core.CoreConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 元信息
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Metadata {

	/**
	 * 创建人
	 */
	@Builder.Default
	private Created created = new Created();

	/**
	 * 更新人
	 */
	@Builder.Default
	private LastModified lastModified = new LastModified();

	/**
	 * 排序
	 */
	@Builder.Default
	private Long sort = CoreConstants.SNOWFLAKE.nextId();

	/**
	 * 版本
	 */
	@Builder.Default
	private Long version = 0L;

	/**
	 * 逻辑删除
	 */
	@Builder.Default
	private Long deleted = 0L;
}
