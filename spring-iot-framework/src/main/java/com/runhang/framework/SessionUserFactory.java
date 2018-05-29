package com.runhang.framework;

import com.runhang.framework.utils.JwtUtils;

import java.util.Date;
import java.util.Map;

/**
 * 
 * @Description:
 * @author runhang
 * 2015年3月28日下午2:11:05
 *
 */
public class SessionUserFactory {

	public static CurrentUser createSessionUser(Map<String , Object> claims){
		CurrentUser currentUser = new CurrentUser();
		currentUser.setAccount((String) claims.get("account"));
		currentUser.setIp((String) claims.get("ip"));
		currentUser.setLoginTime((Date) claims.get("loginTime"));
		currentUser.setNickname((String) claims.get("nickname"));
		currentUser.setUid((String) claims.get("uid"));
		currentUser.setLoggedIn((Boolean) claims.get("loggedIn"));
		return currentUser;
	}

	public static CurrentUser getCurrentUser(String token , String securityKey){
		Map<String, Object> claims = JwtUtils.parse(token, securityKey);
		CurrentUser currentUser = new CurrentUser();
		currentUser.setAccount((String) claims.get("account"));
		currentUser.setIp((String) claims.get("ip"));
		currentUser.setLoginTime(new Date((Long) claims.get("loginTime")));
		currentUser.setNickname((String) claims.get("nickname"));
		currentUser.setUid((String) claims.get("uid"));
		currentUser.setLoggedIn((Boolean) claims.get("loggedIn"));
		return currentUser;
	}

}
