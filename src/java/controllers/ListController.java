/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.RASS.model.business.managers.EventManager;
import com.RASS.model.domain.EventBean;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
 *
 * @author Carri Martin
 */
@WebServlet("/ListController")
public class ListController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   
        
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd");
            String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
            
            try {
                calendar.setTime(dateFormat.parse(currentDate));
            } catch (ParseException ex) {
                        Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
            /*Setting a start date a week after the current date*/
            calendar.add(Calendar.DATE,7);
            String startDate = dateFormat.format(calendar.getTime().getTime());
                    
            /*Setting an end date a week after the start date*/
            calendar.add(Calendar.DATE,7);
            String endDate = dateFormat.format(calendar.getTime().getTime());    
            
            try {
            List<EventBean> listEvent = (new EventManager()).eventlist(startDate, endDate);
                        
            //placing event list in the HttpSession object
            HttpSession session = request.getSession();
            session.setAttribute("listEvent", listEvent);
 
            getServletContext().getRequestDispatcher ("/WEB-INF/jsp/home.jsp").forward(request, response);    
            } catch (Exception ex) {
                Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, ex);
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

                /*Setting the current date to use as the date range end date*/
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd");
                String endDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
                    
                try {
                    calendar.setTime(dateFormat.parse(endDate));
                } catch (ParseException ex) {
                    Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                /*Setting a start date a week after the current date*/
                calendar.add(Calendar.DATE,-7);
                String startDate = dateFormat.format(calendar.getTime().getTime());
                    
                try {
                    List<EventBean> listEvent = (new EventManager()).eventlist(startDate, endDate);
                        
                    //placing event list in the HttpSession object
                    HttpSession session = request.getSession();
                    session.setAttribute("listEvent", listEvent);
 
                    getServletContext().getRequestDispatcher ("/WEB-INF/jsp/home.jsp").forward(request, response);
                } catch (Exception ex) {
                    Logger.getLogger(ListController.class.getName()).log(Level.SEVERE, null, ex);
                }//end try/catch
		
	}//end doPost
    
}//end ListController
