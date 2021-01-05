package com.hfhk.cairo.core.page;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@Accessors(chain = true)
public class Page<T> implements Serializable {
	private int page = 0;
	private int size = 10;
	private long total = 0L;
	private List<T> contents = Collections.emptyList();

	public Page() {

	}

	public Page(int page, int size) {
		this.page = page;
		this.size = size;
	}

	public Page(int page, int size, List<T> contents, long total) {
		this.page = page;
		this.size = size;
		this.contents = contents;
		this.total = total;
	}

	public Page(AbstractPage<?> page) {
		this.page = page.getPage();
		this.size = page.getSize();
	}

	public Page(AbstractPage<?> page, List<T> contents, long total) {
		this.contents = contents;
		this.page = page.getPage();
		this.size = page.getSize();
		this.total = total;
	}

	public Stream<T> stream() {
		return contents.stream();
	}

	/**
	 * converter
	 *
	 * @param mapper mapper
	 * @param <R>    new type
	 * @return new page
	 */
	public <R> Page<R> convert(Function<? super T, R> mapper) {
		List<R> x = contents.stream().map(mapper).collect(Collectors.toList());
		return new Page<>(page, size, x, total);
	}
}
