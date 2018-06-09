/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RASS.model.services.addstaffservice;

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
public class AddStaffDAOImpl implements AddStaffDAO{
    
    /**
     * the logger
     */
    private static final Logger logger = Logger.getLogger(AddStaffDAOImpl.class.getName());
    /**
     * data source from Glassfish
     */
    private DataSource ds;

    /**
     * Constructor.
     */
    public AddStaffDAOImpl() {
        try {
            Context iniCtx = new InitialContext();
            Context envCtx = (Context) iniCtx.lookup("");
            ds = (DataSource) envCtx.lookup("jdbc/sample");
        } catch (NamingException ex) {
            logger.log(Level.SEVERE, "can't look up connection pool", ex);
            throw new RuntimeException(ex);
        }
    }//end LoginServiceDAOImpl
    
    @Override
    public StaffBean addnewstaff(StaffBean newsb){
        
        String fname = newsb.getFirstname();
        String lname = newsb.getLastname();
        
        /*SQL insert statement to create a new scorekeeper entry
        */
        String sql = "INSERT INTO scorekeeper_scheduling.scorekeeper "
                + "(first_name, last_name, deleted) VALUES (?,?,?)";
        
        try (Connection conn = ds.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, fname);
                ps.setString(2, lname);
                ps.setString(3, "N");
                ps.execute();
                
                conn.close();  
                
                return newsb;

        } catch (SQLException ex) {
            logger.log(Level.WARNING, "can't query database", ex);
            return null;
        }//end of catch
    }//end addnewstaff
    
}//end AddStaffDAOImpl
