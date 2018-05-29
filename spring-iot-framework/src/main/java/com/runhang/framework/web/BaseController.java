package com.runhang.framework.web;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class BaseController {

	public static final String SESSION_USER = "sessionUser";
	public static final String CURRENT_PAGE = "cp";
	public static final String PAGE_SIZE = "ps";
	public static final String RESOURCES_IMG_PATH = File.separator + "resources" + File.separator + "upload"
			+ File.separator + "img";
	public static final String ISO8859_1 = "ISO8859-1";
	public static final String UTF_8 = "UTF-8";
	public static final String SESSION_CAPTCHA = "session_captcha";
	public static final String PAGE_ERROR = "";
	public static final String SUCCESS = "success";
	public static final String SPACE = "&nbsp";

	protected HttpServletRequest getRequest() {
		return RequestHolder.getHttpServletRequest();
	}

	protected HttpServletResponse getResponse() {
		return ResponseHolder.getHttpServletResponse();
	}

	/**
	 * 获取项目URL
	 * 
	 * @return
	 */
	protected String getWebRootPath() {
		HttpServletRequest request = getRequest();
		return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/";
	}

	protected String getRealPath() {
		return RequestHolder.getHttpServletRequest().getSession().getServletContext().getRealPath("/");
	}

	protected String getCurrentPage() {
		return RequestHolder.getHttpServletRequest().getParameter("cp");
	}

	protected String getPageSize() {
		return RequestHolder.getHttpServletRequest().getParameter("ps");
	}

	protected void putData(String key, Object value) {
		RequestHolder.setAttribute(key, value);
	}
	
	protected String getUserToken(){
		return CookieHolder.getValue("user_token");
	}

	protected <T> T getRequestProperty(String propKey , Class<T> clazz) {
		return (T)RequestHolder.getParemeter(propKey);
	}
}
