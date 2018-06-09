package com.RASS.model.domain;

public class LoginBean {

	/** Default Constructor*/
	public LoginBean() {
		
	}

        /** username */
	private String username;
	
	/**
	 * 
	 * @param username
	 */
	public void setUsername(String username){
		this.username = username;
	}
	
	/**
	 * 
	 * @return the username
	 */
	public String getUsername(){
		return username;
	}

        /** password */
	private String password;
	
	/**
	 * 
	 * @param password
	 */
	public void setPassword(String password){
		this.password = password;
	}
	
	/**
	 * 
	 * @return the password
	 */
	public String getPassword (){
		return password;
	}

}
