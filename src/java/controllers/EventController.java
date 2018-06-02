/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.RASS.model.domain.EventBean;
import com.RASS.model.business.managers.EventManager;
import java.io.IOException;

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
    	getServletContext().getRequestDispatcher ("/WEB-INF/jsp/event.jsp").forward(request, response);
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//moving form data into the EventBean
		EventBean bean = new EventBean();
		bean.setStaffFirstName(request.getParameter("firstname"));
		bean.setStaffLastName(request.getParameter("lastname"));
                bean.setFieldNumber(request.getParameter("field_number"));
                bean.setScheduledDate(request.getParameter("scheduled_date"));
                bean.setDayofWeek(request.getParameter("week_day"));
		
                EventBean savedEvent = (new EventManager()).scheduleEvent(bean);
                
		HttpSession session = request.getSession();
		
                session.setAttribute("bean", savedEvent);
                getServletContext().getRequestDispatcher ("/WEB-INF/jsp/success.jsp").forward(request, response);
		
	}//end doPost
	
}//end EventController

