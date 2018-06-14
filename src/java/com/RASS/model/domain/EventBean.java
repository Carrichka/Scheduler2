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
        
	
	public EventBean() {

		/** Default Constructor*/
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
	
}// End EventBean

