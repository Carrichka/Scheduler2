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
        * @param scorekeeperId
        * @param firstname
        * @param lastname
        * @param deleted
        */
	public StaffBean(int scorekeeperId,String firstname,String lastname,String deleted) {
		this.scorekeeperId = scorekeeperId;
                this.firstname = firstname;
                this.lastname = lastname;
                this.deleted = deleted;
	}
        
        /** scorekeeper id */
        private int scorekeeperId;
	
	/**
	 * 
	 * @param scorekeeper_id
	 */
	public void setScorekeeperid(int scorekeeper_id){
		this.scorekeeperId = scorekeeper_id;
	}
	
	/**
	 * 
	 * @return the scorekeeper_id
	 */
	public int getScorekeeperid(){
		return scorekeeperId;
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
        
        public boolean validate() {
            if (firstname == null || "".equals(firstname))
		return false;
            if (lastname == null || "".equals(lastname))
		return false;
            if (deleted == null || "".equals(deleted))
		return false;
            if (scorekeeperId <= 0)
                return false;
            return true;
	}// end validate
        
        @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result
				+ ((lastname == null) ? 0 : lastname.hashCode());
                result = prime * result
				+ ((deleted == null) ? 0 : deleted.hashCode());
		return result;
	}
        
        @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StaffBean  other = (StaffBean ) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
                if (deleted == null) {
			if (other.deleted != null)
				return false;
		} else if (!deleted.equals(other.deleted))
			return false;
		/** This one is different from the tests above because iSBNumber is an int **/
		if (scorekeeperId != other.scorekeeperId)
			return false;
		return true;
	}// end equals
        
        @Override
	public String toString() {
		return "StaffBean [scorekeeperId=" + scorekeeperId 
                                + ", firstname=" + firstname + ", "
                                + ", lastname=" + lastname + ", "
                                + ", deleted=" + deleted + "]";
	}

}// end StaffBean
