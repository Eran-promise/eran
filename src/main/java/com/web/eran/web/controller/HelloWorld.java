package com.web.eran.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.eran.shiro.MyShiroRealm;

/**
* @author Promise
* @createTime 2018年12月4日 下午1:19:55
* @description 测试action
*/
@Controller
public class HelloWorld {
	
	private final Logger log=LoggerFactory.getLogger(HelloWorld.class);

	@RequestMapping("/noPower")
	public String noPower() {
		System.out.println("shiro拦截");
		return "common/403";
	}
	
	@RequestMapping(value="/clear")
	@ResponseBody
	public String clearShouquanCache() {
		DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager)SecurityUtils.getSecurityManager();
        MyShiroRealm shiroRealm = (MyShiroRealm) securityManager.getRealms().iterator().next();
        //清除权限 相关的缓存
        shiroRealm.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
        return "ok";
	}
	
	
	@RequestMapping({"/index","/"})
	public String index() {
		log.info("get in index.do");
		return "index";
	}
	
}
