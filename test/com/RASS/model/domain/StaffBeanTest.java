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
public class StaffBeanTest {
    
    public StaffBeanTest() {
    }
    
    /**
    * Tests with a valid StaffBean passed in
    */	
    @Test
    public void testValidate() {
        System.out.println("starting testValidate()");
	StaffBean b1 = new StaffBean (1, "Kate","Daniels","N");
	// should assert to True since all variables are valid.
	assertTrue ("b1 validates", b1.validate());
	System.out.println("testValidate PASSED");
    }
    
    /**
     * Tests with an invalid StaffBean passed in
    */
    @Test
    public void testNotValidate() {
        System.out.println("starting testNotValidate()");
	StaffBean b1 = new StaffBean ();
	// b1.validate should not pass here because no valid variables were passed in
	// EventBean class is valid only if all class variables are passed
	assertFalse ("b1 does not validate", b1.validate());
	System.out.println("testNotValidate PASSED");
    }
    
    /**
    * Tests if two StaffBeans are equal
    */
    @Test	
    public void testEqualsEvent() {
            System.out.println("starting testEqualsEvent()");
            StaffBean b1 = new StaffBean (1, "Kate","Daniels","N");
            StaffBean b2 = new StaffBean (1, "Kate","Daniels","N");
            // this should assert to true since the contents of 
            // b1 and b2 class variables are identical.
            assertTrue ("b1 equals b2", b1.equals(b2));
            System.out.println("testEqualsEvent PASSED");		
    }
    
    /**
    * Tests if two StaffBeans are not equal
    */
    @Test
    public void testNotEqualsEvent() {
            System.out.println("starting testNotEqualsEvent()");
            StaffBean b1 = new StaffBean (1, "Kate","Daniels","N");
            StaffBean b2 = new StaffBean (2, "Kate","Jones","N");
            // this should assert to false since the contents of 
            // b1 and b2 class variables are NOT identical.
            assertFalse ("b1 does NOT equal b2", b1.equals(b2));
            System.out.println("testNotEqualsEvent PASSED");		
    }
    
}// end StaffBeanTest
