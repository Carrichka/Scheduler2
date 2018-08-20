/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RASS.model.domain;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carri Martin
 */
public class LoginBeanTest {
    
    public LoginBeanTest() {
    }
    
    /**
    * Tests with a valid login passed in
    */	
    @Test
    public void testValidate() {
        System.out.println("starting testValidate()");
	LoginBean b1 = new LoginBean ();
            b1.setUsername("cmartin@regis.edu");
            b1.setPassword("password");
	// should assert to True since all variables are valid.
	assertTrue ("b1 validates", b1.validate());
	System.out.println("testValidate PASSED");
    }
    
    /**
     * Tests with an invalid login passed in
    */
    @Test
    public void testNotValidate() {
        System.out.println("starting testNotValidate()");
	LoginBean b1 = new LoginBean ();
	// b1.validate should not pass here because no valid variables were passed in
	// EventBean class is valid only if all class variables are passed
	assertFalse ("b1 does not validate", b1.validate());
	System.out.println("testNotValidate PASSED");
    }
    
    /**
    * Tests if two logins are equal
    */
    @Test	
    public void testEqualsLogin() {
            System.out.println("starting testEqualsEvent()");
            LoginBean b1 = new LoginBean();
                b1.setUsername("cmartin@regis.edu");
                b1.setPassword("password");
            LoginBean b2 = new LoginBean();
                b2.setUsername("cmartin@regis.edu");
                b2.setPassword("password");
            // this should assert to true since the contents of 
            // b1 and b2 class variables are identical.
            assertTrue ("b1 equals b2", b1.equals(b2));
            System.out.println("testEqualsEvent PASSED");		
    }
    
    /**
    * Tests if two logins are not equal
    */
    @Test
    public void testNotEqualsLogin() {
            System.out.println("starting testNotEqualsEvent()");
            LoginBean b1 = new LoginBean();
                b1.setUsername("cmartin@regis.edu");
                b1.setPassword("password");
            LoginBean b2 = new LoginBean();
                b2.setUsername("carri@regis.edu");
                b2.setPassword("regis");
            // this should assert to false since the contents of 
            // b1 and b2 class variables are NOT identical.
            assertFalse ("b1 does NOT equal b2", b1.equals(b2));
            System.out.println("testNotEqualsEvent PASSED");		
    }
 
}// end LoginBeanTest
