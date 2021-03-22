package com.lijiajia3515.cairo.domain;

import com.lijiajia3515.cairo.domain.auth.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Metadata {
	private Action created;
	private Action lastModified;

	@Data
	@Accessors(chain = true)

	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class Action {
		private User user;
		private LocalDateTime at;
	}
}
