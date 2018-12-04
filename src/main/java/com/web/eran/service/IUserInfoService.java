package com.web.eran.service;
/**
* @author Promise
* @createTime 2018年12月4日 下午11:20:44
* @description 
*/

import com.web.eran.entity.UserInfo;

public interface IUserInfoService {

	public UserInfo findByUsername(String userName);
}
