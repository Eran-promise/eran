package com.web.eran.dao;

/**
 * SysRolePermissionMapper
 */
import java.util.List;
import java.util.Map;

import  com.web.eran.entity.SysRolePermission;
 

public interface SysRolePermissionMapper{

	public int insert(SysRolePermission entity);
	
   	public int update(SysRolePermission entity);
   	
   	public int deleteByPrimaryKey(Long id); 
   	
	public int deleteBySelective(SysRolePermission entity);
	
	public SysRolePermission findById(Long id);
	 
	public List<SysRolePermission> findBySelective(Map<String, Object> map);
	
	public int findBySelectiveCount(Map<String, Object> map); 
}
