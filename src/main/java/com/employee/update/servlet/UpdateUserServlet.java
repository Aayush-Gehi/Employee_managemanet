package com.employee.update.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Transaction;

import com.employee.login.dao.LoginUserDAO;
import com.employee.register.dao.ProjectDetails;
import com.employee.register.dao.RegisterUser;
import com.employee.update.service.IUpdateUserService;
import com.employee.update.service.UpdateUserService;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.json.simple.JSONObject;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
*@author Aayush gehi
*Servlet class used to interact with the dao layer to work with database
*and update the details of the user provide by the user
*/
public class UpdateUserServlet extends HttpServlet{

	/**
	 *
	 */
	private static final long serialVersionUID = 7181401374706455291L;
	/**
	 *Takes the input from front-end and checks for it in the database and update the details by using 
	 *dao layer method 
	 */


	@Override
	public void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException 
	{
		PropertyConfigurator.configure("log4j.properties");
		final Logger logger = Logger.getLogger(UpdateUserServlet.class);
		response.setContentType("text/html");
		String userID = request.getParameter("id");
		int idUser = Integer.parseInt(userID);
		String newUsername = request.getParameter("username");
		String newProject = request.getParameter("projects");
		JSONObject obj = new JSONObject();
		PrintWriter pw = response.getWriter();
		IUpdateUserService user = new UpdateUserService();
		boolean isUserUpdated = user.isUserUpdated(idUser, newUsername, newProject);
		try 
		{
			if(isUserUpdated) 
			{
				obj.put("Status", "200");
				pw.print(obj.toString());
			}
			else 
			{
				logger.warn("User cannot register due to error");
				obj.put("Status", "500");
				pw.print(obj.toString());
			}
		}
		catch(Exception e) 
		{
			logger.error("Exception occured in update user servlet");
		}
		
			}
	
	}

