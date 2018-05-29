package com.runhang.framework.exception;

public class ServiceRuntimeException extends RuntimeException {
	
	private static final long serialVersionUID = -2338850804995829140L;
	
	private String message;
	
	private Integer errorCode;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public ServiceRuntimeException() {
	}
	
	public ServiceRuntimeException(Throwable e) {
		super(e);
	}
	
	public ServiceRuntimeException(String message) {
		super(message);
	}
	
	public ServiceRuntimeException(Integer errorCode , String message) {
		super(message);
		this.errorCode = errorCode;
	}
}
