package com.hfhk.cairo.mongo.data.mapping.model;

/**
 * 字段常亮
 */
public abstract class UpperCamelCaseFieldNames {
	public static final String _ID = "_id";

	public static final Metadata Metadata = new Metadata();

	public static class Metadata {
		public final Created Created = new Created();
		public final LastModified LastModified = new LastModified();

		public final String Sort = "Sort";
		public final String Version = "Version";
		public final String Deleted = "Deleted";

		public static class Created {
			public final String uid = "Uid";
			public final String At = "At";

		}

		public static class LastModified {
			public final String uid = "Uid";
			public final String At = "At";

		}

	}
}
