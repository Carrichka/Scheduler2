/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RASS.model.domain;

/**
 *
 * @author Carri Martin
 */
public class StaffBean {
    
        /** Default Constructor*/
	public StaffBean() {	
	}
        
        /** Constructor for dynamic list creation
        * @param scorekeeper_id
        * @param firstname
        * @param lastname
        * @param deleted
        */
	public StaffBean(int scorekeeper_id,String firstname,String lastname,String deleted) {
		this.scorekeeper_id = scorekeeper_id;
                this.firstname = firstname;
                this.lastname = lastname;
                this.deleted = deleted;
	}
        
        /** scorekeeper id */
        private int scorekeeper_id;
	
	/**
	 * 
	 * @param scorekeeper_id
	 */
	public void setScorekeeperid(int scorekeeper_id){
		this.scorekeeper_id = scorekeeper_id;
	}
	
	/**
	 * 
	 * @return the scorekeeper_id
	 */
	public int getScorekeeperid(){
		return scorekeeper_id;
	}
        
        /** firstname */
	private String firstname;
	
	/**
	 * 
	 * @param firstname
	 */
	public void setFirstname(String firstname){
		this.firstname = firstname;
	}
	
	/**
	 * 
	 * @return firstname
	 */
	public String getFirstname(){
		return firstname;
	}

        /** lastname */
	private String lastname;
	
	/**
	 * 
	 * @param lastname
	 */
	public void setLastname(String lastname){
		this.lastname = lastname;
	}
	
	/**
	 * 
	 * @return the lastname
	 */
	public String getLastname (){
		return lastname;
	}
 
        /** deleted */
	private String deleted;
	
	/**
	 * 
	 * @param deleted
	 */
	public void setDeleted(String deleted){
		this.deleted = deleted;
	}
	
	/**
	 * 
	 * @return the deleted
	 */
	public String getDeleted (){
		return deleted;
	}        

}// end StaffBean
