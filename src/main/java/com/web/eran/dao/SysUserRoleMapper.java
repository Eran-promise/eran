package com.web.eran.dao;

/**
 * SysUserRoleMapper
 */
import java.util.List;
import java.util.Map;

import  com.web.eran.entity.SysUserRole;
 

public interface SysUserRoleMapper{

	public int insert(SysUserRole entity);
	
   	public int update(SysUserRole entity);
   	
   	public int deleteByPrimaryKey(Long id); 
   	
	public int deleteBySelective(SysUserRole entity);
	
	public SysUserRole findById(Long id);
	 
	public List<SysUserRole> findBySelective(Map<String, Object> map);
	
	public int findBySelectiveCount(Map<String, Object> map); 
}
