package com.web.eran.dao;

/**
 * SysRoleMapper
 */
import java.util.List;
import java.util.Map;

import  com.web.eran.entity.SysRole;
 

public interface SysRoleMapper{

	public int insert(SysRole entity);
	
   	public int update(SysRole entity);
   	
   	public int deleteByPrimaryKey(Long id); 
   	
	public int deleteBySelective(SysRole entity);
	
	public SysRole findById(Long id);
	 
	public List<SysRole> findBySelective(Map<String, Object> map);
	
	public int findBySelectiveCount(Map<String, Object> map);
	
	List<SysRole> getRoleListByUserId(Long userId);
}
