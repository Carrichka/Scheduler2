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
                request.setAttribute("listCategory", listStaff);
 
                getServletContext().getRequestDispatcher ("/WEB-INF/jsp/event.jsp").forward(request, response);
            } catch (Exception ex) {
                Logger.getLogger(EventController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
        @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//moving form data into the EventBean
		EventBean bean = new EventBean();
//                    int FieldId = Integer.parseInt(request.getParameter("field_id"));
//		bean.setFieldId(request.getParameter(FieldId));
//		bean.setScorekeeperId(request.getParameter("scorekeeper_id"));
//               bean.setScheduledDate(request.getParameter("scheduledDate"));
//               bean.setGametypeId(request.getParameter("gametype_id"));
		
                EventBean savedEvent = (new EventManager()).scheduleEvent(bean);
                
		HttpSession session = request.getSession();
		
                session.setAttribute("bean", savedEvent);
                getServletContext().getRequestDispatcher ("/WEB-INF/jsp/success.jsp").forward(request, response);
		
	}//end doPost
	
}//end EventController

