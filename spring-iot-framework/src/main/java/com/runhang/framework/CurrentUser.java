package com.runhang.framework;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * @Description:保存在session中的用户信息
 * @author runhang 2014年12月13日上午9:34:26
 *
 */
@Data
public class CurrentUser implements Serializable{

	private static final long serialVersionUID = -9209482975532977661L;
	
	private String uid;
	private String account;
	private Date loginTime;
	private boolean invalid;
	private String ip;
	private String nickname;
	private boolean loggedIn;
	private List<String> roles;

}
