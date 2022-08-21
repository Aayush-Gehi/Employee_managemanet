package com.employee.login.dao;
/**
*@author Aayush gehi
*Class defined to interact with the database to check the status of login with 
*credentials provided by the user
*/
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class LoginUserDAO implements ILoginUserDAO{

	/*
	 * 
	 * Returns the status of user login  
	 */
	@Override
	public boolean isValidUser(String username, String password) {
		PropertyConfigurator.configure("log4j.properties");
		final Logger logger = Logger.getLogger(LoginUserDAO.class);
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(User.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.openSession();
		
		boolean isLoggedIn=false;
		try 
		{
			Query<User> query = session.createQuery("FROM User where lower(username)=:username and password=:password");
			query.setParameter("username" , username.toLowerCase());
			query.setParameter("password", password);
			User user = query.uniqueResult();
			if(user!=null) 
			{
				isLoggedIn = true;
			}
			else 
			{
				logger.warn("User entered does not exists");
			}
			session.close();
		}
		catch(HibernateException he) 
		{
			logger.error("An exception occured while initializing hibernate");
		}
		return isLoggedIn;
	}

}
