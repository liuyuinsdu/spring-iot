package com.runhang.framework.web;

/**
 * 
 * @Title: 
 * @Description: 
 * @author runhang
 * @date 2016年1月30日 下午8:08:56 
 * @version V1.0
 */
public class ResponseStatus {

	public static final Integer SUCCESS = 200;
	public static final Integer INTERNAL_ERROR = 500;
	public static final Integer FAILURE = 501;
	public static final Integer NEED_LOGIN = 4001;
	public static final Integer LOGIN_FAIL = 4002;
	public static final Integer LOGIN_EXPIRE = 4003;
	public static final Integer USER_EXISTS = 4004;
	public static final Integer USER_VALID_CODE_FAIL = 4005;
}
