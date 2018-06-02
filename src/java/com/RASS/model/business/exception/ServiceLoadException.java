/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RASS.model.business.exception;

@SuppressWarnings("serial")
public class ServiceLoadException extends Exception
{
    public ServiceLoadException(final String inMessage)
    {
        super(inMessage);
    }
	
} // end class ServiceLoadException
