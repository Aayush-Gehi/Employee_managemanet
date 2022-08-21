package com.employee.login.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.employee.login.dao.LoginUserDAO;
import com.employee.login.service.ILoginUserService;
import com.employee.login.service.LoginUserService;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.simple.JSONObject;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
*@author Aayush gehi
*Servlet class used to interact with the dao layer to work with database
*and check the credentials entered by the user are correct or not.
*/
public class LoginUserServlet extends HttpServlet {




	/**
	 *
	 */
	private static final long serialVersionUID = 2299395451777046162L;
	/**
	 *Post method to check the credibility of  the user for login
	 */


	@Override
	public void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException 
	{
		PropertyConfigurator.configure("log4j.properties");
		final Logger logger = Logger.getLogger(LoginUserServlet.class);
		response.setContentType("text/html");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		ILoginUserService user = new LoginUserService();
		boolean isLoggedIn;
		JSONObject obj = new JSONObject();
		PrintWriter pw = response.getWriter();
		try 
		{
			isLoggedIn = user.isLoggedIn(username, password);
			if(isLoggedIn) 
			{
				
				obj.put("success", "200");
				pw.print(obj.toString());
			}
			else 
			{
				logger.warn("Username or password was incorrect");
				obj.put("success", "404");
				pw.print(obj.toString());
			}
		}
		catch(Exception e) 
		{
			logger.error("Exception occured in login servlet");
		}
	}
}
