package com.employee.delete.dao;

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
*@author Aayush gehi
*Database interaction class to interact with database 
*and delete the user demanded 
*/
public class DeleteUserDAO implements IDeleteUserDAO {

	/*
	 * Returns the status of user deleted or not  
	 */
	@Override
	public boolean isDeleted( String username) {
		PropertyConfigurator.configure("log4j.properties");
		final Logger logger = Logger.getLogger(DeleteUserDAO.class);
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(RegisterUser.class);
		configuration.addAnnotatedClass(ProjectDetails.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		Session session = factory.openSession(); 
		Query<RegisterUser> query = session.createQuery("FROM RegisterUser where username=:username ");
		query.setParameter("username",username);
		boolean isDeleted = false;
		try 
		{
			RegisterUser user = query.uniqueResult();
			session.delete(user);
			Transaction transaction = session.beginTransaction();
			transaction.commit();
			isDeleted=true;
		}
		catch(HibernateException he ) 
		{
			logger.error("An hibernate exception occured in delete user dao due to "+he.getMessage());
		}
		return isDeleted;
	}

}
