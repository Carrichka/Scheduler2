/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RASS.model.business.managers;

import com.RASS.model.domain.StaffBean;
import com.RASS.model.services.addstaffservice.AddStaffDAO;
import com.RASS.model.services.liststaff.ListStaffDAO;
import com.RASS.model.services.removestaff.RemoveStaffDAO;
import com.RASS.model.services.servicefactory.ServiceFactory;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Carri Martin
 */
public class StaffManager {
    
        /** Default Constructor*/
        public StaffManager() {
	}
	
        /** Add new staff method that calls the AddStaffDAO service
         *  Adds new staff members to the database
         * 
         * @param newsb
         * @return returnStaff
         * @throws java.lang.Exception
         */
        public StaffBean addnewstaff(StaffBean newsb) throws Exception {
		
                String user = newsb.getFirstname();
                String pass = newsb.getLastname();

                StaffBean returnStaff;

                ServiceFactory factory = new ServiceFactory();

                AddStaffDAO addstaffSvc = (AddStaffDAO) factory.getService("AddStaffService");
                    returnStaff = addstaffSvc.addnewstaff(newsb);

                    return returnStaff;	

        }//end addnewstaff
        
        /** Create staff list method that calls the ListStaffDAO service
         *  Creates a list of staff members 
         * 
         * @return returnEvent
         * @throws java.lang.Exception
         */
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
    
        /** Remove staff method that calls the RemoveStaffDAO service
         *  Soft deletes staff members in the database
         * 
         * @param staff
         * @return returnStaff
         * @throws java.lang.Exception
         */
        public StaffBean removestaff(StaffBean staff) throws Exception {
        
                StaffBean returnStaff;

                ServiceFactory factory = new ServiceFactory();

                RemoveStaffDAO removestaffSvc = (RemoveStaffDAO) factory.getService("RemoveStaffService");
                    returnStaff = removestaffSvc.removestaff(staff);

                return returnStaff;
        }//end removestaff
        
}//end StaffManager
