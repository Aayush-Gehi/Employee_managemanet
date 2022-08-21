package com.employee.register.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.employee.register.service.IRegisterUserService;
import com.employee.register.service.RegisterUserService;

import org.json.simple.JSONObject;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
*@author Aayush gehi
*Servlet class used to interact with the dao layer to work with database
*and send the data to the database for user registration
*/
public class RegisterUserServlet extends HttpServlet {
	

	/**
	 *
	 */
	private static final long serialVersionUID = 8692647688395769854L;
	/**
	 *
	 */
	/*
	 * 
	 * Gets the data from front-end and posts it to the database using dao methods
	 */
	@Override
	public void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException 
	{
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String project = request.getParameter("project");
		IRegisterUserService user = new RegisterUserService();
		boolean isRegistered;
		JSONObject obj = new JSONObject();
		PrintWriter pw = response.getWriter();
		try 
		{
			isRegistered = user.isRegistered(username, password, project);
			if(isRegistered) 
			{
				
				obj.put("success", "200");
				pw.print(obj.toString());
			}
			else 
			{
				obj.put("success", "404");
				pw.print(obj.toString());
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
}
