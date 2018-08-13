/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RASS.model.business.managers;

import com.RASS.model.domain.StaffBean;
import com.RASS.model.domain.LoginBean;
import com.RASS.model.services.loginservice.LoginServiceDAO;
import com.RASS.model.services.servicefactory.ServiceFactory;



public class LoginManager {
	
        /** Default Constructor*/
	public LoginManager() {
	}
	
        /** Login authentication method that calls the LoginServiceDAO service
         * 
         * @param login
         * @return returnStaff
         * @throws java.lang.Exception
         */
	public StaffBean authenticate(LoginBean login) throws Exception {
		
		String user = login.getUsername();
		String pass = login.getPassword();
		
		StaffBean returnStaff;
                
                ServiceFactory factory = new ServiceFactory();
                
                LoginServiceDAO loginSvc = (LoginServiceDAO) factory.getService("LoginService");
                    returnStaff = loginSvc.authenticate(login);
					
                    return returnStaff;	
            
	}//end authenticate

}// end LoginManager
