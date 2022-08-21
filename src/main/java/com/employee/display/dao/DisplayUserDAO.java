package com.employee.display.dao;

import java.io.PrintWriter;
import java.util.*;

import com.employee.login.dao.LoginUserDAO;
import com.employee.register.dao.ProjectDetails;
import com.employee.register.dao.RegisterUser;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.json.simple.JSONObject;
/*
 * @author Aayush Gehi
 * A class used by the user to display all the users present in the database with the detial's of the projects they are involved */

public class DisplayUserDAO implements IDisplayUserDAO{
/*
 *Returns the list of user and project details's in a dictionary format with users as key and their projects as the values which is list of string 
 * @see com.employee.display.dao.IDisplayUserDAO#displayUser()
 */
	
	@Override
	public Map<String , List<String> > displayUser() {
		PropertyConfigurator.configure("log4j.properties");
		final Logger logger = Logger.getLogger(DisplayUserDAO.class);
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(RegisterUser.class);
		configuration.addAnnotatedClass(ProjectDetails.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.openSession(); 
		
        Map<String , List<String> > userDetails = new LinkedHashMap<>();
		try 
		{
			 List users = session.createQuery("FROM RegisterUser").list(); 
	         for (Iterator iterator1 = users.iterator(); iterator1.hasNext();){
	            RegisterUser userDisplay = (RegisterUser) iterator1.next();
	            List<String> projectNames = new ArrayList<>();
	            List certificates = userDisplay.getProjects();
	            for (Iterator iterator2 = certificates.iterator(); iterator2.hasNext();){
	               ProjectDetails projectName = (ProjectDetails) iterator2.next();  
	               projectNames.add(projectName.getProject());
	            }
	            userDetails.put(userDisplay.getUsername(), projectNames);
	         }
	         
		}
		catch(HibernateException he ) 
		{
			logger.error("Hibernate exception occured in display user dao due to "+he.getMessage());
		}
		return userDetails;
		
	}

}
