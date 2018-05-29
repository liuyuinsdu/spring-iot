package com.runhang.framework.web;

/**
 * @author runhang 2015年8月25日上午9:06:56
 * @Description:用来包装rest请求返回的数据
 */
public interface RestResponse {

    static RestResponse ok() {
        return ok(null);
    }

    static RestResponse ok(Object data) {
        return new RestResponseOk(data);
    }

    static RestResponse error(String message) {
        return new RestResponseError(message);
    }

    static RestResponse error(Integer status , String message) {
        return new RestResponseError(status , message);
    }

    Object getData();
}
