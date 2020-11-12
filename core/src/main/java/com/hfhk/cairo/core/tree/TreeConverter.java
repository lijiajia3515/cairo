package com.hfhk.cairo.core.tree;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

/**
 * Tree 节点构建Util
 *
 * @author lijiajia
 * @version 1.0
 */
public class TreeConverter {
	/**
	 * @param nodes  节点 集合
	 * @param root   根节点
	 * @param <ID>   节点标识
	 * @param <T>    节点数据
	 * @param <Node> 节点 类型
	 * @return 集合 属性节点
	 */
	public static <ID, T, Node extends TreeNode<ID, T>> List<Node> build(Collection<Node> nodes, ID root, Comparator<Node> comparator) {
		List<Node> rootNodes = Optional.ofNullable(root)
			.map(r -> nodes.stream()
				.filter(node -> node.parentId() != null && node.parentId().equals(r))
			)
			.orElse(nodes.stream()
				.filter(node -> node.parentId() == null)
			)
			.sorted(comparator)
			.collect(toList());

		rootNodes.forEach(node -> findChildren(node, nodes));

		return rootNodes;
	}

	/**
	 * 查找儿子
	 *
	 * @param node   节点
	 * @param nodes  所有节点 集合
	 * @param <Node> 节点类型
	 * @return 子集结果
	 */
	@SuppressWarnings("unchecked")
	private static <Node extends TreeNode> Node findChildren(Node node, Collection<Node> nodes) {
		nodes.stream()
			.filter(node2 -> node2.parentId().equals(node.id()))
			.forEach(node2 -> node.subs().add(findChildren(node2, nodes)));
		return node;
	}
}
