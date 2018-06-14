/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.RASS.model.domain.EventBean;
import com.RASS.model.business.managers.EventManager;
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
 * Servlet implementation class EventController
 */
@WebServlet("/EventController")
public class EventController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   
            try {
                List<StaffBean> listStaff = (new StaffManager()).createlist();
                request.setAttribute("listStaff", listStaff);
 
                getServletContext().getRequestDispatcher ("/WEB-INF/jsp/event.jsp").forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
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

		//moving form data into an EventBean
		EventBean newevent = new EventBean();
                    newevent.setFieldName(request.getParameter("fieldName"));
                    //parsing string from request into an int
                    int staffId = Integer.parseInt(request.getParameter("listStaff"));
                        newevent.setScorekeeperId((staffId));
                    newevent.setScheduledDate(request.getParameter("scheduledDate"));
                    newevent.setGametype(request.getParameter("gameType"));
		
                EventBean savedEvent;
                
                try{
                  savedEvent= (new EventManager()).scheduleEvent(newevent); 
                  
                  if (savedEvent != null) {
                      HttpSession session = request.getSession();
                      session.setAttribute("bean", savedEvent);
                      getServletContext().getRequestDispatcher ("/WEB-INF/jsp/success.jsp").forward(request, response);
		
                  }else {
                      //generates a failure response
                      getServletContext().getRequestDispatcher ("/WEB-INF/jsp/error.jsp").forward(request, response);
                  }//end if/else
                } catch (Exception e) {
                    e.printStackTrace();;
                }//end try catch
        }//end doPost
	
}//end EventController

