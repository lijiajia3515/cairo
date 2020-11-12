package com.hfhk.cairo.core.page;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@Data
@Accessors(chain = true)
public class Page<T> implements Serializable {
	private int page = 0;
	private int size = 10;
	private long total = 0L;
	private List<T> content = Collections.emptyList();

	public Page() {

	}

	public Page(int page, int size) {
		this.page = page;
		this.size = size;
	}

	public Page(Pageable pageable) {
		this.page = pageable.getPageNumber();
		this.size = pageable.getPageSize();
	}

	public Page(Pageable pageable, List<T> content, long total) {
		this.content = content;
		this.page = pageable.getPageNumber();
		this.size = pageable.getPageSize();
		this.total = total;
	}

	public Stream<T> stream() {
		return content.stream();
	}
}
