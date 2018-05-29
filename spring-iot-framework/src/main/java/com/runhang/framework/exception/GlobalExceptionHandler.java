package com.runhang.framework.exception;

import com.runhang.framework.web.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author runhang
 * @create 2018-04-02 下午10:02
 **/
public class GlobalExceptionHandler {

    @ExceptionHandler(value = UserNotLoginException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public RestResponse loginExceptionHandler(UserNotLoginException ex){
        return RestResponse.error("user not login");
    }


    @ExceptionHandler(value = UserUnAuthorizedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public RestResponse authExceptionHandler(UserUnAuthorizedException ex){
        return RestResponse.error("user UnAuthorized");
    }


    @ExceptionHandler(value = ServiceRuntimeException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public RestResponse serviceExceptionHandler(ServiceRuntimeException ex){
        return RestResponse.error(ex.getErrorCode() , ex.getMessage());
    }

//    @ExceptionHandler(value = Exception.class)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public RestResponse exception(Exception ex){
//        return RestResponse.error(ex.getMessage());
//    }
}
