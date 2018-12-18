package com.web.eran.entity;

/**
 * sys_log
 */
 
 
public class SysLog{
	//主键 : id 	
	private Long id; 
	
	//操作员id : user_id 	
	private Long userId; 
	
	//用户操作 : user_action 	
	private String userAction; 
	
	//创建时间 : create_time 	
	private java.sql.Timestamp createTime; 
	

	/**
	 * 主键 : id
	 * 
	 * @return 
	 */
	public Long getId () {
		return id;
	}
	
	/**
	 * 主键 : id
	 * 
	 * @return 
	 */
	public void setId (Long id) {
		this.id = id;
	}
	/**
	 * 操作员id : user_id
	 * 
	 * @return 
	 */
	public Long getUserId () {
		return userId;
	}
	
	/**
	 * 操作员id : user_id
	 * 
	 * @return 
	 */
	public void setUserId (Long userId) {
		this.userId = userId;
	}
	/**
	 * 用户操作 : user_action
	 * 
	 * @return 
	 */
	public String getUserAction () {
		return userAction;
	}
	
	/**
	 * 用户操作 : user_action
	 * 
	 * @return 
	 */
	public void setUserAction (String userAction) {
		this.userAction = userAction;
	}
	/**
	 * 创建时间 : create_time
	 * 
	 * @return 
	 */
	public java.sql.Timestamp getCreateTime () {
		return createTime;
	}
	
	/**
	 * 创建时间 : create_time
	 * 
	 * @return 
	 */
	public void setCreateTime (java.sql.Timestamp createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
			return "SysLog ["+
						"id=" + id +
								",userId=" + userId +
								",userAction=" + userAction +
								",createTime=" + createTime +
							"]";
	}

 
}
