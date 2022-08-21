package com.employee.update.dao;
/**
*@author Aayush gehi
*The user of this interface will have the control to update the user details provides by the user
*/
public interface IUpdateUserDAO {
	/*
	 * returns the status of the user to be updated
	 */
public boolean isUserUpdated(int userId , String newUsername , String newProjects);
}
