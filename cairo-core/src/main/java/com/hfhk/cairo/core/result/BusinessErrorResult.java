package com.hfhk.cairo.core.result;

import com.hfhk.cairo.core.business.Business;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class BusinessErrorResult implements Result, Business {
	private String code;
	private String message;
	private Object trace;
	private List<Object> warnings;
	private List<Object> errors;

	@Override
	public boolean success() {
		return false;
	}

	@Override
	public String code() {
		return code;
	}

	@Override
	public String message() {
		return message;
	}
}
