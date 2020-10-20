package com.secbro2.interceptor;

import com.secbro2.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sec
 * @version 1.0
 * @date 2020/10/19
 **/
@Component
public class RequestIdTraceInterceptor implements HandlerInterceptor {

	private static final String REQUEST_ID_KEY = "request-id";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
	                         Object handler) {
		MDC.put(REQUEST_ID_KEY, getRequestId(request));
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
	                            Object handler, Exception ex) {
		// 把requestId添加到响应头，以便其它应用使用
		response.addHeader(REQUEST_ID_KEY, MDC.get(REQUEST_ID_KEY));
		// 请求完成，从MDC中移除requestId
		MDC.remove(REQUEST_ID_KEY);
	}

	public static String getRequestId(HttpServletRequest request) {
		String paramRequestId = request.getParameter(REQUEST_ID_KEY);
		String headerRequestId = request.getHeader(REQUEST_ID_KEY);
		// 根据请求参数或请求头判断是否有“request-id”，有则使用，无则创建
		String requestId;
		if (paramRequestId == null && headerRequestId == null) {
			requestId = IdUtil.simpleUuid();
		} else {
			requestId = paramRequestId != null ? paramRequestId : headerRequestId;
		}
		return requestId;
	}
}
