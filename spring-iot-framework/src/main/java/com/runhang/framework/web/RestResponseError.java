package com.runhang.framework.web;

import lombok.Data;

import java.util.HashMap;

/**
 * @author runhang
 * @create 2018-04-21 上午9:13
 **/
@Data
public class RestResponseError extends HashMap<String , Object> implements RestResponse {

    public RestResponseError(String message) {
        this.put("error_code" , null);
        this.put("error_message" , message);
    }


    public RestResponseError(Integer status , String message) {
        this.put("error_code" , status);
        this.put("error_message" , message);
    }

    public Integer getErrorCode(){
        return (Integer) this.get("error_code");
    }

    public String getErrorMessage(){
        return (String)this.get("error_message");
    }

    @Override
    public Object getData() {
        return this;
    }
}
