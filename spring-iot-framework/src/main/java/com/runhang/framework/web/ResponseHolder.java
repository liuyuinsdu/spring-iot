package com.runhang.framework.web;

import javax.servlet.http.HttpServletResponse;

/**
 * Response持有类
 * 
 * @author runhang
 *
 */
public class ResponseHolder {

	private static final ThreadLocal<HttpServletResponse>  responseWrapper= new ThreadLocal<HttpServletResponse>();

	public static HttpServletResponse getHttpServletResponse() {
		return responseWrapper.get();
	}

	public static void setHttpServletResponse(HttpServletResponse response) {
		responseWrapper.set(response);
	}
	
	public static void clear(){
		responseWrapper.remove();
	}
}
