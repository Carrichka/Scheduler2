/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RASS.model.business.managers;

import com.RASS.model.domain.EventBean;
import com.RASS.model.services.listevent.ListEventDAO;
import com.RASS.model.services.servicefactory.ServiceFactory;
import com.RASS.model.services.scheduleevent.ScheduleEventDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Carri Martin
 */
public class EventManager {
	
	public EventManager() {
		
	}
	
	public EventBean scheduleEvent(EventBean newevent) throws Exception {
		
		EventBean returnEvent = new EventBean();
 
		ServiceFactory factory = new ServiceFactory();
                
                ScheduleEventDAO addstaffSvc = (ScheduleEventDAO) factory.getService("ScheduleEventService");
                    returnEvent = addstaffSvc.scheduleEvent(newevent);
					
		return returnEvent;	

	}//end scheduleEvent
        
        public List<EventBean> eventlist(String startDate, String endDate) throws Exception {
            
        List<EventBean> returnEvent;
                
        ServiceFactory factory = new ServiceFactory();
            
        try{
            ListEventDAO eventlistSvc = (ListEventDAO) factory.getService("ListEventService");
            returnEvent = eventlistSvc.eventlist(startDate, endDate);
					
            return returnEvent;
        }catch(SQLException e){
            e.printStackTrace();
        }
                
                return null;
        }//end eventlist
}//end EventManager
