package com.web.eran.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.eran.dao.SysPermissionMapper;
import com.web.eran.dao.SysRoleMapper;
import com.web.eran.entity.SysPermission;
import com.web.eran.entity.SysRole;
import com.web.eran.service.ISysPermissionService;

/**
* @author Promise
* @createTime 2019年4月8日 下午1:36:55
* @description
*/
@Service("permissionService")
public class SysPermissionServiceImpl implements ISysPermissionService{
	
	@Autowired
	private SysPermissionMapper permissionMapper;
	
	@Autowired
	private SysRoleMapper roleMapper;

	@Override
	public void insertByList(List<SysPermission> list) {
		// TODO Auto-generated method stub
		permissionMapper.insertByList(list);
	}

	@Override
	public void deleteBySelect(SysPermission entity) {
		// TODO Auto-generated method stub
		permissionMapper.deleteBySelective(entity);
	}

	@Override
	public List<SysRole> getRoleListByUserId(Long userId) {
		// TODO Auto-generated method stub
		return roleMapper.getRoleListByUserId(userId);
	}

	@Override
	public List<SysPermission> getPermissionListByRoleId(Long roleId) {
		// TODO Auto-generated method stub
		return permissionMapper.getPermissionListByRoleId(roleId);
	}

}
