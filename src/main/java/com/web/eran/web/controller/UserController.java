package com.web.eran.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
* @author Promise
* @createTime 2019年3月28日 上午11:00:51
* @description
*/
@Controller
@RequestMapping("/user")
public class UserController {

	private final static Logger log = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value="/info",method=RequestMethod.GET)
	public String userInfo() {
		return "user/userInfo";
	}
	
	@RequestMapping(value="/passwordUpdate",method=RequestMethod.GET)
	public String goPasswordUpdatePage() {
		return "user/passwordUpdate";
	}
}
