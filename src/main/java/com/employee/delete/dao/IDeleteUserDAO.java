package com.employee.delete.dao;
/**
*@author Aayush gehi
*The user of this interface has the control to delete the user provided by the user
*/
public interface IDeleteUserDAO {
	/*
	 * Returns the status of the user whether deleted or not
	 */
public boolean isDeleted( String username);
}
