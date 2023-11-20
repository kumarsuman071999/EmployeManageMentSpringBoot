package com.employee_management.entity;

import java.io.Serializable;

public class JwtAuthRequest implements Serializable{
	
	private String username;
	private String password;
	
	public JwtAuthRequest() {
		
	}
	
	
	public JwtAuthRequest(String username, String password) {
	
		this.username = username;
		this.password = password;
	}
	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
