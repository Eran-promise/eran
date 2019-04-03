package com.web.eran.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.eran.entity.SysUser;
import com.web.eran.service.ISysUserService;

/**
* @author Promise
* @createTime 2019年3月28日 上午11:00:51
* @description
*/
@Controller
@RequestMapping("/user")
public class UserController {

	private final static Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private ISysUserService userService;
	
	@RequestMapping(value="/info",method=RequestMethod.GET)
	public String userInfo() {
		return "user/userInfo";
	}
	
	@RequestMapping(value="/passwordUpdate",method=RequestMethod.GET)
	public String goPasswordUpdatePage() {
		return "user/passwordUpdate";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public String goUserSearch() {
		return "user/userSearch";
	}
	
	@RequestMapping(value="/deleted", method=RequestMethod.GET)
	public String goUserDeleted() {
		return "user/userDeleted";
	}
	
	@RequestMapping(value="/select", method=RequestMethod.GET)
	@ResponseBody
	public Object userListSelect(int page, int limit) {
		
		Map<String, Object> map = new HashMap<>();
		map.put("startIndex", (page-1)*limit);
		map.put("maxResults", limit);
		List<SysUser> list = userService.findBySelect(map);
		int count = userService.findBySelectCount(map);
		map.clear();
		map.put("count", count);
		map.put("data", list);
		map.put("code", 0);
		return map;
	}
}
