package com.lijiajia3515.cairo.security;

import java.util.Collection;
import java.util.Optional;

public class SecurityConstants {
	public static final class Role {
		public static final String PREFIX = "ROLE_";
		public static final String ADMIN = "ADMIN";

		public boolean isAdmin(Collection<String> codes) {
			return Optional.ofNullable(codes).filter(x -> x.contains(ADMIN)).isPresent();
		}
	}
}
