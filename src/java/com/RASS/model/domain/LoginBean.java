package com.RASS.model.domain;

public class LoginBean {

	//default constructor
	public LoginBean() {
		
	}

	private String username;
	
	//username setter
	public void setUsername(String username){
		this.username = username;
	}
	
	//username getter
	public String getUsername(){
		return username;
	}

	private String password;
	
	//password setter
	public void setPassword(String password){
		this.password = password;
	}
	
	//password getter
	public String getPassword (){
		return password;
	}

}
