/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RASS.model.business.managers;

import com.RASS.model.domain.StaffBean;
import com.RASS.model.services.addstaffservice.AddStaffDAO;
import com.RASS.model.services.liststaff.ListStaffDAO;
import com.RASS.model.services.servicefactory.ServiceFactory;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Carri Martin
 */
public class StaffManager {
    
    public StaffManager() {
		
	}
	
    public StaffBean addnewstaff(StaffBean newsb) throws Exception {
		
        String user = newsb.getFirstname();
        String pass = newsb.getLastname();
		
	StaffBean returnStaff = new StaffBean();
                
        ServiceFactory factory = new ServiceFactory();
                
        AddStaffDAO addstaffSvc = (AddStaffDAO) factory.getService("AddStaffService");
            returnStaff = addstaffSvc.addnewstaff(newsb);
					
            return returnStaff;	
            
	}//end addnewstaff
        
    public List<StaffBean> createlist() throws Exception {
            
        List<StaffBean> returnStaff;
                
        ServiceFactory factory = new ServiceFactory();
            
        try{
            ListStaffDAO createlistSvc = (ListStaffDAO) factory.getService("ListStaffService");
            returnStaff = createlistSvc.createlist();
					
            return returnStaff;
        }catch(SQLException e){
            e.printStackTrace();
        }
                
                return null;
        }//end createlist
        
}//end StaffManager
