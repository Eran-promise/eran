package com.web.eran.service;

import java.util.List;

import com.web.eran.entity.SysPermission;
import com.web.eran.entity.SysRole;

/**
* @author Promise
* @createTime 2019年4月8日 下午1:35:51
* @description
*/
public interface ISysPermissionService {
	void insertByList(List<SysPermission> list);
	
	void deleteBySelect(SysPermission entity);
	
	List<SysRole> getRoleListByUserId(Long userId);
	
	List<SysPermission> getPermissionListByRoleId(Long roleId);
}
