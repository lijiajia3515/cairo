package com.hfhk.cairo.core.tree;

import java.io.Serializable;
import java.util.List;

/**
 * 树形节点
 *
 * @author lijiajia
 * @version 1.0
 */
public interface TreeNode<ID, T> extends Serializable {
	/**
	 * id
	 *
	 * @return id
	 */
	ID id();

	/**
	 * 上级 id
	 *
	 * @return 上级id
	 */
	ID parentId();

	/**
	 * 子集
	 *
	 * @return 子集
	 */
	List<T> subs();
}
