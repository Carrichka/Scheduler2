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
public class EventBeanTest {
    
    public EventBeanTest() {
    }
    
    /**
    * Tests with a valid event passed in
    */	
    @Test
    public void testValidate() {
        System.out.println("starting testValidate()");
	EventBean b1 = new EventBean (1, "1", 1,"Kate","Daniels","2018-7-04", 1, "Coed");
	// should assert to True since all variables are valid.
	assertTrue ("b1 validates", b1.validate());
	System.out.println("testValidate PASSED");
    }
    
    /**
     * Tests with an invalid event passed in
    */
    @Test
    public void testNotValidate() {
        System.out.println("starting testNotValidate()");
	EventBean b1 = new EventBean ();
	// b1.validate should not pass here because no valid variables were passed in
	// EventBean class is valid only if all class variables are passed
	assertFalse ("b1 does not validate", b1.validate());
	System.out.println("testNotValidate PASSED");
    }
    
    /**
    * Tests if two EventBeans are equal
    */
    @Test	
    public void testEqualsEvent() {
            System.out.println("starting testEqualsEvent()");
            EventBean b1 = new EventBean (1, "1", 1,"Kate","Daniels","2018-7-04", 1, "Coed");
            EventBean b2 = new EventBean (1, "1", 1,"Kate","Daniels","2018-7-04", 1, "Coed");
            // this should assert to true since the contents of 
            // b1 and b2 class variables are identical.
            assertTrue ("b1 equals b2", b1.equals(b2));
            System.out.println("testEqualsEvent PASSED");		
    }
    
    /**
    * Tests if two EventBeans are not equal
    */
    @Test
    public void testNotEqualsEvent() {
            System.out.println("starting testNotEqualsEvent()");
            EventBean b1 = new EventBean (1, "1", 1,"Kate","Daniels","2018-7-04", 1, "Coed");
            EventBean b2 = new EventBean (2, "2", 2,"Kat","Jones","2018-7-05", 2, "Mens");
            // this should assert to false since the contents of 
            // b1 and b2 class variables are NOT identical.
            assertFalse ("b1 does NOT equal b2", b1.equals(b2));
            System.out.println("testNotEqualsEvent PASSED");		
    }
    
}// end EventBeanTest
