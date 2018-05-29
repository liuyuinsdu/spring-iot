package com.runhang.framework.web;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import com.runhang.framework.utils.WebUtils;
import org.springframework.util.StringUtils;


/**
 * Request持有类
 * 
 * @author runhang
 *
 */
public class RequestHolder {
	
	private static final ThreadLocal<HttpServletRequest> requestHolder = new ThreadLocal<HttpServletRequest>();
	
	public static HttpServletRequest getHttpServletRequest(){
		return requestHolder.get();
	}
	
	public static void setHttpServletRequest(HttpServletRequest request){
		requestHolder.set(request);
	}
	
	public static void clear(){
		requestHolder.remove();
	}
	
	public static void setAttribute(String key , Object value){
		getHttpServletRequest().setAttribute(key, value);
	}
	
	public static Object getAttribute(String key){
		return getHttpServletRequest().getAttribute(key);
	}
	
	public static Object getAttribute(String key , boolean decode){
		String value = (String) getHttpServletRequest().getAttribute(key);
		if(StringUtils.isEmpty(value)){
			return "";
		}
		if(decode){
			try {
				value = new String(value.getBytes("ISO8859-1"),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return value;
	}
	
	public static Object getParemeter(String key){
		return getParemeter(key , false);
	}
	
	public static Object getParemeter(String key , boolean decode){
		String value = getHttpServletRequest().getParameter(key);
		if(StringUtils.isEmpty(value)){
			return "";
		}
		if(decode){
			try {
				value = new String(value.getBytes("ISO8859-1"),"UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return value;
	}
	
	public static String getRemoteIP() {
		return WebUtils.getRemoteIP(getHttpServletRequest());
	}

	public static String getHeader(String header){
		return getHttpServletRequest().getHeader(header);
	}

}
