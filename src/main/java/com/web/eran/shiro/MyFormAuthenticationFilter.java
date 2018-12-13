package com.web.eran.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

/**
* @author Promise
* @createTime 2018年12月13日 下午9:37:31
* @description 自定义shiro拦截器，加入验证码
*/
public class MyFormAuthenticationFilter extends FormAuthenticationFilter{

	@Override
	protected AuthenticationToken createToken(String username,String password,ServletRequest request,ServletResponse reponse) {
		//获取表单提交中的验证码
		String vercode = request.getParameter("vercode");
		//获取表单提交中rememberMe的值
		boolean rememberMe = request.getParameter("rememberMe")==null?false:true;
		//返回待带证码以及rememberMe的token
		return new MyUsernamePasswordToken(username, password, vercode, rememberMe);
	}
}
