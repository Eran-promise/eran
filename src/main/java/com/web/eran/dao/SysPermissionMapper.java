package com.web.eran.dao;

/**
 * SysPermissionMapper
 */
import java.util.List;
import java.util.Map;

import  com.web.eran.entity.SysPermission;
 

public interface SysPermissionMapper{

	public int insert(SysPermission entity);
	
   	public int update(SysPermission entity);
   	
   	public int deleteByPrimaryKey(Long id); 
   	
	public int deleteBySelective(SysPermission entity);
	
	public SysPermission findById(Long id);
	 
	public List<SysPermission> findBySelective(Map<String, Object> map);
	
	public int findBySelectiveCount(Map<String, Object> map); 
	
	void insertByList(List<SysPermission> list);
	
	List<SysPermission> getPermissionListByRoleId(Long roleId);
}
