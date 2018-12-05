package com.web.eran.entity;

/**
 * sys_role_permission
 */
 
 
public class SysRolePermission{
	// : id 	
	private Long id; 
	
	//角色id : sys_role_id 	
	private Long sysRoleId; 
	
	//权限id : sys_permission_id 	
	private Long sysPermissionId; 
	

	/**
	 *  : id
	 * 
	 * @return 
	 */
	public Long getId () {
		return id;
	}
	
	/**
	 *  : id
	 * 
	 * @return 
	 */
	public void setId (Long id) {
		this.id = id;
	}
	/**
	 * 角色id : sys_role_id
	 * 
	 * @return 
	 */
	public Long getSysRoleId () {
		return sysRoleId;
	}
	
	/**
	 * 角色id : sys_role_id
	 * 
	 * @return 
	 */
	public void setSysRoleId (Long sysRoleId) {
		this.sysRoleId = sysRoleId;
	}
	/**
	 * 权限id : sys_permission_id
	 * 
	 * @return 
	 */
	public Long getSysPermissionId () {
		return sysPermissionId;
	}
	
	/**
	 * 权限id : sys_permission_id
	 * 
	 * @return 
	 */
	public void setSysPermissionId (Long sysPermissionId) {
		this.sysPermissionId = sysPermissionId;
	}

	@Override
	public String toString() {
			return "SysRolePermission ["+
						"id=" + id +
								",sysRoleId=" + sysRoleId +
								",sysPermissionId=" + sysPermissionId +
							"]";
	}

 
}
