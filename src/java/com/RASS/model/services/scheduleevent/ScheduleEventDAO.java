/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RASS.model.services.scheduleevent;

import com.RASS.model.domain.EventBean;
import com.RASS.model.services.IService;
import javax.naming.NamingException;

/**
 *
 * @author Carri Martin
 */
public interface ScheduleEventDAO extends IService{
    
    public final String NAME = "ScheduleEventService";
    
    public EventBean scheduleEvent (EventBean newevent) throws NamingException ;
    
}
