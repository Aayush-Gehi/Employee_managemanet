package com.employee.login.dao;
/**
*@author Aayush gehi
*The user of this interface the control to check that the login credentials 
*provided by the user are correct or incorrect
*/
public interface ILoginUserDAO {
	/*
	 * Returns the status of the login with the credentials provided by the user 
	 */
public boolean isValidUser(String username , String password);
}
