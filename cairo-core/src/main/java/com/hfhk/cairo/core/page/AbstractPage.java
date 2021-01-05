package com.hfhk.cairo.core.page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * 抽象 分页请求参数
 *
 * @param <T> 真实参数对象
 */
public abstract class AbstractPage<T> {

	private int page = 0;
	private int size = 15;
	private Sort sort = Sort.unsorted();

	public int getPage() {
		return page;
	}

	@SuppressWarnings("unchecked")
	public T setPage(int page) {
		this.page = page;
		return (T) this;
	}

	public int getSize() {
		return size;
	}

	@SuppressWarnings("unchecked")
	public T setSize(int size) {
		this.size = size;
		return (T) this;
	}

	public Sort getSort() {
		return sort;
	}

	@SuppressWarnings("unchecked")
	public T setSort(Sort sort) {
		this.sort = sort;
		return (T) this;
	}

	public Pageable pageable() {
		return PageRequest.of(page, size, sort);
	}
}
