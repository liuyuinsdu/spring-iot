package com.runhang.framework.exception;

/**
 * @author runhang
 * @create 2018-04-25 上午8:07
 **/
public class RemoteServiceRuntimeException extends ServiceRuntimeException  {

    public RemoteServiceRuntimeException(Integer errorCode , String message) {
        super(errorCode , message);
    }

}
