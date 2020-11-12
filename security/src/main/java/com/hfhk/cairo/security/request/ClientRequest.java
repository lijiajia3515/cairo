package com.hfhk.cairo.security.request;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 客户端 请求对象
 */
@Data
@Accessors(chain = true)
public class ClientRequest implements Serializable {

	private String client;
}
