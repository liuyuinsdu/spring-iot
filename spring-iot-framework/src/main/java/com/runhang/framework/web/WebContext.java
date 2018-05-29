package com.runhang.framework.web;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.runhang.framework.utils.StringHelper;

public class WebContext {

	private static final ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<HttpServletRequest>();
	private static final ThreadLocal<HttpServletResponse> responseWrapper = new ThreadLocal<HttpServletResponse>();
	private static final ThreadLocal<Map<String, String>> cookieHolder = new ThreadLocal<Map<String, String>>();

	public static void clear(){
		removeRequest();
		removeCookie();
		removeResponse();
	}
	
	public static HttpServletRequest getHttpServletRequest() {
		return requestHolder.get();
	}

	public static void setHttpServletRequest(HttpServletRequest request) {
		requestHolder.set(request);
	}

	public static void removeRequest() {
		requestHolder.remove();
	}
	
	public static void setAttributeToRequest(String key, Object value) {
		getHttpServletRequest().setAttribute(key, value);
	}

	public static Object getAttributeFromRequest(String key) {
		return getHttpServletRequest().getAttribute(key);
	}

	public static Object getAttributeFromRequest(String key, boolean decode) {
		String value = (String) getHttpServletRequest().getAttribute(key);
		if (StringHelper.isEmpty(value)) {
			return "";
		}
		if (decode) {
			try {
				value = new String(value.getBytes("ISO8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return value;
	}

	public static Object getParemeterFromRequest(String key) {
		return getParemeterFromRequest(key, false);
	}

	public static Object getParemeterFromRequest(String key, boolean decode) {
		String value = getHttpServletRequest().getParameter(key);
		if (StringHelper.isEmpty(value)) {
			return "";
		}
		if (decode) {
			try {
				value = new String(value.getBytes("ISO8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return value;
	}

	public static String getRemoteIP() {
		if (getHttpServletRequest().getHeader("x-forwarded-for") == null) {
			String ip = getHttpServletRequest().getRemoteAddr();
			return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
		}
		return getHttpServletRequest().getHeader("x-forwarded-for");
	}

	public static void putCookie(String key, String value) {
		Map<String, String> cookieMap = cookieHolder.get();
		if (cookieMap == null) {
			cookieMap = new HashMap<String, String>();
			cookieHolder.set(cookieMap);
		}
		cookieMap.put(key, value);
	}

	public static String getCookie(String key) {
		Map<String, String> cookieMap = cookieHolder.get();
		if (cookieMap == null) {
			return null;
		}
		return cookieHolder.get().get(key);
	}

	public static void removeCookie() {
		cookieHolder.remove();
	}

	public static HttpServletResponse getHttpServletResponse() {
		return responseWrapper.get();
	}

	public static void setHttpServletResponse(HttpServletResponse response) {
		responseWrapper.set(response);
	}

	public static void removeResponse() {
		responseWrapper.remove();
	}
}
