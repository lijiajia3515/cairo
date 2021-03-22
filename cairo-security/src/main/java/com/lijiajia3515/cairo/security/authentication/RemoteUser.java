package com.lijiajia3515.cairo.security.authentication;

import com.lijiajia3515.cairo.domain.auth.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Collection;

@Data
@Accessors(chain = true)

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RemoteUser {

	private User user;

	private Collection<String> authorities;
}
