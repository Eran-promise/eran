package com.web.eran.service;


import java.util.List;
import java.util.Map;

import com.web.eran.entity.SysUser;

/**
* @author Promise
* @createTime 2018年12月4日 下午11:20:44
* @description 
*/


public interface ISysUserService {

	public SysUser findByUsername(String userName);
	
	public int update(SysUser entity);
	
	List<SysUser> findBySelect(Map<String, Object> map);
	
	int findBySelectCount(Map<String, Object> map);
}
