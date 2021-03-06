/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RASS.model.domain;

import java.io.Serializable;

/**
 * 
 * @author Carri Martin
 *
 */

public class EventBean implements Serializable {

	/**
	 * Autogenerated serialVersionUID from eclipse
	 */
	private static final long serialVersionUID = 1L;

	/** field id */
        private int fieldID;
        
        /** field name */
        private String fieldName;
	
	/** scorekeeper id */
        private int scorekeeperID;
        
        /** scorekeeper first name */
        private String scorekeeperFirstName;
        
        /** scorekeeper last name */
        private String scorekeeperLastName;
        
        /** Scheduled Date */
	private String scheduledDate;
        
        /** game type id */
	private int gametypeID;
        
        /** game type */
	private String gameType;
        
	/** Default Constructor*/
	public EventBean() {
        }
	
        /** Constructor for dynamic list creation
        * @param fieldID
        * @param fieldName
        * @param scorekeeperID
        * @param scorekeeperFirstName
        * @param scorekeeperLastName
        * @param scheduledDate
        * @param gametypeID
        * @param gameType
        */
        public EventBean(int fieldID, String fieldName, int scorekeeperID,String scorekeeperFirstName,
                String scorekeeperLastName, String scheduledDate,int gametypeID,String gameType) 
        {
            this.fieldID=fieldID;
            this.fieldName=fieldName;
            this.scorekeeperID=scorekeeperID;
            this.scorekeeperFirstName=scorekeeperFirstName;
            this.scorekeeperLastName=scorekeeperLastName;
            this.scheduledDate=scheduledDate;
            this.gametypeID=gametypeID;
            this.gameType=gameType;
	}
        
	/**
	 * 
	 * @return the fieldID
	 */
	public int getFieldId() {
		return fieldID;
	}
	
	/**
	 * 
	 * @param fieldID(
	 */
	public void setFieldId(int fieldID) {
		this.fieldID = fieldID;
	}
	
        /**
	 * 
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}
	
	/**
	 * 
	 * @param fieldName(
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
        /**
	 * 
	 * @return the scorekeeperID
	 */
	public int getScorekeeperId() {
		return scorekeeperID;
	}
	
	/**
	 * 
	 * @param scorekeeperID
	 */
	public void setScorekeeperId(int scorekeeperID) {
		this.scorekeeperID = scorekeeperID;
	}
        
        /**
	 * 
	 * @return the scorekeeperFirstName
	 */
	public String getScorekeeperFirstName() {
		return scorekeeperFirstName;
	}
	
	/**
	 * 
	 * @param scorekeeperFirstName
	 */
	public void setScorekeeperFirstName(String scorekeeperFirstName) {
		this.scorekeeperFirstName = scorekeeperFirstName;
	}
        
        /**
	 * 
	 * @return the scorekeeperLastName
	 */
	public String getScorekeeperLastName() {
		return scorekeeperLastName;
	}
	
	/**
	 * 
	 * @param scorekeeperLastName
	 */
	public void setScorekeeperLastName(String scorekeeperLastName) {
		this.scorekeeperLastName = scorekeeperLastName;
	}
        
	/**
	 * 
	 * @return the scheduledDate
	 */
	public String getScheduledDate() {
		return scheduledDate;
	}
	
	/**
	 * 
	 * @param scheduledDate
	 */
	public void setScheduledDate(String scheduledDate) {
		this.scheduledDate = scheduledDate;
	}
        
       	/**
	 * 
	 * @return the gametypeID
	 */
	public int getGametypeId() {
		return gametypeID;
	}
	
	/**
	 * 
	 * @param gametypeID(
	 */
	public void setGametypeId(int gametypeID) {
		this.gametypeID = gametypeID;
	}
        
        /**
	 * 
	 * @return the gameType
	 */
	public String getGametype() {
		return gameType;
	}
	
	/**
	 * 
	 * @param gameType(
	 */
	public void setGametype(String gameType) {
		this.gameType = gameType;
	}
        
        public boolean validate() {
		if (fieldName == null || "".equals(fieldName))
			return false;
		if (scorekeeperFirstName == null || "".equals(scorekeeperFirstName))
			return false;
		if (scorekeeperLastName == null || "".equals(scorekeeperLastName))
			return false;
                if (scheduledDate == null || "".equals(scheduledDate))
			return false;
                if (gameType == null || "".equals(gameType))
			return false;
		if (fieldID <= 0)
			return false;
                if (scorekeeperID <= 0)
			return false;
                if (gametypeID <= 0)
			return false;
		
		return true;
	}// end validate
        
        @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fieldName == null) ? 0 : fieldName.hashCode());
		result = prime * result
				+ ((scorekeeperFirstName == null) ? 0 : scorekeeperFirstName.hashCode());
		result = prime * result
				+ ((scorekeeperLastName == null) ? 0 : scorekeeperLastName.hashCode());
		result = prime * result
				+ ((scheduledDate == null) ? 0 : scheduledDate.hashCode());
                result = prime * result
				+ ((gameType == null) ? 0 : gameType.hashCode());
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
		EventBean  other = (EventBean ) obj;
		if (fieldName == null) {
			if (other.fieldName != null)
				return false;
		} else if (!fieldName.equals(other.fieldName))
			return false;
		if (scorekeeperFirstName == null) {
			if (other.scorekeeperFirstName != null)
				return false;
		} else if (!scorekeeperFirstName.equals(other.scorekeeperFirstName))
			return false;
		if (scorekeeperLastName == null) {
			if (other.scorekeeperLastName != null)
				return false;
		} else if (!scorekeeperLastName.equals(other.scorekeeperLastName))
                if (scheduledDate == null) {
			if (other.scheduledDate != null)
				return false;
		} else if (!scheduledDate.equals(other.scheduledDate))
			return false;
		if (gameType == null) {
			if (other.gameType != null)
				return false;
		} else if (!gameType.equals(other.gameType))
			return false;
		/** These are different from the tests above because they are int **/
		if (fieldID != other.fieldID)
                if (scorekeeperID != other.scorekeeperID)
                if (gametypeID != other.gametypeID)
			return false;
		return true;
	}// end equals
        
        @Override
	public String toString() {
		return "EventBean [fieldID=" + fieldID 
                                + ", fieldName=" + fieldName
				+ ", scorekeeperID=" + scorekeeperID 
                                + ", scorekeeperFirstName=" + scorekeeperFirstName
                                + ", scorekeeperLastName=" + scorekeeperLastName
                                + ", scheduledDate=" + scheduledDate
                                + ", gametypeID=" + gametypeID
				+ ", gameType=" + gameType + "]";
	}
	
}// end EventBean

