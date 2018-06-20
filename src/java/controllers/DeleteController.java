/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.RASS.model.business.managers.StaffManager;
import com.RASS.model.domain.StaffBean;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Carri Martin
 */
@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }//end doGet
    
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
            //parsing string from request into an int
            int staffId = Integer.parseInt(request.getParameter("listStaff"));
            newsb.setScorekeeperid((staffId));
            
            StaffBean event;
                
            try{
                event = (new StaffManager()).removestaff(newsb);

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

            
        }//end doPost
    
}//end DeleteController
