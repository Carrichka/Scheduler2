/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RASS.model.services.addstaffservice;

import com.RASS.model.domain.StaffBean;
import com.RASS.model.services.IService;
import javax.naming.NamingException;

/**
 *
 * @author Carri Martin
 */
public interface AddStaffDAO extends IService{
	
	public final String NAME = "AddStaffServiceDAO";
	
	public StaffBean addnewstaff (StaffBean newsb) throws NamingException ;
	
}// end LoginServiceDAO
