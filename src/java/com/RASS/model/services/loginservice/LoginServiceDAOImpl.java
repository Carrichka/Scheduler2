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
            Context envCtx = (Context) iniCtx.lookup("java:comp/env");
            ds = (DataSource) envCtx.lookup("jdbc/scorekeeper_scheduling");
        } catch (NamingException ex) {
            logger.log(Level.SEVERE, "can't look up connection pool", ex);
            throw new RuntimeException(ex);
        }
    }

    @Override
    public StaffBean authenticate(LoginBean login) {

        String user = login.getUsername();
        String pass = login.getPassword();

        String sql = "SELECT * FROM scorekeeper_scheduling.scorekeeper_user "
                + "WHERE email_address=? AND password=?";
        try (Connection conn = ds.getConnection()) {
//            DatabaseMetaData md = conn.getMetaData();
//            ResultSet rst = md.getTables(null, null, "%", null);
//            while (rst.next()) {
//                String s = rst.getString(3);
//                logger.info(s);
//            }
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, user);
                ps.setString(2, pass);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    StaffBean sb = new StaffBean();
                    /*
                 * FIXME: look up first and last names from database
                     */
                    sb.setFirstname("first name");
                    sb.setLastname("last name");
                    return sb;
                } else {
                    return null;
                }
            }

        } catch (SQLException ex) {
            logger.log(Level.WARNING, "can't query database", ex);
            return null;
        }

//		try {
//			Context iniCtx = new InitialContext();
//			Context envCtx = (Context) iniCtx.lookup("java:/comp/env");
//			DataSource ds = (DataSource)envCtx.lookup("jdbc/scorekeeper_scheduling");
//			
//			Connection conn = ds.getConnection();						
//			
//	if (conn != null) {
//	
//            stmt = conn.createStatement();
//                
//                //SQL query that returns user information from the database				
//                rset = stmt.executeQuery("select * " 
//                        + "from scorekeeper_user " );				
//                
////                if (rset.isBeforeFirst()){
////                	
////					}
//                while (rset.next()) {
//                	
//                	LoginBean savedLogin = new LoginBean();
//                	
//                	String usern = rset.getString("username");
//                	String passw = rset.getString("password");
//                	
//                	savedLogin.setUsername(usern);
//                	savedLogin.setPassword(passw);
//                	
//                	if (usern != null) {
//                		if (savedLogin.getUsername().equals(login.getUsername()) && savedLogin.getPassword().equals(login.getPassword())){
//                			StaffBean returnLogin = new StaffBean();
//        					returnLogin.setFirstname("Jane");
//        					returnLogin.setLastname("pass");
//        					
//                                                return returnLogin;
//        					
//                		} // end if statement checking saved login with input login
//                	}// end if statement checking a value was returned for username from the database
//                }// end while statement retrieving data from the database
//                 
//				} //end if conn !=null
//			}
//			catch (SQLException e){
//                            e.printStackTrace();
//                        }// end catch
//			
//		 finally
//		 {
//            try
//            {
//	            // check for null first before closing resources
//	            if (stmt != null) 
//	            	{
//	                stmt.close();
//	            	}
//	            if (conn != null) 
//	            	{
//	                conn.close();
//	            	}
//            }
//        catch (SQLException e)
//                {
//                System.out.println("SQL Exception thrown");
//                }
//            
//        }//end finally 
//		
//		return null; 
//
    }// end authenticate

}// end LoginServiceDAOImpl

