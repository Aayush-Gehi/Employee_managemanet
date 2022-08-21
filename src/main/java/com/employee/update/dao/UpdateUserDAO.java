package com.employee.update.dao;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.employee.login.dao.LoginUserDAO;
import com.employee.register.dao.ProjectDetails;
import com.employee.register.dao.RegisterUser;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
/**
 *@author Aayush Gehi
 *This class interacts with the database to update the user details provided by the user and check whether the user 
 *entered is correct or not.
 */
public class UpdateUserDAO implements IUpdateUserDAO {
	/*
	 * returns the status of the user to be updated
	 */
	public boolean isUserUpdated( int userId , String newUsername , String newProject ) 
	{
		PropertyConfigurator.configure("log4j.properties");
		final Logger logger = Logger.getLogger(UpdateUserDAO.class);
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(RegisterUser.class);
		configuration.addAnnotatedClass(ProjectDetails.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query<RegisterUser> query = session.createQuery("FROM RegisterUser WHERE username=:username");
		query.setParameter("username", newUsername);
		RegisterUser user = query.uniqueResult();
		int id = user.getId();
		System.out.println(id);
		RegisterUser oldUser = session.load(RegisterUser.class,id);
		String[] newProjects = newProject.split(","); 
		List<String> proj = Arrays.asList(newProjects);
		boolean isUpdated=false;
		try
		{   
			oldUser.setUsername(newUsername);
			List<ProjectDetails> projects = proj.stream().map(ProjectDetails::new)
				    .collect(Collectors.toList());
			oldUser.setProjects(projects);
			session.update(oldUser);
			transaction.commit();
			isUpdated=true;
			
		}
			catch(HibernateException he) 
			{
				logger.error("Hibernate exception in update user dao due to "+he.getMessage());
				isUpdated=false;
			}
		return isUpdated;
	}
}
