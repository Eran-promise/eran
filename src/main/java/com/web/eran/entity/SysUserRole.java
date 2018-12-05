package com.web.eran.entity;

/**
 * sys_user_role
 */
 
 
public class SysUserRole{
	// : id 	
	private Long id; 
	
	// : sys_user_id 	
	private Long sysUserId; 
	
	// : sys_role_id 	
	private Long sysRoleId; 
	

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
	 *  : sys_user_id
	 * 
	 * @return 
	 */
	public Long getSysUserId () {
		return sysUserId;
	}
	
	/**
	 *  : sys_user_id
	 * 
	 * @return 
	 */
	public void setSysUserId (Long sysUserId) {
		this.sysUserId = sysUserId;
	}
	/**
	 *  : sys_role_id
	 * 
	 * @return 
	 */
	public Long getSysRoleId () {
		return sysRoleId;
	}
	
	/**
	 *  : sys_role_id
	 * 
	 * @return 
	 */
	public void setSysRoleId (Long sysRoleId) {
		this.sysRoleId = sysRoleId;
	}

	@Override
	public String toString() {
			return "SysUserRole ["+
						"id=" + id +
								",sysUserId=" + sysUserId +
								",sysRoleId=" + sysRoleId +
							"]";
	}

 
}
