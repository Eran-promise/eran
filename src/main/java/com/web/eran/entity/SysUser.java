package com.web.eran.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * sys_user
 */
 
 
public class SysUser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//主键 : id 	
	private Long id; 
	
	//账号 : usercode 	
	private String usercode; 
	
	//姓名 : username 	
	private String username; 
	
	//密码 : password 	
	private String password; 
	
	//盐 : salt 	
	private String salt; 
	
	//账号是否锁定，1：锁定，0未锁定 : locked 	
	private String locked; 
	

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
	 * 账号 : usercode
	 * 
	 * @return 
	 */
	public String getUsercode () {
		return usercode;
	}
	
	/**
	 * 账号 : usercode
	 * 
	 * @return 
	 */
	public void setUsercode (String usercode) {
		this.usercode = usercode;
	}
	/**
	 * 姓名 : username
	 * 
	 * @return 
	 */
	public String getUsername () {
		return username;
	}
	
	/**
	 * 姓名 : username
	 * 
	 * @return 
	 */
	public void setUsername (String username) {
		this.username = username;
	}
	/**
	 * 密码 : password
	 * 
	 * @return 
	 */
	public String getPassword () {
		return password;
	}
	
	/**
	 * 密码 : password
	 * 
	 * @return 
	 */
	public void setPassword (String password) {
		this.password = password;
	}
	/**
	 * 盐 : salt
	 * 
	 * @return 
	 */
	public String getSalt () {
		return salt;
	}
	
	/**
	 * 盐 : salt
	 * 
	 * @return 
	 */
	public void setSalt (String salt) {
		this.salt = salt;
	}
	/**
	 * 账号是否锁定，1：锁定，0未锁定 : locked
	 * 
	 * @return 
	 */
	public String getLocked () {
		return locked;
	}
	
	/**
	 * 账号是否锁定，1：锁定，0未锁定 : locked
	 * 
	 * @return 
	 */
	public void setLocked (String locked) {
		this.locked = locked;
	}

	@Override
	public String toString() {
			return "SysUser ["+
						"id=" + id +
								",usercode=" + usercode +
								",username=" + username +
								",password=" + password +
								",salt=" + salt +
								",locked=" + locked +
							"]";
	}

 
}
