/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RASS.model.services.liststaff;

import com.RASS.model.domain.StaffBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carri Martin
 */
public class ListStaffDAOImpl implements ListStaffDAO{
    
    /**
     * the logger
     */
    private static final Logger logger = Logger.getLogger(ListStaffDAOImpl.class.getName());
    /**
     * data source from Glassfish
     */
    private DataSource ds;

    /**
     * Constructor.
     */
    public ListStaffDAOImpl() {
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
    public List<StaffBean> createlist(){
        
        List<StaffBean> listCategory = new ArrayList<>();
        
        /*SQL select statement to pull a list of scorekeepers from the DB
        */
        String sql = "SELECT * FROM scorekeeper";
        
        try (Connection conn = ds.getConnection()) {

            PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet result = ps.executeQuery();
                
            while (result.next()) {
                int id = result.getInt("scorekeeper_id");
                String Fname = result.getString("first_name");
                String Lname = result.getString("last_name");
                String del = result.getString("deleted");
                StaffBean savedbean = new StaffBean(id,Fname,Lname,del);
                     
                listCategory.add(savedbean);
            }    
                conn.close();  
                
                return listCategory;

        } catch (SQLException ex) {
            logger.log(Level.WARNING, "can't query database", ex);

            return null;
        }//end of catch
    }//end createlist
    
}
