package com.web.eran.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.web.eran.dao.SysUserMapper;
import com.web.eran.entity.SysUser;
import com.web.eran.service.ISysUserService;

/**
* @author Promise
* @createTime 2018年12月4日 下午11:21:44
* @description 
*/
@Service("SysUserService")
public class SysUserServiceImpl implements ISysUserService{
	
	@Autowired
	private SysUserMapper sysUserMapper;
	
	private static final String CACHE_KEY = "'user'";
	
	private static final String CACHE_NAME = "userCache";

	@Override
	@Cacheable(value=CACHE_NAME,key="'user1'")
	public SysUser findByUsername(String userName) {
		return sysUserMapper.getUserByName(userName);
	}

	@Override
	@CacheEvict(value=CACHE_NAME,key="'user1'")
	public int update(SysUser entity) {
		// TODO Auto-generated method stub
		return sysUserMapper.update(entity);
	}

}
