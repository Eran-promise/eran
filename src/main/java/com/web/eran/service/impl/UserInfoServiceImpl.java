package com.web.eran.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.web.eran.entity.UserInfo;
import com.web.eran.service.IUserInfoService;

/**
* @author Promise
* @createTime 2018年12月4日 下午11:21:44
* @description 
*/
@Service("userInfoService")
public class UserInfoServiceImpl implements IUserInfoService{
	
	private final Logger log = LoggerFactory.getLogger(UserInfoServiceImpl.class);

	@Override
	public UserInfo findByUsername(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
