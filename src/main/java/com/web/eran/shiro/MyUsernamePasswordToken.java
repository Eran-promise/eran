package com.web.eran.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
* @author Promise
* @createTime 2018年12月13日 下午9:30:32
* @description 自定义token,加入验证码
*/
public class MyUsernamePasswordToken extends UsernamePasswordToken{

	/**
	 * 序列化id
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 验证码
	 */
	private String vercode;
	
	MyUsernamePasswordToken(String username,String password,String vercode,boolean rememberMe){
		super(username, password, rememberMe, "");
		this.vercode=vercode;
	}
	
	public String getVercode() {
		return this.vercode;
	}
}
