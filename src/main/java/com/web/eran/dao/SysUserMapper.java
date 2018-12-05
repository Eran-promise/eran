package com.web.eran.dao;

/**
 * SysUserMapper
 */
import java.util.List;
import java.util.Map;

import  com.web.eran.entity.SysUser;
 

public interface SysUserMapper{

	public int insert(SysUser entity);
	
   	public int update(SysUser entity);
   	
   	public int deleteByPrimaryKey(Long id); 
   	
	public int deleteBySelective(SysUser entity);
	
	public SysUser findById(Long id);
	 
	public List<SysUser> findBySelective(Map<String, Object> map);
	
	public int findBySelectiveCount(Map<String, Object> map); 
	
	public SysUser getUserByName(String userName);
}
