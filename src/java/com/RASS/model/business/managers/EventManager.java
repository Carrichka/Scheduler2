/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RASS.model.business.managers;

import com.RASS.model.domain.EventBean;

/**
 *
 * @author Carri Martin
 */
public class EventManager {
	
	public EventManager() {
		
	}
	
	public EventBean scheduleEvent(EventBean event) {
		
		EventBean returnEvent = new EventBean();
 
		returnEvent.setStaffFirstName("Jane");
		returnEvent.setStaffLastName("Doe");
		returnEvent.setScheduledDate("5/30/2018");
					
		return returnEvent;	

	}//end authenticate
}
