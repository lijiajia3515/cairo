package com.hfhk.cairo.starter.web.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * 统一结果返回转换 处理器
 */
@Slf4j
public class ResultResponseHandler implements HandlerMethodReturnValueHandler, BeanPostProcessor {

	private final List<ResponseBodyAdvice<Object>> advices = new ArrayList<>();

	private final ObjectMapper objectMapper;

	public ResultResponseHandler(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	@Override
	public boolean supportsReturnType(MethodParameter returnType) {
		return returnType.getMethodAnnotation(StatusResult.class) != null;
	}

	@Override
	public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer,
								  NativeWebRequest webRequest) {
		mavContainer.setRequestHandled(true);
		for (ResponseBodyAdvice<Object> ad : advices) {
			if (ad.supports(returnType, null)) {
				returnValue = ad.beforeBodyWrite(returnValue, returnType, MediaType.APPLICATION_JSON, null, new ServletServerHttpRequest(Objects.requireNonNull(webRequest.getNativeRequest(HttpServletRequest.class))), new ServletServerHttpResponse(Objects.requireNonNull(webRequest.getNativeResponse(HttpServletResponse.class))));
			}
		}

		Object finalReturnValue = returnValue;
		Optional.of(webRequest)
			.map(r -> r.getNativeResponse(HttpServletResponse.class))
			.ifPresent(response -> {
				response.setContentType(MediaType.APPLICATION_JSON_VALUE);
				String valueString;
				try {
					valueString = objectMapper.writeValueAsString(com.hfhk.cairo.core.result.StatusResult.buildSuccess(finalReturnValue));
					response.getWriter().write(valueString);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
	}

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof ResponseBodyAdvice) {
			advices.add((ResponseBodyAdvice<Object>) bean);
		} else if (bean instanceof RequestMappingHandlerAdapter) {
			List<HandlerMethodReturnValueHandler> handlers = new ArrayList<>(
				Objects.requireNonNull(((RequestMappingHandlerAdapter) bean).getReturnValueHandlers()));
			ResultResponseHandler jsonHandler = null;
			for (HandlerMethodReturnValueHandler handler : handlers) {
				if (handler instanceof ResultResponseHandler) {
					jsonHandler = (ResultResponseHandler) handler;
					break;
				}
			}
			if (jsonHandler != null) {
				handlers.remove(jsonHandler);
				handlers.add(0, jsonHandler);
				((RequestMappingHandlerAdapter) bean).setReturnValueHandlers(handlers);
			}
		}
		return bean;
	}
}
