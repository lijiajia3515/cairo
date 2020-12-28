package com.hfhk.cairo.mongo.data.mapping.model;

/**
 * 字段常亮
 */
public abstract class UpperCamelCaseFieldNames {
	public static final String _ID = "_id";

	public static final Metadata METADATA = new Metadata();

	public static class Metadata {
		public final Created CREATED = new Created();
		public final LastModified LastModified = new LastModified();

		public final String SORT = "Sort";
		public final String VERSION = "Version";
		public final String DELETED = "Deleted";

		public static class Created {
			public final String UID = "Uid";
			public final String AT = "At";

		}

		public static class LastModified {
			public final String UID = "Uid";
			public final String AT = "At";

		}

	}
}
