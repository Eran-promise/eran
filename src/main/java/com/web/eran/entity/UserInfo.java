package com.web.eran.entity;
/**
* @author Promise
* @createTime 2018年12月4日 下午11:25:32
* @description 
*/
public class UserInfo {
	
	private String userName;
	private String passWord;
	private String credentialsSalt;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getCredentialsSalt() {
		return credentialsSalt;
	}
	public void setCredentialsSalt(String credentialsSalt) {
		this.credentialsSalt = credentialsSalt;
	}

}
