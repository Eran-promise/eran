package com.web.eran.web.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.eran.entity.SysUser;
import com.web.eran.service.ISysUserService;

/**
* @author Promise
* @createTime 2018年12月4日 下午1:19:55
* @description 测试action
*/
@Controller
public class HelloWorld {
	
	private final Logger log=LoggerFactory.getLogger(HelloWorld.class);
	@Autowired
	private ISysUserService sysUserService;
	
	@Autowired
	private ObjectMapper mapper;

	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		log.info("log test!");
		log.info("开启热部署！");
		return "hello world!";
	}
	
	
	@RequestMapping({"/index","/"})
	public String index() {
		log.info("get in index.do");
		return "index";
	}
	
	@RequestMapping("/user")
	@ResponseBody
	public SysUser User(){
		SysUser user = sysUserService.findByUsername("eran");
		try {
			System.out.println(user.toString());
			String str = mapper.writeValueAsString(user);
			System.out.println("json格式："+str);
			SysUser temp = mapper.readValue(str, SysUser.class);
			System.out.println("类格式"+temp);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			
		}
		return user;
	}
	
}
