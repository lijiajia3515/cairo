package com.lijiajia3515.cairo.mongo.data.mapping.model;

/**
 * 字段常亮
 */
public abstract class AbstractUpperCamelCaseField extends AbstractMongoField {
	public AbstractUpperCamelCaseField() {
		super();
	}

	public AbstractUpperCamelCaseField(AbstractMongoField parent, String prefix) {
		super(parent, prefix);
	}

	public final String _ID = field("_id");

	public final Metadata METADATA = new Metadata(this, "Metadata");

	public static class Metadata extends AbstractMongoField {
		public Metadata() {
		}

		public Metadata(AbstractMongoField parent, String prefix) {
			super(parent, prefix);
		}

		public final Created CREATED = new Created(this, "Created");
		public final LastModified LAST_MODIFIED = new LastModified(this, "LastModified");

		public final String SORT = field("Sort");
		public final String VERSION = field("Version");
		public final String DELETED = field("Deleted");

		public static class Created extends AbstractMongoField {
			public final String UID = field("Uid");
			public final String AT = field("At");

			public Created() {
				super();
			}

			public Created(AbstractMongoField parent, String prefix) {
				super(parent, prefix);
			}
		}

		public static class LastModified extends AbstractMongoField {
			public final String UID = field("Uid");
			public final String AT = field("At");

			public LastModified() {
				super();
			}

			public LastModified(AbstractMongoField parent, String prefix) {
				super(parent, prefix);
			}
		}

	}
}
