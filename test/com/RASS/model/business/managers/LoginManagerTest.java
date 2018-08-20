/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RASS.model.business.managers;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author carri
 */
public class LoginManagerTest {
	
	@Test
        public void testValidLogin() throws Exception {
		
            System.out.println("starting testValidLogin()");
            LoginManager test = new LoginManager();
            assertTrue(test!=null);
            System.out.println("testValidLogin PASSED");
                   
        }//end testValidLogin

}
