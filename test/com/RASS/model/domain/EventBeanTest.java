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
	assertNotNull (b1);
	System.out.println("testValidate PASSED");
    }
    
    /**
    * Tests if two books are equal
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
    * Tests if two books are not equal
    */
    @Test
    public void testNotEqualsEvent() {
            System.out.println("starting testNotEqualsEvent()");
            EventBean b1 = new EventBean (1, "1", 1,"Kate","Daniels","2018-7-04", 1, "Coed");
            EventBean b2 = new EventBean (2, "2", 2,"Kat","Jones","2018-7-05", 2, "Mens");
            // this should assert to false since the contents of 
            // b1 and b2 class variables are NOT identical.
            assertFalse ("b1 does NOT equal b2", b1.equals(b2));
            System.out.println("testNotEqualsBook PASSED");		
    }
    
}// end EventBeanTest
