package com.web.eran.service;


import com.web.eran.entity.SysUser;

/**
* @author Promise
* @createTime 2018年12月4日 下午11:20:44
* @description 
*/


public interface ISysUserService {

	public SysUser findByUsername(String userName);
	
	public int update(SysUser entity);
}
