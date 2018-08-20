package com.RASS.model.domain;

/**
 *
 * @author Carri Martin
 */
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
        
        public boolean validate() {
		if (username == null || "".equals(username))
			return false;
		if (password == null || "".equals(password))
			return false;
		
		return true;
	}// end validate
        
        @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());

		return result;
	}
        
        @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginBean  other = (LoginBean ) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		
		return true;
	}// end equals
        
        @Override
	public String toString() {
		return "LoginBean [username=" + username 
                                + ", password=" + password + "]";
	}

}//end LoginBean
