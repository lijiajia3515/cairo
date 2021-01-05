package com.hfhk.cairo.mongo.data.mapping.model;

import java.util.Optional;

public abstract class AbstractMongoField {
	private final AbstractMongoField PARENT;
	public final String SELF;

	public AbstractMongoField() {
		PARENT = null;
		SELF = null;
	}

	public AbstractMongoField(AbstractMongoField PARENT, String prefix) {
		this.PARENT = PARENT;
		this.SELF = Optional.ofNullable(PARENT.SELF).map(x -> x.concat(".")).orElse("").concat(prefix);
	}

	public String field(String fieldName) {
		return Optional.ofNullable(SELF).map(x -> x.concat(".").concat(fieldName)).orElse(fieldName);
	}

}
