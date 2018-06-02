/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RASS.model.domain;

/**
 *
 * @author carri
 */
public class StaffBean {
    
    //default constructor
	public StaffBean() {
		
	}

	private String firstname;
	
	//firstname setter
	public void setFirstname(String firstname){
		this.firstname = firstname;
	}
	
	//firstname getter
	public String getFirstname(){
		return firstname;
	}

	private String lastname;
	
	//lastname setter
	public void setLastname(String lastname){
		this.lastname = lastname;
	}
	
	//lastname getter
	public String getLastname (){
		return lastname;
	}

}
