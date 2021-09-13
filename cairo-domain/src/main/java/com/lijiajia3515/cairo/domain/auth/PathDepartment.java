package com.lijiajia3515.cairo.domain.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * 路径模式 部门
 */
@Data
@Accessors(chain = true)

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PathDepartment implements Serializable {

	/**
	 * id
	 */
	private List<String> ids;

	/**
	 * 名称
	 */
	private List<String> names;

	/**
	 * 备注
	 */
	private List<String> remarks;
}
