package com.employee.display.servlet;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

import com.employee.display.service.DisplayUserService;
import com.employee.display.service.IDisplayUserService;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.simple.JSONObject;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
*@author Aayush gehi
*Servlet class used to interact with the dao layer to work with database
*and provide the user with the list of users demanded
*/
public class DisplayUserServlet extends HttpServlet {


	
	/**
	 *
	 */
	private static final long serialVersionUID = 7743365643079157525L;
	

	/**
	 *get method to get all the users from database and display the users to front-end
	 */

	@Override
	public void doGet(HttpServletRequest request ,  HttpServletResponse response) throws IOException 
	{
		PropertyConfigurator.configure("log4j.properties");
		final Logger logger = Logger.getLogger(DisplayUserServlet.class);
		response.setContentType("text/html");
		IDisplayUserService displayUser = new DisplayUserService();
		try 
		{
			Map<String , List<String> >userDetails =displayUser.displayUser();
			PrintWriter pw = response.getWriter();
			JSONObject obj = new JSONObject();
			obj.put("user",userDetails);
			pw.print(obj);
		}
		catch(Exception e) 
		{
			logger.error("Exception happend in displaying users due to "+e.getMessage());
		}
	}
}
