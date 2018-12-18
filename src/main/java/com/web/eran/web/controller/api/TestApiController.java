package com.web.eran.web.controller.api;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.eran.entity.SysUser;
import com.web.eran.service.ISysUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
* @author Promise
* @createTime 2018年12月18日 下午11:26:49
* @description  测试swagger2接口
*/
@Api(value="用户接口")
@RestController
@RequestMapping("/api/v1")
public class TestApiController {

	@Autowired
	private ISysUserService sysUserService;
	
	@ApiOperation(value = "获取用户信息", notes = "根据用户名获取用户信息")
	@ApiImplicitParam(name = "username", value = "用户名", required = true, dataType = "String", paramType = "path")
	@GetMapping("/{username}")
	public SysUser user(@PathVariable(value="username") String username) {
		
		SysUser user = sysUserService.findByUsername(username);
		return user;
	}
	
	@ApiOperation(value="获取用户列表" ,notes="获取所有用户信息")
	@GetMapping("/user/list")
	public List<SysUser> userList(){
		List<SysUser> lists = new ArrayList<>();
		SysUser user =new SysUser();
		user.setId(2L);
		user.setUsername("promise");
		user.setPassword("123456");
		lists.add(user);
		SysUser user2 =new SysUser();
		user2.setId(3L);
		user2.setUsername("admin");
		user2.setPassword("123456");
		lists.add(user2);
		return lists;
	}
	
	@ApiOperation(value="添加用户", notes="添加新用户")
	@ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "SysUser")
	@PostMapping("/user")
	public Map<String, String> addUser(@RequestBody SysUser user){
		Map<String, String> map =new HashMap<>();
		System.out.println(user);
		if(user!=null)
			map.put("res", "success");
		else
			map.put("res", "error");
		return map;
	}
	
	@ApiOperation(value="删除用户", notes="根据id删除用户")
	@ApiImplicitParam(name="userId", value="用户id", required=true, dataType="Long", paramType = "path")
	@DeleteMapping("/{userId}")
	public Map<String, String> deleteUser(@PathVariable(value="userId") Long userId){
		Map<String, String> map =new HashMap<>();
		System.out.println(userId);
		if(userId>0)
			map.put("res", "success");
		else
			map.put("res", "error");
		return map;
	}
	
	@ApiOperation(value = "更新用户", notes = "根据用户id更新用户")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "userId", value = "用户id", required = true, dataType = "Long", paramType = "path"),
        @ApiImplicitParam(name = "user", value = "用户实体", required = true, dataType = "SysUser") })
    @PutMapping("/{userId}")
    public Map<String, Object> updateUser(@PathVariable(value = "userId") Long userId, @RequestBody SysUser user) {
        Map<String, Object> map = new HashMap<>();
        user.setId(userId);
        System.out.println(user);
        map.put("result", "success");
        return map;
    }
}
