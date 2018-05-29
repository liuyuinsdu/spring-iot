package com.runhang.framework.web;

import lombok.Data;

/**
 * @author runhang
 * @create 2018-04-21 上午9:13
 **/
@Data
public class RestResponseOk implements RestResponse{

    private Object data;

    public RestResponseOk(Object data) {
        this.data = data;
    }
}
