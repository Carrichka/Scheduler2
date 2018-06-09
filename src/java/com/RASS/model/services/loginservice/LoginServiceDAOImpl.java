/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RASS.model.services.loginservice;

import com.RASS.model.domain.StaffBean;
import com.RASS.model.domain.LoginBean;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class LoginServiceDAOImpl implements LoginServiceDAO {

    /**
     * the logger
     */
    private static final Logger logger = Logger.getLogger(LoginServiceDAOImpl.class.getName());
    /**
     * data source from Glassfish
     */
    private DataSource ds;

    /**
     * Constructor.
     */
    public LoginServiceDAOImpl() {
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
    public StaffBean authenticate(LoginBean login) {

        String user = login.getUsername();
        String pass = login.getPassword();
        
        /*this sql statement will ensure that only DB entries that match what was entered
        *at login will pass authentication
        */
        String sql = "SELECT * FROM scorekeeper_scheduling.scorekeeper_user "
                + "WHERE email_address=? AND password=?";
        try (Connection conn = ds.getConnection()) {

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, user);
                ps.setString(2, pass);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    StaffBean sb = new StaffBean();
                    /*
                    * This section is not needed because the database does not
                    *connect names with the username/password
                    *I'm leaving this in case that changes.
                     */
                    sb.setFirstname("firstname");
                    sb.setLastname("lastname");
                    return sb;
                } else {
                    return null;
                }//end of if/else
            }//end of try for the prepared statement

        } catch (SQLException ex) {
            logger.log(Level.WARNING, "can't query database", ex);
            return null;
        }//end of catch

    }// end authenticate

}// end LoginServiceDAOImpl

