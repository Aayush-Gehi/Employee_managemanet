package com.employee.register.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
/**
*@author Aayush gehi
*this class interacts with the database to register the user with the details provided by the user.
*/
public class RegisterNewUser implements IRegisterNewUser{

	/*
	 * returns the status of user whether the user details provided are posted in the database
	 * @see com.employee.register.dao.IRegisterNewUser#registerUser(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean registerUser(String username, String password, String project) {
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(RegisterUser.class);
		configuration.addAnnotatedClass(ProjectDetails.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isRegistered=false;
		try 
		{
			RegisterUser user = new RegisterUser(username, password);
			ProjectDetails projectDetails = new ProjectDetails(project);
			ProjectDetails projectDetails1 = new ProjectDetails("trial");
			user.getProjects().add(projectDetails);
			user.getProjects().add(projectDetails1);
			session.save(projectDetails1);
			session.save(projectDetails);
			session.save(user);
			transaction.commit();
			isRegistered = true;
			session.close();
		}
		catch(HibernateException he) 
		{
			he.printStackTrace();
		}
		return isRegistered;
	}

}
