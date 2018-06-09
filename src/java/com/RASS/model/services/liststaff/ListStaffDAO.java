/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RASS.model.services.liststaff;

import com.RASS.model.domain.StaffBean;
import com.RASS.model.services.IService;
import java.util.List;
import javax.naming.NamingException;

/**
 * Defines the interface used by DAO implementation classes
 * 
 * @author Carri Martin
 */
public interface ListStaffDAO  extends IService{
    	
	public final String NAME = "ListStaffServiceDAO";
	
	public List<StaffBean>  createlist ()throws NamingException;
}
