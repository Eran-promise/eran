package com.web.eran.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* @author Promise
* @createTime 2018年12月4日 下午1:19:55
* @description 测试action
*/
@Controller
public class HelloWorld {
	
	private final Logger log=LoggerFactory.getLogger(HelloWorld.class);

	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		log.info("log test!");
		log.info("开启热部署！");
		return "Hello World!";
	}
	
	@RequestMapping({"/index","/"})
	public String index() {
		log.info("get in index.do");
		return "index";
	}
	
}
