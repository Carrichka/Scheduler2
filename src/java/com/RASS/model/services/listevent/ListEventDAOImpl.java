/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RASS.model.services.listevent;

import com.RASS.model.domain.EventBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
public class ListEventDAOImpl implements ListEventDAO{
    
    /**
     * the logger
     */
    private static final Logger logger = Logger.getLogger(ListEventDAOImpl.class.getName());
    /**
     * data source from Glassfish
     */
    private DataSource ds;
    
    /**
     * Constructor.
     */
    public ListEventDAOImpl() {
        try {
            Context iniCtx = new InitialContext();
            Context envCtx = (Context) iniCtx.lookup("");
            ds = (DataSource) envCtx.lookup("jdbc/sample");
        } catch (NamingException ex) {
            logger.log(Level.SEVERE, "can't look up connection pool", ex);
            throw new RuntimeException(ex);
        }
    }//end ListEventDAOImpl
    
    @Override
    public List<EventBean> eventlist(String startDate, String endDate){
        
        List<EventBean> listEvent = new ArrayList<>();
        
        /*SQL select statement to pull a list of events from the DB
        */
        String sql = "SELECT f.field_name, s.first_name, s.last_name, fss.scheduled_date, gt.game_type_description FROM field_scorekeeper_schedule fss\n" +
            "JOIN scorekeeper s ON s.scorekeeper_id = fss.scorekeeper_id\n" +
            "JOIN field f ON f.field_id = fss.field_id\n" +
            "JOIN game_type gt ON gt.game_type_id = fss.game_type_id\n" +
            "WHERE fss.scheduled_date BETWEEN ? AND ?\n" +
            "ORDER BY fss.scheduled_date, f.field_name;";
        
               
        try (Connection conn = ds.getConnection()) {
            
            PreparedStatement ps = conn.prepareStatement(sql);
                ps.setDate(1, java.sql.Date.valueOf(startDate));
                ps.setDate(2, java.sql.Date.valueOf(endDate));
                
                ResultSet result = ps.executeQuery();
                int fieldID=0;
                int scorekeeperID=0;
                int gametypeID=0;
                
            while (result.next()) {
                String fieldName = result.getString("field_name");
                String Fname = result.getString("first_name");
                String Lname = result.getString("last_name");
                String scheduledDate = result.getString("scheduled_date");
                String gameType = result.getString("game_type_description");
                EventBean savedbean = new EventBean(fieldID, fieldName, scorekeeperID,Fname,Lname,scheduledDate,gametypeID, gameType);
                     
                listEvent.add(savedbean);
            }    
                conn.close();  
                
                return listEvent;

        } catch (SQLException ex) {
            logger.log(Level.WARNING, "can't query database", ex);

            return null;
        }//end of catch
    }//end eventlist
    
}//end ListEventDAOImpl
