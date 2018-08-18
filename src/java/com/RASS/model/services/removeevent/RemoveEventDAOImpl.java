/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RASS.model.services.removeevent;

import com.RASS.model.domain.EventBean;
import com.RASS.model.domain.StaffBean;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Carri Martin
 */
public class RemoveEventDAOImpl  implements RemoveEventDAO {
    
    /**
     * the logger
     */
    private static final Logger logger = Logger.getLogger(RemoveEventDAOImpl.class.getName());
    
    /**
     * data source from Glassfish
     */
    private DataSource ds;
    
    /**
     * Database Connection Constructor
     */
    public RemoveEventDAOImpl() {
        try {
            Context iniCtx = new InitialContext();
            Context envCtx = (Context) iniCtx.lookup("");
            ds = (DataSource) envCtx.lookup("jdbc/sample");
        } catch (NamingException ex) {
            logger.log(Level.SEVERE, "can't look up connection pool", ex);
            throw new RuntimeException(ex);
        }
    }//end RemoveEventDAOImpl
    
    @Override
    public EventBean removeevent(EventBean event){
        
        int fieldId = event.getFieldId();
        int scorekeeperId = event.getScorekeeperId();
        String scheduledDate = event.getScheduledDate();
        int gameTypeId = event.getGametypeId();
        //return event;
        /*SQL prepared statement to delete an event entry
        */
        String sql = "DELETE FROM field_scorekeeper_schedule WHERE field_id = ? AND scorekeeper_id = ? AND scheduled_date = ? AND game_type_id = ?";
        
        // try/catch to create a DB connection and execute the SQL prepared statement
        try (Connection conn = ds.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, fieldId);
                ps.setInt(2, scorekeeperId);
                ps.setDate(3, java.sql.Date.valueOf(scheduledDate));
                ps.setInt(4, gameTypeId);
                ps.execute();
                
                conn.close();  
                
                return event;

        } catch (SQLException ex) {
            logger.log(Level.WARNING, "can't query database", ex);
            return null;
        }//end of catch
        
    }//end removeevent
    
}//end RemoveEventDAOImpl
