package com.employee.delete.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.employee.delete.service.DeleteUserService;
import com.employee.delete.service.IDeleteUserService;
import com.employee.login.dao.LoginUserDAO;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.simple.JSONObject;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
*@author Aayush gehi
*Servlet class used to interact with the dao layer to work with database
*and delete the user 
*/
public class DeleteUserServlet extends HttpServlet {



	

	/**
	 *
	 */
	private static final long serialVersionUID = 4125153322255287068L;
	/**
	 *
	 */

/**
 * Get method to interact with front end and return the response in JSON format 
 * whether the user is deleted or not 
 */
	@Override
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws IOException 
	{
		PropertyConfigurator.configure("log4j.properties");
		final Logger logger = Logger.getLogger(DeleteUserServlet.class);
		response.setContentType("text/html");
		String username = request.getParameter("username").toLowerCase(); 
		boolean isDeleted;
		IDeleteUserService user = new DeleteUserService();
		isDeleted=user.isDeleted(username);
		JSONObject obj = new JSONObject();
		PrintWriter pw = response.getWriter();
		if(isDeleted) 
		{
			obj.put("Status", "200");
			pw.print(obj.toString());
		}
		else 
		{
			logger.error("User cannot be deleted due to user not present");
			obj.put("Status", "404");
			pw.print(obj.toString());
		}
	}
}
