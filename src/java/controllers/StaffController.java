/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.RASS.model.business.managers.StaffManager;
import com.RASS.model.domain.StaffBean;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/StaffController")
public class StaffController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffController() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   
    	
        try {
                List<StaffBean> listStaff = (new StaffManager()).createlist();
                request.setAttribute("listStaff", listStaff);
 
                getServletContext().getRequestDispatcher ("/WEB-INF/jsp/staff.jsp").forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(StaffController.class.getName()).log(Level.SEVERE, null, ex);
            }//end try/catch
        
    }// end doGet

	/**
         * @param request
         * @param response
         * @throws javax.servlet.ServletException
         * @throws java.io.IOException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//moving form data into the StaffBean
		StaffBean newsb = new StaffBean();
		newsb.setFirstname(request.getParameter("first_name"));
		newsb.setLastname(request.getParameter("last_name"));
		
		StaffBean event;
                
                try{
                    event = (new StaffManager()).addnewstaff(newsb);

		//if the new DB entry was created this directs to the success page
		if (event != null) {
				
			//placing customer in the HttpSession object
			HttpSession session = request.getSession();
			session.setAttribute("event", event);

			getServletContext().getRequestDispatcher ("/WEB-INF/jsp/success.jsp").forward(request, response);
			
		}else {
			
			//generates a failure response
			getServletContext().getRequestDispatcher ("/WEB-INF/jsp/error.jsp").forward(request, response);
			
                    }//end if/else
                } catch (Exception e) {
                    e.printStackTrace();;
                }//end try catch
		
	}//end goPost
}
