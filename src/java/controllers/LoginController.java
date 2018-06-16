/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.RASS.model.business.managers.EventManager;
import com.RASS.model.domain.StaffBean;
import com.RASS.model.domain.LoginBean;
import com.RASS.model.domain.EventBean;
import com.RASS.model.business.managers.LoginManager;
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
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   
    	getServletContext().getRequestDispatcher ("/WEB-INF/jsp/home.jsp").forward(request, response);
    }

	/**
        * @param request
        * @param response
        * @throws javax.servlet.ServletException
        * @throws java.io.IOException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//moving form data into the LoginBean
		LoginBean login = new LoginBean();
		login.setUsername(request.getParameter("username"));
		login.setPassword(request.getParameter("password"));
		
		StaffBean event;
                
                try{
                    event = (new LoginManager()).authenticate(login);

		//authenticate the user
		if (event != null) {
			
                    try {
                        List<EventBean> listEvent = (new EventManager()).eventlist();
                        
                        //placing event list in the HttpSession object
                        HttpSession session = request.getSession();
                        session.setAttribute("listEvent", listEvent);
 
                        getServletContext().getRequestDispatcher ("/WEB-INF/jsp/home.jsp").forward(request, response);
                    } catch (Exception ex) {
                        Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
                    }//end try/catch

		}else {
			
			//generates a failure response
			getServletContext().getRequestDispatcher ("/WEB-INF/jsp/error.jsp").forward(request, response);
			
                    }//end if/else
                } catch (Exception e) {
                    e.printStackTrace();;
                }//end try catch
		
	}//end goPost

}//end LoginController