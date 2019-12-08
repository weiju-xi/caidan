package com.caidan.user.pojo.vo;



import java.io.Serializable;
public class AdminVO implements Serializable{

	private static final long serialVersionUID = -8241621072218036498L;
	private String loginname;//登陆名称

	private String token;
	
	private String roles;
	
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getLoginname() {		
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	


	
}
