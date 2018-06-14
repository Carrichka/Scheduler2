/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RASS.model.services.scheduleevent;

import com.RASS.model.domain.EventBean;
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
public class ScheduleEventDAOImpl implements ScheduleEventDAO{
    
    /**
     * the logger
     */
    private static final Logger logger = Logger.getLogger(ScheduleEventDAOImpl.class.getName());
    /**
     * data source from Glassfish
     */
    private DataSource ds;
    
    /**
     * Constructor.
     */
    public ScheduleEventDAOImpl() {
        try {
            Context iniCtx = new InitialContext();
            Context envCtx = (Context) iniCtx.lookup("");
            ds = (DataSource) envCtx.lookup("jdbc/sample");
        } catch (NamingException ex) {
            logger.log(Level.SEVERE, "can't look up connection pool", ex);
            throw new RuntimeException(ex);
        }
    }//end ScheduleEventDAOImpl
    
    @Override
    public EventBean scheduleEvent(EventBean newevent)throws NamingException {
        
        int scorekeeperID = newevent.getScorekeeperId();
        String scheduledDate = newevent.getScheduledDate();
        
        String fieldname = newevent.getFieldName();
            int fieldID = 0;
            switch (fieldname){
                case "1":
                    fieldID = 1;
                    break;
                case "2":
                    fieldID = 2;
                    break;
                case "3":
                    fieldID = 3;
                    break;
                default:
                    break;
            }//end switch to set field ID
        String gametype = newevent.getGametype();
            int gameID=0;
            switch (gametype){
                case "Mens":
                    gameID = 1;
                    break;
                case "Mens Advanced":
                    gameID = 2;
                    break;
                case "Coed":
                    gameID = 3;
                    break;
                case "Coed Advanced":
                    gameID = 4;
                    break;
                default:
                    break;
            }//end switch to set field ID
            
        /*SQL insert statement to create a new event entry
        */
        String sql = "INSERT INTO field_scorekeeper_schedule "
                + "(field_id, scorekeeper_id, scheduled_date, game_type_id) VALUES (?,?,?,?)";
        
        try (Connection conn = ds.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, fieldID);
                ps.setInt(2, scorekeeperID);
                ps.setDate(3, java.sql.Date.valueOf(scheduledDate));
                ps.setInt(4, gameID);
                ps.execute();
                
                conn.close();  
                
                return newevent;

        } catch (SQLException ex) {
            logger.log(Level.WARNING, "can't query database", ex);
            return null;
        }//end of catch
        
    }//end scheduleEvent
}//end ScheduleEventDAOImpl
