/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RASS.model.services.removeevent;

import com.RASS.model.domain.EventBean;
import com.RASS.model.services.IService;
import javax.naming.NamingException;

/**
 * Defines the interface used by DAO implementation classes
 * 
 * @author Carri Martin
 */
public interface RemoveEventDAO extends IService{
    
        public final String NAME = "RemoveEventServiceDAO";
    
        public EventBean removeevent (EventBean event) throws NamingException;
}
