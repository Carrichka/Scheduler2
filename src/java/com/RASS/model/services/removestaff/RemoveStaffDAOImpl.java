/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RASS.model.services.removestaff;

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
public class RemoveStaffDAOImpl implements RemoveStaffDAO {
    
    /**
     * the logger
     */
    private static final Logger logger = Logger.getLogger(RemoveStaffDAOImpl.class.getName());
    /**
     * data source from Glassfish
     */
    private DataSource ds;
    
    /**
     * Constructor.
     */
    public RemoveStaffDAOImpl() {
        try {
            Context iniCtx = new InitialContext();
            Context envCtx = (Context) iniCtx.lookup("");
            ds = (DataSource) envCtx.lookup("jdbc/sample");
        } catch (NamingException ex) {
            logger.log(Level.SEVERE, "can't look up connection pool", ex);
            throw new RuntimeException(ex);
        }
    }//end RemoveStaffDAOImpl
    
    @Override
    public StaffBean removestaff(StaffBean newsb){
        
        int ScorekeeperId = newsb.getScorekeeperid();
        
        /*SQL update statement to change a scorekeeper's deleted status to yes
        */
        String sql = "UPDATE scorekeeper SET deleted = 'Y' where scorekeeper_id = ?";
        
        try (Connection conn = ds.getConnection()) {
            
            PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, ScorekeeperId);
                ps.execute();
                
                conn.close();  
                
                return newsb;
        }catch (SQLException ex) {
            logger.log(Level.WARNING, "can't query database", ex);
            return null;
        }//end of catch

    }//end removestaff
    
}//end RemoveStaffDAOImpl
