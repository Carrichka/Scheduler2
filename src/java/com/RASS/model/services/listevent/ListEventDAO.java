/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RASS.model.services.listevent;

import com.RASS.model.domain.EventBean;
import com.RASS.model.services.IService;
import java.util.List;
import javax.naming.NamingException;

/**
 * Defines the interface used by DAO implementation classes
 * 
 * @author Carri Martin
 */
public interface ListEventDAO extends IService{
    
        public final String NAME = "ListEventService";
	
	public List<EventBean>  eventlist (String startDate, String endDate)throws NamingException;
}
