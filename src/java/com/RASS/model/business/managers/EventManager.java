/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RASS.model.business.managers;

import com.RASS.model.domain.EventBean;
import com.RASS.model.services.listevent.ListEventDAO;
import com.RASS.model.services.removeevent.RemoveEventDAO;
import com.RASS.model.services.servicefactory.ServiceFactory;
import com.RASS.model.services.scheduleevent.ScheduleEventDAO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Carri Martin
 */
public class EventManager {
	
        /** Default Constructor*/
	public EventManager() {	
	}
	
        /** Schedule event method that calls the ScheduleEventDAO service
         *  Adds new events to the database
         * 
         * @param newevent
         * @return returnEvent
         * @throws java.lang.Exception
         */
	public EventBean scheduleEvent(EventBean newevent) throws Exception {
		
                //instantiates a new EventBean
		EventBean returnEvent;
 
                //instantiates a new ServiceFactory
		ServiceFactory factory = new ServiceFactory();
                
                //calls the ScheduleEventDAO service
                ScheduleEventDAO newEvent = (ScheduleEventDAO) factory.getService("ScheduleEventService");
                    returnEvent = newEvent.scheduleEvent(newevent);
					
		return returnEvent;	

	}//end scheduleEvent
        
        /** Event list method that calls the ListEventDAO service
         *  Creates a list of events from the database for use on the home page in a dynamic table
         * 
         * @param startDate
         * @param endDate
         * @return returnEvent
         * @throws java.lang.Exception
         */
        public List<EventBean> eventlist(String startDate, String endDate) throws Exception {
            
                //instantiates a new list of EventBeans
                List<EventBean> returnEvent;
                
                //instantiates a new ServiceFactory
                ServiceFactory factory = new ServiceFactory();
            
                //calls the ListEventDAO service within a try/catch to handle the SQL exception
                try{
                    ListEventDAO eventlistSvc = (ListEventDAO) factory.getService("ListEventService");
                    returnEvent = eventlistSvc.eventlist(startDate, endDate);

                    return returnEvent;
                    
                }catch(SQLException e){
                    e.printStackTrace();
                }

                    return null;
                }//end eventlist
        
        /** Remove event method that calls the RemoveEventDAO service
         *  Deletes an event from the database
         * 
         * @param event
         * @return returnEvent
         * @throws java.lang.Exception
         */
        public EventBean deleteevent(EventBean event) throws Exception {
        
                EventBean returnEvent;

                ServiceFactory factory = new ServiceFactory();

                RemoveEventDAO deleteeventSvc = (RemoveEventDAO) factory.getService("RemoveEventService");
                    returnEvent = deleteeventSvc.removeevent(event);

                return returnEvent;
        }//end deleteevent
        
}//end EventManager
