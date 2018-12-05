package com.web.eran.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	private final Logger log = LoggerFactory.getLogger(SysUserServiceImpl.class);
	
	@Autowired
	private SysUserMapper sysUserMapper;

	@Override
	public SysUser findByUsername(String userName) {
		return sysUserMapper.getUserByName(userName);
	}

}
