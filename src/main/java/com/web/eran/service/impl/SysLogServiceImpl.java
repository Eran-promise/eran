package com.web.eran.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.eran.dao.SysLogMapper;
import com.web.eran.entity.SysLog;
import com.web.eran.service.ISysLogService;

/**
* @author Promise
* @createTime 2018年12月18日 下午9:30:57
* @description 
*/
@Service("sysLogService")
public class SysLogServiceImpl implements ISysLogService{

	@Autowired
	private SysLogMapper sysLogMapper;
	
	@Override
	public int insertLog(SysLog entity) {
		// TODO Auto-generated method stub
		return sysLogMapper.insert(entity);
	}

}
