package org.runhang.cloud.api.gateway.filter;

import com.runhang.framework.utils.Constants;
import com.runhang.framework.utils.JsonUtils;
import com.runhang.framework.utils.JwtUtils;
import com.runhang.framework.utils.StringHelper;
import com.runhang.framework.utils.WebUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 检查用户是否登录
 *
 * @author runhang
 */
public class AccessFilter extends ZuulFilter {

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        String method = ctx.getRequest().getMethod();
        String url = (String) ctx.get(FilterConstants.REQUEST_URI_KEY);
        String serviceId = (String) ctx.get(FilterConstants.PROXY_KEY);
        return method.toLowerCase() != "options" && !url.equals("/login");
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String authorization = request.getHeader(Constants.OAUTH.HEADER_KEY_NAME);
        String token = "";
        boolean hasAuth = false;
        if (authorization == null) {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals(Constants.TOKEN.TMP_COOKIE_NAME)) {
                        String tmpToken = cookie.getValue();
                        if (tmpToken != null) {
                            hasAuth = true;
                            token = tmpToken;
                        }
                    }
                }
            }
        } else {
            if (authorization.length() > 7) {
                String HeadStr = authorization.substring(0, 6).toLowerCase();
                if (HeadStr.compareTo("bearer") == 0) {
                    token = authorization.substring(7, authorization.length());
                    if (StringHelper.isNotEmpty(token)) {
                        hasAuth = true;
                        Cookie[] cookies = request.getCookies();
                        if (cookies != null) {
                            for (Cookie cookie : cookies) {
                                if (cookie.getName().equals(Constants.TOKEN.TMP_COOKIE_NAME)) {
                                    cookie.setMaxAge(0);
                                    cookie.setPath("/");
                                }
                            }
                        }
                    }
                }
            }
        }
        if (!hasAuth) {
            token = this.createTempToken(request, ctx.getResponse());
            Cookie cookie = new Cookie(Constants.TOKEN.TMP_COOKIE_NAME, token);
            cookie.setHttpOnly(false);
            // 如果不设置路径,只有当前路径和自路径可以访问,访问其他地址时候cookie不会被传递到服务端
            cookie.setPath("/");
            cookie.setDomain("localhost");
            // 设置7天内有效
            cookie.setMaxAge(60 * 60 * 24 * 7);
            // 浏览器退出时清空cookie
            // cookie.setMaxAge(-1);
            ctx.getResponse().addCookie(cookie);
        }
        ctx.addZuulRequestHeader(Constants.TOKEN.HEADER_KEY_NAME, token);
        return null;
    }

    protected String createTempToken(HttpServletRequest request, HttpServletResponse response) {
        // 创建临时的token作为用户唯一凭证
        Map<String, Object> claims = new HashMap<>();
        claims.put("account", "temp");
        claims.put("nickname", "tempUser");
        claims.put("ip", WebUtils.getRemoteIP(request));
        claims.put("loginTime", new Date());
        claims.put("uid", request.getSession().getId());
        claims.put("loggedIn", false);
        String tempToken = JwtUtils.create(JsonUtils.toJsonString(claims), Constants.TOKEN.JWT_SECURITY_KEY);
        return tempToken;
    }

    @Override
    public String filterType() {
        return FilterConstants.ROUTE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

}
