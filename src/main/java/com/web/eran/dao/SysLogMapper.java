package com.web.eran.dao;

/**
 * SysLogMapper
 */
import java.util.List;
import java.util.Map;

import  com.web.eran.entity.SysLog;
 

public interface SysLogMapper{

	public int insert(SysLog entity);
	
   	public int update(SysLog entity);
   	
   	public int deleteByPrimaryKey(Long id); 
   	
	public int deleteBySelective(SysLog entity);
	
	public SysLog findById(Long id);
	 
	public List<SysLog> findBySelective(Map<String, Object> map);
	
	public int findBySelectiveCount(Map<String, Object> map); 
}
