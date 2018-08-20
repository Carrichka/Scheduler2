/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RASS.model.services.loginservice;

import com.RASS.model.business.exception.ServiceLoadException;
import com.RASS.model.domain.LoginBean;
import com.RASS.model.services.servicefactory.ServiceFactory;
import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.security.auth.login.LoginException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 *
 * @author carri
 */
public class LoginServiceDAOImplTest {
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			//set the system properties to get things ready
			System.setProperty(Context.URL_PKG_PREFIXES, "org.apache.naming"); 
			System.setProperty(Context.INITIAL_CONTEXT_FACTORY,
					"org.apache.naming.java.javaURLContextFactory"); 

			InitialContext context = new InitialContext(); 

			//build the subcontext needed for the JNDI lookup.
			context.createSubcontext("java:"); 
			context.createSubcontext("java:/comp"); 
			context.createSubcontext("java:/comp/env").bind("LoginServiceDAO",
					"com.RASS.model.services.loginservice.LoginServiceDAOImpl"); 
			context.createSubcontext("java:/comp/env/jdbc"); 

			//setup the datasource and properties
			MysqlConnectionPoolDataSource ds = new MysqlConnectionPoolDataSource(); 
			ds.setURL("jdbc:mysql://localhost:3306/scorekeeper_scheduling");
			ds.setUser("root");
			ds.setPassword("cStfixSvXXQsk0FyEuMK"); 

			//bind the context  
			context.bind("java:/comp/env/jdbc:mysql://localhost:3306/scorekeeper_scheduling", ds); 

		} catch (NamingException e) {
			e.printStackTrace();
		} //end try/catch
	}// end setUpBeforeClass

	@Test
	public void testAuthenticate() throws Exception{

		LoginBean bean = new LoginBean();
			bean.setUsername("cmartin");
			bean.setPassword("password");
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		
		try{
			LoginServiceDAO loginService = (LoginServiceDAO)serviceFactory.getService("LoginService");
			
			Assert.assertNotNull(loginService.authenticate(bean));
			
		}catch (ServiceLoadException e){
			Assert.fail(e.getMessage());
			System.out.println("LoginServiceDAOImplTest/testAuthenticate: threw ServiceLoadException");
		}catch (LoginException e){
			System.out.println("LoginServiceDAOImplTest: threw LoginException");
		}//end try/catch
		
	}// end testAuthenticate

}// end LoginServiceDAOImplTest
