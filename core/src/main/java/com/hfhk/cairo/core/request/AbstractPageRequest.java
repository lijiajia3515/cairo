package com.hfhk.cairo.core.request;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * 抽象 分页请求参数
 *
 * @param <T> 真实参数对象
 */
public abstract class AbstractPageRequest<T> {

	private int page = 0;
	private int size = 15;
	private Sort sort = Sort.unsorted();

	public int getPage() {
		return page;
	}

	public T setPage(int page) {
		this.page = page;
		return (T) this;
	}

	public int getSize() {
		return size;
	}

	public T setSize(int size) {
		this.size = size;
		return (T) this;
	}

	public Sort getSort() {
		return sort;
	}

	public T setSort(Sort sort) {
		this.sort = sort;
		return (T) this;
	}

	public int offset() {
		return Math.max(page - 1, 0);

	}

	public Pageable pageable() {
		return PageRequest.of(page, size, sort);
	}
}
