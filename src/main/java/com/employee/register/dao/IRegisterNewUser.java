package com.employee.register.dao;
/**
*@author Aayush gehi
*The user of this interface interacts with the database to register the user with the details provided by the user.
*/
public interface IRegisterNewUser {
	/*
	 * returns the status of user whether the user details provided are posted in the database
	 * @see com.employee.register.dao.IRegisterNewUser#registerUser(java.lang.String, java.lang.String, java.lang.String)
	 */
public boolean registerUser(String username , String password , String project);
}
