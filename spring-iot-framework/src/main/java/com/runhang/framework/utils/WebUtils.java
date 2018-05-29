package com.runhang.framework.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author runhang
 * @create 2018-04-23 下午7:35
 **/
public class WebUtils {

    public static String getRemoteIP(HttpServletRequest Request) {
        if (Request.getHeader("x-forwarded-for") == null) {
            String ip = Request.getRemoteAddr();
            return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
        }
        return Request.getHeader("x-forwarded-for");
    }

}
