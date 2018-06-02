/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RASS.model.services.servicefactory;

import com.RASS.model.business.exception.ServiceLoadException;
import com.RASS.model.services.IService;
import javax.naming.Context;
import javax.naming.InitialContext;

public class ServiceFactory {
	
	public ServiceFactory() {
	}
	
	private static ServiceFactory serviceFactoryInstance;
	public static ServiceFactory getInstance() 
	{
		if (serviceFactoryInstance == null)
			serviceFactoryInstance = new ServiceFactory();		
		return serviceFactoryInstance;
	}//end ServiceFactory getInstance()

	/**
	 * 
	 * @param serviceName
	 * @return
	 * @throws Exception 
	 */
	public IService getService(String serviceName) throws Exception {
		try {
			Class c = Class.forName(getImplName(serviceName));
			return (IService) c.newInstance();
			} catch (ClassNotFoundException excp) {
				throw new ServiceLoadException(serviceName + " not found");
			} catch (InstantiationException excp) {
				throw new ServiceLoadException(serviceName + " not instantiated");
			} catch (IllegalAccessException excp) {
				throw new ServiceLoadException(serviceName + " illegal access");
			}// end try/catch block
		
		}//end IService getService

	/**
	 * 
	 * @param serviceName
	 * @return
	 * @throws ServiceLoadException
	 */
	private String getImplName (String serviceName) throws Exception
	{
		Context iniCtx = new InitialContext();
		Context envCtx = (Context) iniCtx.lookup("java:comp/env");
		return (String)envCtx.lookup(serviceName);
		
	}// end getImpleName
	
}// end ServiceFactory

