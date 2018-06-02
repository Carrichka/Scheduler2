/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RASS.model.business.managers;

import com.RASS.model.domain.LoginBean;
import com.RASS.model.domain.StaffBean;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author carri
 */
public class LoginManagerTest {
    
    	@Test
	public void testInvalidLogin() throws Exception {
		LoginBean login = new LoginBean();
			login.setUsername("fail");
			login.setPassword("test");
		
		StaffBean customer = (new LoginManager()).authenticate(login);
			if (customer == null){
				System.out.println("testInvalidLogin PASSED");
			} 
	}//end testInvalidLogin
	
	@Test
	public void testValidLogin() throws Exception {
		LoginBean login = new LoginBean();
			login.setUsername("cmartin");
			login.setPassword("password");
		
		StaffBean customer = (new LoginManager()).authenticate(login);
		System.out.println("testValidLogin results " + customer.getFirstname());
		assertNotNull ("authentication failed", customer);
	}// end testValidLogin

}
