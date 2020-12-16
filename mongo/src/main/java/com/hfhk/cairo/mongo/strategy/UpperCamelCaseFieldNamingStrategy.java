package com.hfhk.cairo.mongo.strategy;

import org.springframework.data.mapping.model.CamelCaseSplittingFieldNamingStrategy;

/**
 * 大写驼峰字段命名策略
 */
public class UpperCamelCaseFieldNamingStrategy extends CamelCaseSplittingFieldNamingStrategy {

	public UpperCamelCaseFieldNamingStrategy() {
		super("");
	}

	@Override
	protected String preparePart(String part) {
		return part.substring(0, 1).toUpperCase().concat(part.concat(part.substring(1)));
	}

}
